package co.com.sofka.retoTrainingDDD.domain.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Email;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Gender;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.MemberId;

public class UpdateMember extends DomainEvent {
    private final MemberId memberId;
    private final Gender gender;
    private final Email email;

    public UpdateMember(MemberId memberId, Gender gender, Email email) {
        super("Clan.UpdateMember");
        this.memberId = memberId;
        this.gender = gender;
        this.email = email;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public Gender getGender() {
        return gender;
    }

    public Email getEmail() {
        return email;
    }
}
