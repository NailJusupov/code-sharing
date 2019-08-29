package ru.study.codesharing.models.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class UsersDAO {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "gists", fetch = FetchType.LAZY)
    private Set<GistsDAO> gists = new HashSet<>();

    @OneToMany(mappedBy = "stars", fetch = FetchType.LAZY)
    private Set<StarsDAO> stars = new HashSet<>();

    public UsersDAO() {

    }

    public UsersDAO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
