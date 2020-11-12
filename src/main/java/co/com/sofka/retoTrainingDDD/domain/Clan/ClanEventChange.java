package co.com.sofka.retoTrainingDDD.domain.Clan;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.retoTrainingDDD.domain.Clan.entities.Member;
import co.com.sofka.retoTrainingDDD.domain.Clan.events.*;

public class ClanEventChange extends EventChange {
    public ClanEventChange(Clan clan) {
        apply((CreatedClan createdClan)->{
            clan.members = createdClan.getMembers();
            clan.color = createdClan.getColor();
            clan.groupGit = createdClan.getGroupGit();
            clan.name = createdClan.getName();
        });

        apply((AddedMember addedMember) -> clan.members.add(new Member(addedMember.getMemberId(),
                addedMember.getName(),
                addedMember.getGender(),
                addedMember.getOwner(),
                addedMember.getPersonId(),
                addedMember.getMemberGit(),
                addedMember.getEmail(),
                addedMember.getScores())));

        apply((AppliedColor appliedColor) -> clan.color = appliedColor.getColor());

        apply((RevokedMember revokedMember)-> clan.members.removeIf(member -> member.identity().equals(revokedMember.getMemberId())));

        apply((UpdatedName updatedName)-> clan.name = updatedName.getName());

        apply((UpdatedScoreOfMember updatedScoreOfMember)-> clan.members.forEach(member -> member.addScore(updatedScoreOfMember.getScore())));

        apply((UpdateMember updateMember)->{
            clan.members.stream().filter(member -> member.identity().equals(updateMember.getMemberId()))
                    .findFirst()
                    .ifPresent(member -> member.upDateEmail(updateMember.getEmail()));

            clan.members.stream().filter(member -> member.identity().equals(updateMember.getMemberId()))
                    .findFirst()
                    .ifPresent(member -> member.upDateGender(updateMember.getGender()));
        });
    }
}
