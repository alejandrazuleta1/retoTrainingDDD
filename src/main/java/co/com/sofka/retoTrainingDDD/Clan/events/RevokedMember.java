package co.com.sofka.retoTrainingDDD.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.Clan.valueObjects.MemberId;

public class RevokedMember extends DomainEvent {
    private final MemberId memberId;

    public RevokedMember(MemberId memberId) {
        super("Clan.RevokedMember");
        this.memberId = memberId;
    }

    public MemberId getMemberId() {
        return memberId;
    }
}
