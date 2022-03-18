package entity;

public class Document {
    private String documentId;
    private String content;

    public Document(String documentId, String content){
        this.documentId = documentId;
        this.content = content;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
