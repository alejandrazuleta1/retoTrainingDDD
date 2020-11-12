package co.com.sofka.retoTrainingDDD.domain.Clan.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Email;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Gender;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.MemberId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Score;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;

import java.util.List;

public class Member extends Entity<MemberId> {
    private final Name name;
    private Gender gender;
    private final Boolean isOwner;
    private final PersonId personId;
    private final MemberGit memberGit;
    private Email email;
    private List<Score> scores;

    public Member(MemberId entityId, Name name, Gender gender, Boolean isOwner, PersonId personId, MemberGit memberGit, Email email, List<Score> scores) {
        super(entityId);
        this.name = name;
        this.gender = gender;
        this.isOwner = isOwner;
        this.personId = personId;
        this.memberGit = memberGit;
        this.email = email;
        this.scores = scores;
    }

    public void addScore(Score score){
        scores.add(score);
    }

    public void upDateEmail(Email email){
        this.email = email;
    }

    public void upDateGender(Gender gender){
        this.gender = gender;
    }

    public Name Name() {
        return name;
    }

    public Gender Gender() {
        return gender;
    }

    public Boolean Owner() {
        return isOwner;
    }

    public PersonId PersonId() {
        return personId;
    }

    public MemberGit MemberGit() {
        return memberGit;
    }

    public Email Email() {
        return email;
    }

    public List<Score> Scores() {
        return scores;
    }
}
