package com.opso.med.domain;

/**
 * Created by Razvan.Simion on 4/11/2017.
 */
public class DocumentFile {
    private String id;
    private String url;
    private String type;

    public DocumentFile() {
    }

    public DocumentFile(String id, String url, String type) {
        this.id = id;
        this.url = url;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DocumentFile)) return false;

        DocumentFile document = (DocumentFile) o;

        if (id != null ? !id.equals(document.id) : document.id != null) return false;
        if (url != null ? !url.equals(document.url) : document.url != null) return false;
        return type != null ? type.equals(document.type) : document.type == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Document{" +
            "id='" + id + '\'' +
            ", url='" + url + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
