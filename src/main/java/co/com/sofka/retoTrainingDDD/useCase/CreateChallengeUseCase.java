package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Challenge.Challenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.CrearChallenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;

public class CreateChallengeUseCase extends UseCase<RequestCommand<CrearChallenge>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearChallenge> crearChallengeRequestCommand) {
        var command = crearChallengeRequestCommand.getCommand();
        var challenge = new Challenge(new ChallengeId(command.getChallengeId().value()), command.getName(),command.getClanIdList(),command.getDojoId(),command.getKatas(), command.getAssessment(), command.getDurationDays());
        emit().onSuccess(new ResponseEvents(challenge.getUncommittedChanges()));
    }
}
