package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Dojo.entities.Sensei;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Accomplishment;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.SenseiId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Specialty;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;

import java.util.List;

public class AssignedSensei extends DomainEvent {
    private final SenseiId senseiId;
    private final Name name;
    private final PersonId personId;
    private final Specialty specialty;
    private final MemberGit memberGit;
    private final List<Accomplishment> accomplishmentList;

    public AssignedSensei(SenseiId senseiId, Name name, PersonId personId, Specialty specialty, MemberGit memberGit, List<Accomplishment> accomplishmentList) {
        super("Dojo.AssignedSensei");
        this.senseiId = senseiId;
        this.name = name;
        this.personId = personId;
        this.specialty = specialty;
        this.memberGit = memberGit;
        this.accomplishmentList = accomplishmentList;
    }

    public Name getName() {
        return name;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public MemberGit getMemberGit() {
        return memberGit;
    }

    public List<Accomplishment> getAccomplishmentList() {
        return accomplishmentList;
    }

    public SenseiId getSenseiId() {
        return senseiId;
    }
}
