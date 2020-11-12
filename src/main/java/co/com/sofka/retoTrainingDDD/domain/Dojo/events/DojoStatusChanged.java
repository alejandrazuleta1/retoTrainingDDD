package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Status;

public class DojoStatusChanged extends DomainEvent {

    private final Status status;

    public DojoStatusChanged(Status status) {
        super("Dojo.DojoStatusChanged");
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
