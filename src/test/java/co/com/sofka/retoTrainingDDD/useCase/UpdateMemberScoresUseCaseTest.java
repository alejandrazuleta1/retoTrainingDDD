package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.AddedMember;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.CreatedClan;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.UpdatedScoreOfMember;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.EvaluatedClan;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UpdateMemberScoresUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void updateMemberScoresTest() throws InterruptedException{
        UpdateMemberScoresUseCase useCase = new UpdateMemberScoresUseCase();
        EvaluatedClan evaluatedClan = new EvaluatedClan(ClanId.of("1"),new Score(10, DojoId.of("20202"), new Date("12/11/2020")));

        var addedMember = new AddedMember(
                new MemberId("1"),
                new Name("Juan"),
                new Gender("M"),
                Boolean.FALSE,
                new PersonId("1087234567"),
                new MemberGit(2,"www.linkdeimagen.com","juan.zuleta"),
                new Email("juan.zuleta@sofka.com.co"),
                new ArrayList<>());
        addedMember.setAggregateRootId(ClanId.of("2").value());

        var addedMember2 = new AddedMember(
                new MemberId("1"),
                new Name("Alejandro Zuleta"),
                new Gender("M"),
                Boolean.FALSE,
                new PersonId("103155953"),
                new MemberGit(3,"www.linkdeimagen2.com","alejandro.zuleta"),
                new Email("alejandra.zuleta@sofka.com.co"),
                new ArrayList<>());
        addedMember2.setAggregateRootId(ClanId.of("2").value());

        var createdClan1 = new CreatedClan(ClanId.of("1"),
                new ArrayList<>(),
                new GroupGit(12,new Path("path1"),new Name("grupo1")),
                new Name("Serway"));
        createdClan1.setAggregateRootId(ClanId.of("1").value());

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                createdClan1,
                addedMember,
                addedMember2
        ));

        useCase.addRepository(repository);
        UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .asyncExecutor(useCase, new TriggeredEvent<>(evaluatedClan))
                .subscribe(subscriber);
        Thread.sleep(1000);

        verify(subscriber, times(1)).onNext(eventCaptor.capture());
        UpdatedScoreOfMember updatedScoreOfMember = (UpdatedScoreOfMember) eventCaptor.getAllValues().get(0);
        System.out.println(updatedScoreOfMember.getScore().value().point());
    }
}