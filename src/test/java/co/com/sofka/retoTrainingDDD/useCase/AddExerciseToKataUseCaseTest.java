package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.AgregarEjercicioAKata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.entities.Kata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.AddedExerciseOfKata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.AddedKata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.CreatedChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.SubscribedClan;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Assessment;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Excercise;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.KataId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AddExerciseToKataUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void addExerciseToKataTest() throws InterruptedException{
        Map<Object, Object> metaData = new HashMap<Object, Object>();
        var agregarEjercicioACata = new AgregarEjercicioAKata(ChallengeId.of("10"), KataId.of("2"),new Excercise(5,metaData,"Aprender DDD"));

        AddExerciseToKataUseCase useCase = new AddExerciseToKataUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedChallenge(
                        ChallengeId.of("10"),
                        new Name("DDD"),
                        new ArrayList<>(),
                        new DojoId("3"),
                        new ArrayList<>(),
                        new Assessment(2,"gituhb.com/Challenge","repo con el codigo"),
                        4),
                new AddedKata(new Kata(new KataId("2"),"manejar DDD",new ArrayList<>(),"realizar el modelo de un juego simple",24))
        ));

        useCase.addRepository(repository);

        UseCaseHandler.getInstance()
                .setIdentifyExecutor(ChallengeId.of("10").value())
                .asyncExecutor(useCase,new RequestCommand<>(agregarEjercicioACata))
                .subscribe(subscriber);
        Thread.sleep(1000);

        verify(subscriber,times(1)).onNext(eventCaptor.capture());
        AddedExerciseOfKata addedExerciseOfKata = (AddedExerciseOfKata) eventCaptor.getAllValues().get(0);
        System.out.println(addedExerciseOfKata.getExcercise().value().goal());
    }
}