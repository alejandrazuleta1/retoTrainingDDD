package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Clan.commands.AgregarMiembroAClan;

public class AddMemberToClan extends UseCase<RequestCommand<AgregarMiembroAClan>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarMiembroAClan> agregarMiembroAClanRequestCommand) {

    }
}
