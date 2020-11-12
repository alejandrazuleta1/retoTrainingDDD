package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Dojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.commands.CrearDojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;

public class CreateDojoUseCase extends UseCase<RequestCommand<CrearDojo>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearDojo> crearDojoRequestCommand) {
        var command = crearDojoRequestCommand.getCommand();
        var dojo = new Dojo(new DojoId(command.getDojoId().value()),command.getDataInfo(),command.getRules(), command.getGroupGit(), command.getLocation());
        dojo.assignSensei(command.getSensei().identity(),
                command.getSensei().Name(),
                command.getSensei().PersonId(),
                command.getSensei().Specialty(),
                command.getSensei().MemberGit(),
                command.getSensei().AccomplishmentList());
        emit().onSuccess(new ResponseEvents(dojo.getUncommittedChanges()));
    }
}
