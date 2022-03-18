package service;

import entity.Document;

import java.util.List;

public interface IDocumentService {
    void addDoc(Document doc);
    List<String> searchWord(String word);
    List<String> getDocumentIdsByPhrase(String phrase);
}
