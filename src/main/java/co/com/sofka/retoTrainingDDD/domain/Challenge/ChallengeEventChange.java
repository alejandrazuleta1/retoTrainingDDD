package co.com.sofka.retoTrainingDDD.domain.Challenge;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.retoTrainingDDD.domain.Challenge.events.*;

public class ChallengeEventChange extends EventChange {
    public ChallengeEventChange(Challenge challenge) {
        apply((CreatedChallenge createdChallenge)->{
            challenge.name = createdChallenge.getName();
            challenge.clanIdList = createdChallenge.getClanIdList();
            challenge.durationDays = createdChallenge.getDurationDays();
            challenge.assessment = createdChallenge.getAssessment();
            challenge.katas = createdChallenge.getKatas();
            challenge.dojoId = createdChallenge.getDojoId();
            challenge.isRevoked = Boolean.FALSE;
            challenge.isVisible = Boolean.TRUE;
        });

        apply((AddedExerciseOfKata addedExerciseOfKata)->{
            challenge.katas.stream().filter(kata -> kata.identity().equals(addedExerciseOfKata.getKataId()))
                    .findFirst()
                    .get()
                    .ExcerciseList().add(addedExerciseOfKata.getExcercise());
        });

        apply((AddedKata addedKata)->{
            challenge.katas.add(addedKata.getKata());
        });

        apply((AssignedAssessment assignedAssessment)->{
            challenge.assessment = assignedAssessment.getAssessment();
        });

        apply((ChangedDurationDays changedDurationDays)->{
            challenge.durationDays = changedDurationDays.getDurationDays();
        });

        apply((RevokedChallenge revokedChallenge)->{
            challenge.isRevoked = Boolean.TRUE;
        });

        apply((UpdatedKata updatedKata)->{
            //TODO no lo estan pidiendo en los casos de uso
        });

        apply((UpdatedName updatedName)->{
            challenge.name = updatedName.getName();
        });
    }
}