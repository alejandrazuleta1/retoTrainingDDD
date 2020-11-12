package co.com.sofka.retoTrainingDDD.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.Clan.entities.Member;
import co.com.sofka.retoTrainingDDD.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.Clan.valueObjects.Color;
import co.com.sofka.retoTrainingDDD.Clan.valueObjects.GroupGit;
import co.com.sofka.retoTrainingDDD.VOShared.Name;

import java.util.List;

public class CreatedClan extends DomainEvent {
    private final ClanId clanId;
    private final List<Member> members;
    private final GroupGit groupGit;
    private final Color color;
    private final Name name;

    public CreatedClan(ClanId entityId, List<Member> members, GroupGit groupGit, Color color, Name name) {
        super("Clan.CreatedClan");
        this.clanId = entityId;
        this.members = members;
        this.groupGit = groupGit;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public Name getName() {
        return name;
    }
}
