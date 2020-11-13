package co.com.sofka.retoTrainingDDD.domain.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.entities.Member;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.GroupGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;

import java.util.List;

public class CreatedClan extends DomainEvent {
    private final ClanId clanId;
    private final List<Member> members;
    private final GroupGit groupGit;
    private final Name name;

    public CreatedClan(ClanId entityId, List<Member> members, GroupGit groupGit, Name name) {
        super("Clan.CreatedClan");
        this.clanId = entityId;
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
