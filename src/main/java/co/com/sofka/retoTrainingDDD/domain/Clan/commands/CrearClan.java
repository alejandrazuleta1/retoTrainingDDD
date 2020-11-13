package co.com.sofka.retoTrainingDDD.domain.Clan.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.Clan.entities.Member;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.GroupGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;

import java.util.List;

public class CrearClan implements Command {
    private final ClanId clanId;
    private final List<Member> members;
    private final GroupGit groupGit;
    private final Name name;

    public CrearClan(ClanId clanId, List<Member> members, GroupGit groupGit, Name name) {
        this.clanId = clanId;
        this.members = members;
        this.groupGit = groupGit;
        this.name = name;
    }

    public ClanId getClanId() {
        return clanId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public GroupGit getGroupGit() {
        return groupGit;
    }

    public Name getName() {
        return name;
    }
}
