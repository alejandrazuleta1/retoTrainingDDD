package co.com.sofka.retoTrainingDDD.domain.Challenge;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Challenge.entities.Kata;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.*;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Assessment;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Excercise;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.KataId;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.SubscribedClan;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;

import java.util.List;

public class Challenge extends AggregateEvent<ChallengeId> {
    protected Name name;
    protected List<ClanId> clanIdList;
    protected DojoId dojoId;
    protected List<Kata> katas;
    protected Assessment assessment;
    protected Boolean isRevoked;
    protected Boolean isVisible;
    protected Integer durationDays;

    public Challenge(ChallengeId entityId,
                     Name name,
                     List<ClanId> clanIdList,
                     DojoId dojoId,
                     List<Kata> katas,
                     Assessment assessment,
                     Integer durationDays) {
        super(entityId);
        this.name = name;
        this.clanIdList = clanIdList;
        this.dojoId = dojoId;
        this.katas = katas;
        this.assessment = assessment;
        this.durationDays = durationDays;
        appendChange(new CreatedChallenge(entityId, name,clanIdList,dojoId,katas,assessment,durationDays)).apply();
    }

    private Challenge(ChallengeId entityId) {
        super(entityId);
        subscribe(new ChallengeEventChange(this));
    }

    public static Challenge from(ChallengeId entityId, List<DomainEvent> eventList) {
        var Challenge = new Challenge(entityId);
        eventList.forEach(Challenge::applyEvent);
        return Challenge;
    }

    public void addNewKata(Kata kata){
        appendChange(new AddedKata(kata)).apply();
    }

    public void subscriberClan(ClanId clanId){
        appendChange(new SubscribedClan(clanId)).apply();
    }

    public void unsubscriberClan(ClanId clanId){
        this.clanIdList.removeIf(clanId1 -> clanId1.equals(clanId));
        //TODO ojo no lanza evento
    }

    public void changeDuratioDays(Integer durationDays){
        appendChange(new ChangedDurationDays(durationDays)).apply();
    }

    public void updateName(Name name){
        appendChange(new UpdatedName(name));
    }

    public void updateKata(KataId kataId, String purpose, List<Excercise> excercises, String description, Integer limitOfTime){
        appendChange(new UpdatedKata(kataId, purpose, excercises, description, limitOfTime)).apply();
    }

    public void addExerciseOfKata(KataId kataId,Excercise excercise){
        appendChange(new AddedExerciseOfKata(kataId,excercise)).apply();
    }

    public void deleteExerciseOfKata(KataId kataId,Excercise excercise){
        appendChange(new DeletedExerciseOfKata(kataId,excercise)).apply();
    }

    public void assignAsssessment(Assessment assessment){
        appendChange(new AssignedAssessment(assessment)).apply();
    }

    public void revokeChallenge(){
        appendChange(new RevokedChallenge()).apply();
    }
}
