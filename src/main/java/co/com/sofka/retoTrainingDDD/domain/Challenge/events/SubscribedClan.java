package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;

public class SubscribedClan extends DomainEvent {
    private final ClanId clanId;

    public SubscribedClan(ClanId clanId) {
        super("Challenge.SubscribedClan");
        this.clanId = clanId;
    }

    public ClanId getClanId() {
        return clanId;
    }
}
