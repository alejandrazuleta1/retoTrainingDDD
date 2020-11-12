package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Challenge.Challenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.AgregarKatasAlChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.entities.Kata;
import co.com.sofka.retoTrainingDDD.domain.Clan.commands.AgregarMiembroAClan;

public class AddKatasToChallengeUseCase extends UseCase<RequestCommand<AgregarKatasAlChallenge>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarKatasAlChallenge> agregarKatasAlChallengeRequestCommand) {
        var command = agregarKatasAlChallengeRequestCommand.getCommand();
        var challenge = Challenge.from(command.getChallengeId(), retrieveEvents());
        for(Kata kata : command.getKatas()){
            challenge.addNewKata(kata);
        }
        emit().onSuccess(new ResponseEvents(challenge.getUncommittedChanges()));
    }
}
