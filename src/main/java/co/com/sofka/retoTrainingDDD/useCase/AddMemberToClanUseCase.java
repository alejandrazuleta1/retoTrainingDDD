package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.retoTrainingDDD.domain.Clan.Clan;
import co.com.sofka.retoTrainingDDD.domain.Clan.commands.AgregarMiembroAClan;

public class AddMemberToClanUseCase extends UseCase<RequestCommand<AgregarMiembroAClan>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarMiembroAClan> agregarMiembroAClanRequestCommand) {
        var command = agregarMiembroAClanRequestCommand.getCommand();
        var clan = Clan.from(command.getClanId(),retrieveEvents());
        clan.addNewMember(command.getMemberId(),
                command.getName(),
                command.getGender(),
                command.getOwner(),
                command.getPersonId(),
                command.getMemberGit(),
                command.getEmail(),
                command.getScores());
        emit().onSuccess(new ResponseEvents(clan.getUncommittedChanges()));
    }
}
