package co.com.sofka.retoTrainingDDD.domain.Clan;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.entities.Member;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.*;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;

import java.util.List;
import java.util.Objects;

public class Clan extends AggregateEvent<ClanId> {

    protected List<Member> members;
    protected GroupGit groupGit;
    protected Color color;
    protected Name name;

    public Clan(ClanId entityId, List<Member> _members, GroupGit _groupGit, Color _color, Name _name) {
        super(entityId);
        var members = Objects.requireNonNull(_members);
        var groupGit = Objects.requireNonNull(_groupGit);
        var color = Objects.requireNonNull(_color);
        var name = Objects.requireNonNull(_name);
        appendChange(new CreatedClan(entityId,members,groupGit,color,name)).apply();
    }

    private Clan(ClanId entityId) {
        super(entityId);
        subscribe(new ClanEventChange(this));
    }

    public static Clan from(ClanId entityId, List<DomainEvent> eventList) {
        var Clan = new Clan(entityId);
        eventList.forEach(Clan::applyEvent);
        return Clan;
    }

    public void addNewMember(MemberId memberId,
                             Name name,
                             Gender gender,
                             Boolean isOwner,
                             PersonId personId,
                             MemberGit memberGit,
                             Email email,
                             List<Score> scores){
        appendChange(new AddedMember(memberId,name,gender,isOwner,personId,memberGit,email,scores)).apply();
    }

    public void revokeMember(MemberId memberId){
        appendChange(new RevokedMember(memberId)).apply();
    }

    public void applyColor(Color color){
        appendChange(new AppliedColor(color)).apply();
    }

    public void addScoreToMember(MemberId memberId,Score score){
        appendChange(new UpdatedScoreOfMember(memberId, score)).apply();
    }

    public void updateMember(MemberId memberId, Gender gender, Email email){
        appendChange(new UpdateMember(memberId,gender, email)).apply();
    }

    public void updateName(Name name){
        appendChange(new UpdatedName(name)).apply();
    }
}
