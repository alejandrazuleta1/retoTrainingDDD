package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Dojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.commands.AgregarReglasAlDojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.commands.CambiarUrlMeetDojo;

public class ChangeMeetUrlDojoUseCase extends UseCase<RequestCommand<CambiarUrlMeetDojo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarUrlMeetDojo> cambiarUrlMeetDojoRequestCommand) {
        var command = cambiarUrlMeetDojoRequestCommand.getCommand();
        var dojo = Dojo.from(command.getDojoId(),retrieveEvents());
        dojo.changeLocation(command.getLocation());
        emit().onSuccess(new ResponseEvents(dojo.getUncommittedChanges()));
    }
}
