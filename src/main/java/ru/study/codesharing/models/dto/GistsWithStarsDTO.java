package ru.study.codesharing.models.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class GistsWithStarsDTO {
    private long id;
    private String title;
    private String description;
    private String programmingLanguage;
    private Date creationDate;
    private int starsCount;
    private Set<FilesDTO> files = new HashSet<>();

    public GistsWithStarsDTO() {}

    public GistsWithStarsDTO(long id,
                             String title,
                             String description,
                             String programmingLanguage,
                             Date creationDate,
                             Set<FilesDTO> files,
                             int starsCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.programmingLanguage = programmingLanguage;
        this.creationDate = creationDate;
        this.files = files;
        this.starsCount = starsCount;
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

    public Set<FilesDTO> getFiles() {
        return files;
    }

    public void setFiles(Set<FilesDTO> files) {
        this.files = files;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
    }
}
