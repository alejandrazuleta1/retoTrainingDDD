package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Challenge.Challenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.AgregarEjercicioAKata;

public class AddExerciseToKataUseCase extends UseCase<RequestCommand<AgregarEjercicioAKata>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEjercicioAKata> agregarEjercicioAKataRequestCommand) {
        var command = agregarEjercicioAKataRequestCommand.getCommand();
        var challenge = Challenge.from(command.getChallengeId(),retrieveEvents());
        challenge.addExerciseOfKata(command.getKataId(), command.getExcercise());
        emit().onSuccess(new ResponseEvents(challenge.getUncommittedChanges()));

    }
}
