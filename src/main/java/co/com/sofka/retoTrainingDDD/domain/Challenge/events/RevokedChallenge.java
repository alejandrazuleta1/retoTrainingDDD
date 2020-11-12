package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;

public class RevokedChallenge extends DomainEvent {
    public RevokedChallenge() {
        super("Challenge.RevokedChallenge");
    }
}
