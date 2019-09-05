package ru.study.codesharing.models.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gists")
public class GistsDAO {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersDAO user;

    @OneToMany(mappedBy = "gist", fetch = FetchType.LAZY)
    private Set<FilesDAO> files = new HashSet<>();

    @OneToMany(mappedBy = "gist", fetch = FetchType.LAZY)
    private Set<FilesDAO> stars = new HashSet<>();

    private String title;
    private String description;
    private String programmingLanguage;
    private Date creationDate;

    public GistsDAO() {

    }

    public GistsDAO(
            long id,
            UsersDAO user,
            String title,
            String description,
            String programmingLanguage,
            Date creationDate) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.description = description;
        this.programmingLanguage = programmingLanguage;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UsersDAO getUser() {
        return user;
    }

    public void setUser(UsersDAO user) {
        this.user = user;
    }

    public Set<FilesDAO> getFiles() {
        return files;
    }

    public void setFiles(Set<FilesDAO> files) {
        this.files = files;
    }

    public Set<FilesDAO> getStars() {
        return stars;
    }

    public void setStars(Set<FilesDAO> stars) {
        this.stars = stars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
