package co.com.sofka.retoTrainingDDD.domain.Dojo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.domain.VOShared.GroupGit;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Score;
import co.com.sofka.retoTrainingDDD.domain.Dojo.entities.Sensei;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.*;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;

import java.util.List;

public class Dojo extends AggregateEvent<DojoId> {
    protected Sensei sensei;
    protected DataInfo dataInfo;
    protected Status status;
    protected List<Rule> rules;
    protected GroupGit groupGit;
    protected Location location;

    public Dojo(DojoId entityId, DataInfo dataInfo, List<Rule> rules, GroupGit groupGit, Location location) {
        super(entityId);
        this.dataInfo = dataInfo;
        this.rules = rules;
        this.groupGit = groupGit;
        this.location = location;
        appendChange(new CreatedDojo(entityId, dataInfo,rules,groupGit,location)).apply();
    }

    private Dojo(DojoId entityId) {
        super(entityId);
        subscribe(new DojoEventChange(this));
    }

    public static Dojo from(DojoId entityId, List<DomainEvent> eventList) {
        var Dojo = new Dojo(entityId);
        eventList.forEach(Dojo::applyEvent);
        return Dojo;
    }

    public void changeLocation(Location location){
        appendChange(new ChangedLocation(location)).apply();
    }

    public void addRule(Rule rule){
        appendChange(new AddedRule(rule)).apply();
    }

    public void assignSensei(SenseiId senseiId,
                             Name name,
                             PersonId personId,
                             Specialty specialty,
                             MemberGit memberGit,
                             List<Accomplishment> accomplishmentList){
        appendChange(new AssignedSensei(senseiId,name,personId,specialty,memberGit, accomplishmentList)).apply();
    }

    public void removeRule(Rule rule){
        appendChange(new RuleRemoved(rule)).apply();
    }

    public void cancelDojo(){
        var status= Status.CANCELLED;
        appendChange(new DojoStatusChanged(status)).apply();
    }

    public void openDojo(){
        var status= Status.OPEN;
        appendChange(new DojoStatusChanged(status)).apply();
    }

    public void addAccomplishmentToSensei(Accomplishment accomplishment){
        appendChange(new AddedAccomplishmentToSensei(accomplishment)).apply();
    }

    public void updateDataToSensei(Name name, PersonId personId, Specialty specialty, MemberGit memberGit, List<Accomplishment> accomplishmentList){
        appendChange(new UpdatedDataSensei(name,personId,specialty,memberGit,accomplishmentList)).apply();
    }

    public void closeDojo(){
        var status= Status.CLOSED;
        appendChange(new DojoStatusChanged(status)).apply();
    }

    public void changeDataInfo(DataInfo dataInfo){
        appendChange(new ChangedDataInfo(dataInfo)).apply();
    }

    public void evaluateClan(ClanId clanId, Score score){
        appendChange(new EvaluatedClan(clanId, score)).apply();
    }
}