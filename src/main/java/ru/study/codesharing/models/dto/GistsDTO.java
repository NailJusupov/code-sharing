package ru.study.codesharing.models.dto;

import java.util.List;

public class GistsDTO {

    private long id;
    private String title;
    private String description;
    private String programmingLanguage;
    private List<FilesDTO> files;

    public GistsDTO() {
    }

    public GistsDTO(long id,
                    String title,
                    String description,
                    String programmingLanguage,
                    List<FilesDTO> filesDTOS) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.programmingLanguage = programmingLanguage;
        this.files = filesDTOS;
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

    public List<FilesDTO> getFiles() {
        return files;
    }

    public void setFiles(List<FilesDTO> files) {
        this.files = files;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
