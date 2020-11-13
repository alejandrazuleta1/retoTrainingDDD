package co.com.sofka.retoTrainingDDD.useCase.service;

import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.ChallengeId;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.ClanId;
import co.com.sofka.retoTrainingDDD.useCase.model.PuntajeClanes;

import java.util.Map;

public interface ListaPuntajesClanesService {
    PuntajeClanes getListaPuntajesClanes(ChallengeId challengeId);
}
