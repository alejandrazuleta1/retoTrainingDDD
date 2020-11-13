package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.VOShared.*;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Frecuency;
import co.com.sofka.retoTrainingDDD.domain.Dojo.commands.CrearDojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.entities.Sensei;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.AssignedSensei;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.OpeningHours;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateDojoUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void crearDojoTest() throws InterruptedException{
        Sensei sensei = new Sensei(new SenseiId("80903124"),
                new Name("Raul Alzate"),
                new PersonId("70809123"),
                new Specialty("Team Management"),
                new MemberGit(1,"wwww.soloEsUnTest.com","raul.alzate"),
                new ArrayList<>()
                );
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule("Se debe encender la camara en las mentorias"));
        rules.add(new Rule("Aplicar commit mas pequeños durante el proceso practico de katas"));
        Location location = new Location("www.meet.com",
                "Medellin Sofka",
                "Este dojo esta dirigido para las personas del training",
                new OpeningHours(10,12,Frecuency.EVERY_TWO_DAYS));

        CrearDojo crearDojo = new CrearDojo(
                new DojoId("1"),
                sensei,
                new DataInfo("Dojo Training","Primer Dojo"),
                rules,
                new GroupGit(12,new Path("path1"),new Name("grupo1")),
                location);

        CreateDojoUseCase useCase = new CreateDojoUseCase();
        UseCaseHandler.getInstance()
                .asyncExecutor(
                        useCase,
                        new RequestCommand<>(crearDojo))
                .subscribe(subscriber);
        Thread.sleep(1000);

        verify(subscriber,times(2)).onNext(eventCaptor.capture());
        AssignedSensei assignedSensei = (AssignedSensei) eventCaptor.getAllValues().get(1);
        System.out.println(assignedSensei.getName().value());
    }
}