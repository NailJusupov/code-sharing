package ru.study.codesharing.models.dto;

import ru.study.codesharing.models.domain.GistsDAO;
import ru.study.codesharing.models.domain.UsersDAO;

public class StarsDTO {

    private UsersDAO user;
    private GistsDAO gist;

    public StarsDTO() {}

    public StarsDTO(UsersDAO user, GistsDAO gist) {
        this.user = user;
        this.gist = gist;
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
