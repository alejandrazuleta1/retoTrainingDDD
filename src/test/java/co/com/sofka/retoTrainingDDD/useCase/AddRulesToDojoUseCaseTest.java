package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.VOShared.GroupGit;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Frecuency;
import co.com.sofka.retoTrainingDDD.domain.Dojo.commands.AgregarReglasAlDojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.AddedRule;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.CreatedDojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.*;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.OpeningHours;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Name;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Path;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AddRulesToDojoUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void addRulesToDojoUseCaseTest() throws InterruptedException{
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule("En las salas de entrenamiento generar agregar una interpretación de mas de 200 caracteres"));
        rules.add(new Rule("Trabajar las lecturas de forma consciente durante el proceso de entrenamiento"));

        AgregarReglasAlDojo agregarReglasAlDojo = new AgregarReglasAlDojo(
                DojoId.of("1"),
                rules);

        AddRulesToDojoUseCase useCase = new AddRulesToDojoUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedDojo(DojoId.of("1"),
                        new DataInfo("Dojo Training","Primer Dojo"),
                        new ArrayList<>(),
                        new GroupGit(12,new Path("path1"),new Name("grupo1")),
                        new Location("www.meet.com",
                                "Medellin Sofka",
                                "Este dojo esta dirigido para las personas del training",
                                new OpeningHours(10,12,Frecuency.EVERY_TWO_DAYS)))
                ));

        useCase.addRepository(repository);

        UseCaseHandler.getInstance()
                .setIdentifyExecutor(DojoId.of("1").value())
                .asyncExecutor(useCase,new RequestCommand<>(agregarReglasAlDojo))
                .subscribe(subscriber);
        Thread.sleep(1000);

        verify(subscriber,times(2)).onNext(eventCaptor.capture());
        List<AddedRule> addedRules = new ArrayList<>();
        addedRules.add((AddedRule) eventCaptor.getAllValues().get(0));
        addedRules.add((AddedRule) eventCaptor.getAllValues().get(1));
        addedRules.forEach(addedrule-> System.out.println(addedrule.getRule().value()));
    }
}