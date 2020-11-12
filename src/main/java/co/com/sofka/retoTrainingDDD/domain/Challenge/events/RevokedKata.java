package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;

public class RevokedKata extends DomainEvent {
    public RevokedKata() {
        super("Challenge.RevokedKata");
    }
}