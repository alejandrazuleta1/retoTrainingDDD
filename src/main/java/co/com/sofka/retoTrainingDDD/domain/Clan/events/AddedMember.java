package co.com.sofka.retoTrainingDDD.domain.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Email;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Gender;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.MemberId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Score;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;

import java.util.List;

public class AddedMember extends DomainEvent {
    private final MemberId memberId;
    private final Name name;
    private final Gender gender;
    private final Boolean isOwner;
    private final PersonId personId;
    private final MemberGit memberGit;
    private final Email email;
    private final List<Score> scores;

    public AddedMember(MemberId memberId, Name name, Gender gender, Boolean isOwner, PersonId personId, MemberGit memberGit, Email email, List<Score> scores) {
        super("Clan.AddedMember");
        this.memberId = memberId;
        this.name = name;
        this.gender = gender;
        this.isOwner = isOwner;
        this.personId = personId;
        this.memberGit = memberGit;
        this.email = email;
        this.scores = scores;
    }

    public Name getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Boolean getOwner() {
        return isOwner;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public MemberGit getMemberGit() {
        return memberGit;
    }

    public Email getEmail() {
        return email;
    }

    public List<Score> getScores() {
        return scores;
    }

    public MemberId getMemberId() {
        return memberId;
    }
}
