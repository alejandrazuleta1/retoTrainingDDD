package co.com.sofka.retoTrainingDDD.useCase.model;

import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;

import java.util.Map;

public class PuntajeClanes {
    Map<ClanId,Integer> puntajeClanes;

    public PuntajeClanes(Map<ClanId, Integer> getPuntajeClanes) {
        this.puntajeClanes = getPuntajeClanes;
    }

    public Map<ClanId, Integer> getPuntajeClanes() {
        return puntajeClanes;
    }
}
