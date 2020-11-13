package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.RevokedChallenge;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.AddedMember;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.CreatedClan;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.UpdatedScoreOfMember;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.VOShared.*;
import co.com.sofka.retoTrainingDDD.useCase.model.PuntajeClanes;
import co.com.sofka.retoTrainingDDD.useCase.service.ListaPuntajesClanesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class EvaluateClanByChallengeIdUseCaseTest extends  UseCaseHandleBaseTest{
    private static final String CHALLENGE_ID = "1";

    @Mock
    private ListaPuntajesClanesService listaPuntajesClanesService;

    @Spy
    private UpdateMemberScoresUseCase updateMemberScoresUseCase;

    @BeforeEach
    public void setup(){
        var repository = mock(DomainEventRepository.class);
        var addedMember1 = new AddedMember(
                new MemberId("1"),
                new Name("Alejandra Zuleta"),
                new Gender("F"),
                Boolean.FALSE,
                new PersonId("1087234567"),
                new MemberGit(2,"www.linkdeimagen.com","alejandra.zuleta"),
                new Email("alejandra.zuleta@sofka.com.co"),
                new ArrayList<>());
        addedMember1.setAggregateRootId(ClanId.of("1").value());

        var addedMember2 = new AddedMember(
                new MemberId("1"),
                new Name("wer Zuleta"),
                new Gender("M"),
                Boolean.FALSE,
                new PersonId("103155953"),
                new MemberGit(3,"www.linkdeimagen2.com","alejandro.zuleta"),
                new Email("alejandra.zuleta@sofka.com.co"),
                new ArrayList<>());
        addedMember2.setAggregateRootId(ClanId.of("1").value());

        var addedMember3 = new AddedMember(
                new MemberId("1"),
                new Name("ASFFFD"),
                new Gender("F"),
                Boolean.FALSE,
                new PersonId("1087234567"),
                new MemberGit(2,"www.linkdeimagen.com","alejandra.zuleta"),
                new Email("alejandra.zuleta@sofka.com.co"),
                new ArrayList<>());
        addedMember3.setAggregateRootId(ClanId.of("2").value());

        var addedMember4 = new AddedMember(
                new MemberId("1"),
                new Name("Alejandro Zuleta"),
                new Gender("M"),
                Boolean.FALSE,
                new PersonId("103155953"),
                new MemberGit(3,"www.linkdeimagen2.com","alejandro.zuleta"),
                new Email("alejandra.zuleta@sofka.com.co"),
                new ArrayList<>());
        addedMember4.setAggregateRootId(ClanId.of("2").value());

        var createdClan1 = new CreatedClan(ClanId.of("1"),
                new ArrayList<>(),
                new GroupGit(12,new Path("path1"),new Name("grupo1")),
                new Name("Serway"));
        createdClan1.setAggregateRootId(ClanId.of("1").value());

        var createdClan2 = new CreatedClan(ClanId.of("2"),
                new ArrayList<>(),
                new GroupGit(11,new Path("path2"),new Name("grupo2")),
                new Name("Serway"));
        createdClan2.setAggregateRootId(ClanId.of("2").value());

        when(repository.getEventsBy(any())).thenReturn(List.of(
                createdClan1,
                addedMember1,
                addedMember2,
                createdClan2,
                addedMember3,
                addedMember4
        ));
        updateMemberScoresUseCase.addRepository(repository);
    }

    @Test
    void evaluateClanByChallengeId() throws InterruptedException{
        RevokedChallenge revokedChallenge = new RevokedChallenge();
        revokedChallenge.setAggregateRootId(CHALLENGE_ID);

        when(listaPuntajesClanesService.getListaPuntajesClanes(any())).thenReturn(new PuntajeClanes(Map.of(new ClanId("1"),20,
                new ClanId("2"),5)));

        /*when(repository.getEventsBy(anyString())).thenAnswer(new Answer<List<DomainEvent>>() {
            @Override
            public List<DomainEvent> answer(InvocationOnMock invocationOnMock) throws Throwable {
                return List.of(
                        new CreatedChallenge(
                                ChallengeId.of("10"),
                                new Name("DDD"),
                                new ArrayList<>(),
                                new DojoId("3"),
                                new ArrayList<>(),
                                new Assessment(2,"gituhb.com/Challenge","repo con el codigo"),
                                4),
                        new SubscribedClan(ClanId.of("1")),
                        new SubscribedClan(ClanId.of("2"))
                );
            }
        });*/

        EvaluateClanByChallengeIdUseCase useCase = new EvaluateClanByChallengeIdUseCase(updateMemberScoresUseCase,subscriber);
        //useCase.addRepository(repository);

        useCase.addServiceBuilder(
                new ServiceBuilder()
                        .addService(listaPuntajesClanesService)
        );

        //accion
        UseCaseHandler.getInstance()
                .setIdentifyExecutor(CHALLENGE_ID)
                .asyncExecutor(useCase, new TriggeredEvent<>(revokedChallenge))
                .subscribe(subscriber);
        Thread.sleep(1000);

        //verificacion
        verify(subscriber, times(2)).onNext(eventCaptor.capture());
        List<UpdatedScoreOfMember> updatedScoreOfMemberList = new ArrayList<>();
        updatedScoreOfMemberList.add((UpdatedScoreOfMember) eventCaptor.getAllValues().get(0));
        updatedScoreOfMemberList.add((UpdatedScoreOfMember) eventCaptor.getAllValues().get(1));
        updatedScoreOfMemberList.forEach(up-> System.out.println(up.getScore().value().point()));
    }

}