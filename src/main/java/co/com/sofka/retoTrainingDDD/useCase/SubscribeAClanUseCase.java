package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Challenge.Challenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.SubscribirClan;

public class SubscribeAClanUseCase extends UseCase<RequestCommand<SubscribirClan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<SubscribirClan> subscribirClanRequestCommand) {
        var command = subscribirClanRequestCommand.getCommand();
        var challege = Challenge.from(command.getChallengeId(),retrieveEvents());
        challege.subscriberClan(command.getClanId());
        emit().onSuccess(new ResponseEvents(challege.getUncommittedChanges()));
    }
}
