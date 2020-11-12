package co.com.sofka.retoTrainingDDD.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.VOShared.Name;

public class UpdatedName extends DomainEvent {
    private final Name name;

    public UpdatedName(Name name) {
        super("Clan.UpdatedName");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
