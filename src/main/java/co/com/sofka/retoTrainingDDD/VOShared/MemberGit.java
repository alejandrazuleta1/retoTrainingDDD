package co.com.sofka.retoTrainingDDD.VOShared;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MemberGit implements ValueObject<MemberGit.Propiedades> {
    private final Integer memberGitId;
    private final String imageAvatarUrl;
    private final String username;

    public MemberGit(Integer memberGitId, String imageAvatarUrl, String username) {
        this.memberGitId = memberGitId;
        this.imageAvatarUrl = imageAvatarUrl;
        this.username = username;
    }

    public interface Propiedades{
        Integer memberGitId();
        String imageAvatarUrl();
        String username();
    }

    @Override
    public MemberGit.Propiedades value() {
        return new Propiedades() {

            @Override
            public Integer memberGitId() {
                return memberGitId;
            }

            @Override
            public String imageAvatarUrl() {
                return imageAvatarUrl;
            }

            @Override
            public String username() {
                return username;
            }
        };
    }
}
