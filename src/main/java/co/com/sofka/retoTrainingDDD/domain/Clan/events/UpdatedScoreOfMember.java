package co.com.sofka.retoTrainingDDD.domain.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.MemberId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Score;

public class UpdatedScoreOfMember extends DomainEvent {
    private final MemberId memberId;
    private final Score score;

    public UpdatedScoreOfMember(MemberId memberId, Score score) {
        super("Clan.UpdatedScoreOfMember");
        this.memberId = memberId;
        this.score = score;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public Score getScore() {
        return score;
    }
}
