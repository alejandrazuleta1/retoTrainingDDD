package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Location;

public class ChangedLocation extends DomainEvent {
    private final Location location;

    public ChangedLocation(Location location) {
        super("Dojo.ChangedLocation");
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
