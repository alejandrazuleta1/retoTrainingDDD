package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Challenge.Challenge;
import co.com.sofka.retoTrainingDDD.domain.Challenge.commands.EliminarEjercicioDeKata;

public class DeleteExerciseOfKataUseCase extends UseCase<RequestCommand<EliminarEjercicioDeKata>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EliminarEjercicioDeKata> eliminarEjercicioDeKataRequestCommand) {
        var command = eliminarEjercicioDeKataRequestCommand.getCommand();
        var challenge = Challenge.from(command.getChallengeId(),retrieveEvents());
        challenge.deleteExerciseOfKata(command.getKataId(), command.getExcercise());
        emit().onSuccess(new ResponseEvents(challenge.getUncommittedChanges()));
    }
}