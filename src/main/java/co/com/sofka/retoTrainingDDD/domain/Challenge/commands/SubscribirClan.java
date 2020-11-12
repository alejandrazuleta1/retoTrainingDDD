package co.com.sofka.retoTrainingDDD.domain.Challenge.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;

public class SubscribirClan implements Command {
    private final ChallengeId challengeId;
    private final ClanId clanId;

    public SubscribirClan(ChallengeId challengeId, ClanId clanId) {
        this.challengeId = challengeId;
        this.clanId = clanId;
    }

    public ChallengeId getChallengeId() {
        return challengeId;
    }

    public ClanId getClanId() {
        return clanId;
    }
}