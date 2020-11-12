package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Dojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.commands.AgregarReglasAlDojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Rule;

public class AddRulesToDojoUseCase extends UseCase<RequestCommand<AgregarReglasAlDojo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarReglasAlDojo> agregarRelasAlDojoRequestCommand) {
        var command = agregarRelasAlDojoRequestCommand.getCommand();
        var dojo = Dojo.from(command.getDojoId(),retrieveEvents());
        for (Rule rule : command.getRules()) {
            dojo.addRule(rule);
        }
        emit().onSuccess(new ResponseEvents(dojo.getUncommittedChanges()));
    }
}
