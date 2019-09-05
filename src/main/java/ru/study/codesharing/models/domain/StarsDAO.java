package ru.study.codesharing.models.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stars")
public class StarsDAO {

    @EmbeddedId
    private StarCompositeId id;

    @ManyToOne
    @MapsId("userId")
    private UsersDAO user;

    @ManyToOne
    @MapsId("gistId")
    private GistsDAO gist;

    public StarsDAO() {

    }

    public StarsDAO(UsersDAO user, GistsDAO gist) {
        this.user = user;
        this.gist = gist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StarsDAO that = (StarsDAO) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(gist, that.gist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, gist);
    }

    public UsersDAO getUser() {
        return user;
    }

    public void setUser(UsersDAO user) {
        this.user = user;
    }

    public GistsDAO getGist() {
        return gist;
    }

    public void setGist(GistsDAO gist) {
        this.gist = gist;
    }
}
