package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.annotation.EventListener;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.Clan;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.EvaluatedClan;

@EventListener(eventType = "Dojo.EvaluatedClan")
public class UpdateMemberScoresUseCase extends UseCase<TriggeredEvent<EvaluatedClan>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<EvaluatedClan> evaluatedClanTriggeredEvent) {
        var event = evaluatedClanTriggeredEvent.getDomainEvent();
        var clan = Clan.from(event.getClanId(),retrieveEvents());
        clan.addScoreToMember(event.getScore());
        emit().onSuccess(new ResponseEvents(clan.getUncommittedChanges()));
    }
}
