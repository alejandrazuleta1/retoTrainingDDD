package co.com.sofka.retoTrainingDDD.domain.Dojo.entities;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Accomplishment;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.SenseiId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Specialty;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;

import java.util.List;

public class Sensei extends Entity<SenseiId> {
    private Name name;
    private PersonId personId;
    private Specialty specialty;
    private MemberGit memberGit;
    private List<Accomplishment> accomplishmentList;

    public Sensei(SenseiId entityId, Name name, PersonId personId, Specialty specialty, MemberGit memberGit, List<Accomplishment> accomplishmentList) {
        super(entityId);
        this.name = name;
        this.personId = personId;
        this.specialty = specialty;
        this.memberGit = memberGit;
        this.accomplishmentList = accomplishmentList;
    }

    public Sensei(SenseiId entityId) {
        super(entityId);
    }

    public void changeSpeciality(Specialty specialty){
        this.specialty = specialty;
    }

    public void addAccomplishment(Accomplishment accomplishment){
        accomplishmentList.add(accomplishment);
    }

    public void update(Name name, PersonId personId, Specialty specialty, MemberGit memberGit, List<Accomplishment> accomplishmentList) {
        this.name = name;
        this.personId = personId;
        this.specialty = specialty;
        this.memberGit = memberGit;
        this.accomplishmentList = accomplishmentList;
    }

    public Name Name() {
        return name;
    }

    public PersonId PersonId() {
        return personId;
    }

    public Specialty Specialty() {
        return specialty;
    }

    public MemberGit MemberGit() {
        return memberGit;
    }

    public List<Accomplishment> AccomplishmentList() {
        return accomplishmentList;
    }
}
