package co.com.sofka.retoTrainingDDD.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.GroupGit;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Frecuency;
import co.com.sofka.retoTrainingDDD.domain.Dojo.commands.CambiarUrlMeetDojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.CreatedDojo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DataInfo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Location;
import co.com.sofka.retoTrainingDDD.domain.VOShared.OpeningHours;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ChangeMeetUrlDojoUseCaseTest extends UseCaseHandleBaseTest{

    @Test
    void changeMeetUrlDojo(){
        var location = new Location("www.meetActualizada.com",
                "Medellin Sofka",
                "Este dojo esta dirigido para las personas del training",
                new OpeningHours(10,12, Frecuency.EVERY_TWO_DAYS));

        CambiarUrlMeetDojo cambiarUrlMeetDojo = new CambiarUrlMeetDojo(DojoId.of("1"),location);
        ChangeMeetUrlDojoUseCase useCase = new ChangeMeetUrlDojoUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedDojo(DojoId.of("1"),
                        new DataInfo("Dojo Training","Primer Dojo"),
                        new ArrayList<>(),
                        new GroupGit("grupo1"),
                        new Location("www.meet.com",
                                "Medellin Sofka",
                                "Este dojo esta dirigido para las personas del training",
                                new OpeningHours(10,12,Frecuency.EVERY_TWO_DAYS)))
        ));

        useCase.addRepository(repository);
        UseCaseHandler.getInstance()
                .setIdentifyExecutor(DojoId.of("1").value())
                .asyncExecutor(
                        useCase,
                        new RequestCommand<>(cambiarUrlMeetDojo))
                .subscribe(subscriber);

        verify(subscriber,times(1)).onNext(eventCaptor.capture());
    }
}