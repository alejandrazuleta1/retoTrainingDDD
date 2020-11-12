package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;

public class UpdatedName extends DomainEvent {
    private final Name name;

    public UpdatedName(Name name) {
        super("Challenge.UpdatedName");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
