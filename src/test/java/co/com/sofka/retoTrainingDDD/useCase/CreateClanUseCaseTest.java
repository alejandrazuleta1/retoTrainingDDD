package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.Clan.commands.CrearClan;
import co.com.sofka.retoTrainingDDD.domain.Clan.entities.Member;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.CreatedClan;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.VOShared.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateClanUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void createClan() throws InterruptedException{
        List<Member> members = new ArrayList<>();
        members.add(new Member(new MemberId("1"),
                new Name("Alejandra Zuleta"),
                new Gender("F"),
                Boolean.TRUE,
                new PersonId("1087234567"),
                new MemberGit(2,"www.linkdeimagen.com","alejandra.zuleta"),
                new Email("alejandra.zuleta@sofka.com.co"),
                new ArrayList<>()));

        CrearClan crearClan = new CrearClan(
                new ClanId("13"),
                members,
                new GroupGit(12,new Path("path1"),new Name("grupo1")),
                new Name("The best Clan"));

        CreateClanUseCase useCase = new CreateClanUseCase();
        UseCaseHandler.getInstance()
                .asyncExecutor(
                        useCase,
                        new RequestCommand<>(crearClan))
                .subscribe(subscriber);
        Thread.sleep(1000);

        verify(subscriber,times(1)).onNext(eventCaptor.capture());
        CreatedClan createdClan = (CreatedClan) eventCaptor.getAllValues().get(0);
        System.out.println(createdClan.getName().value());
    }
}