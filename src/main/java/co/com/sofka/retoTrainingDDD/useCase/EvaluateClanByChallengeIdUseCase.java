package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.RevokedChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Score;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.EvaluatedClan;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Date;
import co.com.sofka.retoTrainingDDD.useCase.service.ListaPuntajesClanesService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow;

@EventListener(eventType = "Challenge.RevokedChallenge")
public class EvaluateClanByChallengeIdUseCase extends UseCase<TriggeredEvent<RevokedChallenge>, ResponseEvents> {
    private final UpdateMemberScoresUseCase updateMemberScoresUseCase;
    private final Flow.Subscriber<? super DomainEvent> subscriber;

    public EvaluateClanByChallengeIdUseCase(UpdateMemberScoresUseCase updateMemberScoresUseCase, Flow.Subscriber<? super DomainEvent> subscriber) {
        this.updateMemberScoresUseCase = updateMemberScoresUseCase;
        this.subscriber = subscriber;
    }

    @Override
    public void executeUseCase(TriggeredEvent<RevokedChallenge> revokedChallengeTriggeredEvent) {
        var event = revokedChallengeTriggeredEvent.getDomainEvent();
        var challengeId = ChallengeId.of(event.aggregateRootId());
        var service = getService(ListaPuntajesClanesService.class).orElseThrow();
        var mapPuntosByClanId = service.getListaPuntajesClanes(challengeId);

        if(mapPuntosByClanId != null) {
            for (Map.Entry<ClanId,Integer> entry : mapPuntosByClanId.getPuntajeClanes().entrySet()) {
                EvaluatedClan evaluatedClan = new EvaluatedClan(ClanId.of(entry.getKey().value()),new Score(entry.getValue(), DojoId.of("20202"), new Date("12/11/2020")));

                UseCaseHandler.getInstance()
                        .setIdentifyExecutor(evaluatedClan.getClanId().value())
                        .asyncExecutor(updateMemberScoresUseCase, new TriggeredEvent<>(evaluatedClan))
                        .subscribe(subscriber);
                //emit().onSuccess(new ResponseEvents(List.of()));
            }
        }
        emit().onSuccess(new ResponseEvents(List.of()));
    }
}
