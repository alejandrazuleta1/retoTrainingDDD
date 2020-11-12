package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.SubscribirClan;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.CreatedChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.SubscribedClan;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Assessment;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.AddedMember;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class SubscribeAClanUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void susbriveAClan(){
        SubscribirClan subscribirClan = new SubscribirClan(ChallengeId.of("10"), ClanId.of("2"));
        SubscribeAClanUseCase useCase = new SubscribeAClanUseCase();

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
                .asyncExecutor(useCase,new RequestCommand<>(subscribirClan))
                .subscribe(subscriber);

        verify(subscriber,times(1)).onNext(eventCaptor.capture());
        SubscribedClan subscribedClan = (SubscribedClan) eventCaptor.getAllValues().get(0);
        System.out.println(subscribedClan.getClanId().value());

    }
}