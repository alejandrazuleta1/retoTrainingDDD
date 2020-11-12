package co.com.sofka.retoTrainingDDD.domain.Dojo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Location;

public class CambiarUrlMeetDojo implements Command {
    private final DojoId dojoId;
    private final Location location;

    public CambiarUrlMeetDojo(DojoId dojoId, Location location) {
        this.dojoId = dojoId;
        this.location = location;
    }

    public DojoId getDojoId() {
        return dojoId;
    }

    public Location getLocation() {
        return location;
    }
}
