import entity.Document;
import service.DocumentService;
import service.IDocumentService;

import java.util.List;

public class Main {
    public static void main(String[] args){
        Document doc1 = new Document("Doc 1", "new home sales top forecasts  2");
        Document doc2 = new Document("Doc 2", "home sales rise in july  1");
        Document doc3 = new Document("Doc 3", "increase in home new sales in july  3");
        Document doc4 = new Document("Doc 4", "july new home sales rise  3");
        Document doc5 = new Document("Doc 5", "new home new sales top forecasts  2");

        IDocumentService documentService = new DocumentService();
        documentService.addDoc(doc1);
        documentService.addDoc(doc2);
        documentService.addDoc(doc3);
        documentService.addDoc(doc4);
        documentService.addDoc(doc5);

        List<String> documentIds = documentService.searchWord("rise");
        System.out.println("getDocumentIdsByWord : rise");
        for(String documentId : documentIds){
            System.out.println(documentId);
        }

        List<String> documentIdsByPhrase = documentService.getDocumentIdsByPhrase("home sales");
        System.out.println("getDocumentIdsByPhrase: home sales");
        for(String documentId : documentIdsByPhrase){
            System.out.println(documentId);
        }

        documentIdsByPhrase = documentService.getDocumentIdsByPhrase("home");
        System.out.println("getDocumentIdsByPhrase: home");
        for(String documentId : documentIdsByPhrase){
            System.out.println(documentId);
        }

        documentIds = documentService.searchWord("home");
        System.out.println("getDocumentIdsByWord : home");
        for(String documentId : documentIds){
            System.out.println(documentId);
        }

        documentIdsByPhrase = documentService.getDocumentIdsByPhrase("home sales top");
        System.out.println("getDocumentIdsByPhrase: home sales top");
        for(String documentId : documentIdsByPhrase){
            System.out.println(documentId);
        }

        documentIdsByPhrase = documentService.getDocumentIdsByPhrase("home");
        System.out.println("getDocumentIdsByPhrase: home");
        for(String documentId : documentIdsByPhrase){
            System.out.println(documentId);
        }

        documentIdsByPhrase = documentService.getDocumentIdsByPhrase("invalid home");
        System.out.println("getDocumentIdsByPhrase: invalid home");
        for(String documentId : documentIdsByPhrase){
            System.out.println(documentId);
        }
    }
}
