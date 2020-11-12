package co.com.sofka.retoTrainingDDD.domain.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.MemberId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Score;

public class UpdatedScoreOfMember extends DomainEvent {
    private final Score score;

    public UpdatedScoreOfMember(Score score) {
        super("Clan.UpdatedScoreOfMember");
        this.score = score;
    }
    public Score getScore() {
        return score;
    }
}
