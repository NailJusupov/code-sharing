package ru.study.codesharing.models.dto;

public class FilesDTO {

    private String fileName;
    private String code;

    public FilesDTO(String fileName, String code) {
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
}
