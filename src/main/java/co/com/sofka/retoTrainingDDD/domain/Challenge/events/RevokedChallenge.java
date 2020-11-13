package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Score;

public class RevokedChallenge extends DomainEvent {

    public RevokedChallenge() {
        super("Challenge.RevokedChallenge");
    }
}
