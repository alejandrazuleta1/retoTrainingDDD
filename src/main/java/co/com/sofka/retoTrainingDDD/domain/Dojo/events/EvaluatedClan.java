package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Score;

public class EvaluatedClan extends DomainEvent {
    private final ClanId clanId;
    private final Score score;

    public EvaluatedClan(ClanId clanId, Score score) {
        super("Dojo.EvaluatedClan");
        this.clanId = clanId;
        this.score = score;
    }

    public ClanId getClanId() {
        return clanId;
    }

    public Score getScore() {
        return score;
    }
}
