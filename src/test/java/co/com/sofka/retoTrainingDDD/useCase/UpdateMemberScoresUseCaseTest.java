package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.AddedMember;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.CreatedClan;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.UpdatedScoreOfMember;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.EvaluatedClan;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Date;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;
import org.junit.jupiter.api.BeforeEach;
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

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedClan(ClanId.of("20202"),
                        new ArrayList<>(),
                        new GroupGit("group4"),
                        new Name("Serway")),
                new AddedMember(
                        new MemberId("1"),
                        new Name("Alejandra Zuleta"),
                        new Gender("F"),
                        Boolean.FALSE,
                        new PersonId("1087234567"),
                        new MemberGit(2,"www.linkdeimagen.com","alejandra.zuleta"),
                        new Email("alejandra.zuleta@sofka.com.co"),
                        new ArrayList<>()),
                new AddedMember(
                        new MemberId("1"),
                        new Name("Alejandro Zuleta"),
                        new Gender("M"),
                        Boolean.FALSE,
                        new PersonId("103155953"),
                        new MemberGit(3,"www.linkdeimagen2.com","alejandro.zuleta"),
                        new Email("alejandra.zuleta@sofka.com.co"),
                        new ArrayList<>())
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