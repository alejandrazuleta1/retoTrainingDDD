package co.com.sofka.retoTrainingDDD.domain.Clan.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;

import java.util.List;

public class AgregarMiembroAClan implements Command {
    private final ClanId clanId;
    private final MemberId memberId;
    private final Name name;
    private final Gender gender;
    private final Boolean isOwner;
    private final PersonId personId;
    private final MemberGit memberGit;
    private final Email email;
    private final List<Score> scores;

    public AgregarMiembroAClan(ClanId clanId, MemberId memberId, Name name, Gender gender, Boolean isOwner, PersonId personId, MemberGit memberGit, Email email, List<Score> scores) {
        this.clanId = clanId;
        this.memberId = memberId;
        this.name = name;
        this.gender = gender;
        this.isOwner = isOwner;
        this.personId = personId;
        this.memberGit = memberGit;
        this.email = email;
        this.scores = scores;
    }

    public MemberId getMemberId() {
        return memberId;
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

    public ClanId getClanId() {
        return clanId;
    }
}
