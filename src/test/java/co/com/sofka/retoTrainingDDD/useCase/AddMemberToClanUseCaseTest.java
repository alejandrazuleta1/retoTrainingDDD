package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.Clan.commands.AgregarMiembroAClan;
import co.com.sofka.retoTrainingDDD.domain.Clan.entities.Member;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.AddedMember;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.CreatedClan;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.VOShared.MemberGit;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.OpeningHours;
import co.com.sofka.retoTrainingDDD.domain.VOShared.PersonId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AddMemberToClanUseCaseTest extends UseCaseHandleBaseTest{

    @BeforeEach
    void setup(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addMemberToClan(){
        AgregarMiembroAClan agregarMiembroAClan = new AgregarMiembroAClan(
                ClanId.of("20202"),
                new MemberId("78908123"),
                new Name("Alejandra Zuleta"),
                new Gender("F"),
                Boolean.FALSE,
                new PersonId("1087234567"),
                new MemberGit(2,"www.linkdeimagen.com","alejandra.zuleta"),
                new Email("alejandra.zuleta@sofka.com.co"),
                new ArrayList<>());
        AddMemberToClanUseCase useCase = new AddMemberToClanUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedClan(
                        ClanId.of("20202"),
                        new ArrayList<>(),
                        new GroupGit("group4"),
                        new Color("Azul"),
                        new Name("Serway"))
        ));

        useCase.addRepository(repository);

        UseCaseHandler.getInstance()
                .setIdentifyExecutor(ClanId.of("20202").value())
                .asyncExecutor(useCase,new RequestCommand<>(agregarMiembroAClan))
                .subscribe(subscriber);

        verify(subscriber,times(1)).onNext(eventCaptor.capture());
        AddedMember addedMember = (AddedMember) eventCaptor.getAllValues().get(0);
        System.out.println(addedMember.getName().value());
    }
}