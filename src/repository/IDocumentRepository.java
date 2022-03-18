package repository;

import entity.Document;

import java.util.List;

public interface IDocumentRepository {
    void addDocument(Document doc);

    List<String> getDocumentIdsByWord(String word);

    List<String> getDocumentIdsByPhrase(String phrase);
}
