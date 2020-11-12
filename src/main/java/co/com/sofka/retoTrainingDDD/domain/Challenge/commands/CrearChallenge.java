package co.com.sofka.retoTrainingDDD.domain.Challenge.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.Challenge.entities.Kata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Assessment;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;

import java.util.List;

public class CrearChallenge implements Command {
    private final ChallengeId challengeId;
    private final  Name name;
    private final  List<ClanId> clanIdList;
    private final  DojoId dojoId;
    private final  List<Kata> katas;
    private final  Assessment assessment;
    private final  Integer durationDays;

    public CrearChallenge(ChallengeId challengeId,
                          Name name,
                          List<ClanId> clanIdList,
                          DojoId dojoId,
                          List<Kata> katas,
                          Assessment assessment,
                          Integer durationDays) {
        this.challengeId = challengeId;
        this.name = name;
        this.clanIdList = clanIdList;
        this.dojoId = dojoId;
        this.katas = katas;
        this.assessment = assessment;
        this.durationDays = durationDays;
    }

    public ChallengeId getChallengeId() {
        return challengeId;
    }

    public Name getName() {
        return name;
    }

    public List<ClanId> getClanIdList() {
        return clanIdList;
    }

    public DojoId getDojoId() {
        return dojoId;
    }

    public List<Kata> getKatas() {
        return katas;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public Integer getDurationDays() {
        return durationDays;
    }
}
