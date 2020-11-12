package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.CrearChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.entities.Kata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.CreatedChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Assessment;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Excercise;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.KataId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateChallengeUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void createChallengeUseCaseTest() throws InterruptedException{
        DojoId dojoId = new DojoId("1");

        List<ClanId> clanIdList = new ArrayList<>();
        clanIdList.add(new ClanId("Clan1"));
        clanIdList.add(new ClanId("Clan2"));

        List<Kata> katas = new ArrayList<>();
        katas.add(new Kata(new KataId("1"),"manejar DDD",new ArrayList<>(),"realizar el modelo de un juego simple",24));

        CrearChallenge crearChallenge = new CrearChallenge(
            new ChallengeId("5"),
            new Name("DDD"),
            clanIdList,
            dojoId,
            katas,
            new Assessment(2,"gituhb.com/Challenge","repo con el codigo"),
            4);

        CreateChallengeUseCase useCase = new CreateChallengeUseCase();
        UseCaseHandler.getInstance()
                .asyncExecutor(
                        useCase,
                        new RequestCommand<>(crearChallenge))
                .subscribe(subscriber);
        Thread.sleep(1000);

        verify(subscriber,times(1)).onNext(eventCaptor.capture());
        CreatedChallenge createdChallenge = (CreatedChallenge) eventCaptor.getAllValues().get(0);
        System.out.println(crearChallenge.getName().value());
    }
}