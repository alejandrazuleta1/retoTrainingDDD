package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.AgregarKatasAlChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.entities.Kata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.AddedKata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.CreatedChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.SubscribedClan;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Assessment;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.KataId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AddKatasToChallengeUseCaseTest extends UseCaseHandleBaseTest{
    @Test
    void addKatasToChallenge()throws InterruptedException{
        List<Kata> katas = new ArrayList<>();
        katas.add(new Kata(new KataId("1"),"manejar lambda functions",new ArrayList<>(),"realizar el modelo de un juego simple",24));
        katas.add(new Kata(new KataId("2"),"manejar DDD",new ArrayList<>(),"realizar el modelo de un juego simple",24));
        AgregarKatasAlChallenge agregarKatasAlChallenge = new AgregarKatasAlChallenge(ChallengeId.of("12"),katas);

        AddKatasToChallengeUseCase useCase = new AddKatasToChallengeUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedChallenge(
                        ChallengeId.of("10"),
                        new Name("DDD"),
                        new ArrayList<>(),
                        new DojoId("3"),
                        new ArrayList<>(),
                        new Assessment(2,"gituhb.com/Challenge","repo con el codigo"),
                        4)
        ));

        useCase.addRepository(repository);

        UseCaseHandler.getInstance()
                .setIdentifyExecutor(ChallengeId.of("10").value())
                .asyncExecutor(useCase,new RequestCommand<>(agregarKatasAlChallenge))
                .subscribe(subscriber);
        Thread.sleep(1000);

        verify(subscriber,times(2)).onNext(eventCaptor.capture());
        AddedKata addedKata = (AddedKata) eventCaptor.getAllValues().get(0);
        System.out.println(addedKata.getKata().Purpose());
    }
}