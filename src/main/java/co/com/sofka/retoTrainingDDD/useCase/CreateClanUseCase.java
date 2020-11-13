package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Clan.Clan;
import co.com.sofka.retoTrainingDDD.domain.Clan.commands.CrearClan;

public class CreateClanUseCase extends UseCase<RequestCommand<CrearClan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearClan> crearClanRequestCommand) {
        var command = crearClanRequestCommand.getCommand();
        var clan = new Clan(command.getClanId(),command.getMembers(), command.getGroupGit(), command.getName());
        emit().onSuccess(new ResponseEvents(clan.getUncommittedChanges()));
    }
}
