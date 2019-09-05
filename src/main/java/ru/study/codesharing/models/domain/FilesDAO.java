package ru.study.codesharing.models.domain;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class FilesDAO {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "gist_id")
    private GistsDAO gist;

    private String fileName;
    private String code;

    public FilesDAO() {

    }

    public FilesDAO(GistsDAO gist, String fileName, String code) {
        this.gist = gist;
        this.fileName = fileName;
        this.code = code;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GistsDAO getGist() {
        return gist;
    }

    public void setGist(GistsDAO gist) {
        this.gist = gist;
    }
}
