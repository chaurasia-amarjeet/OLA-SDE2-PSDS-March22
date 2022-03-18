package service;

import entity.Document;
import repository.DocumentRepository;
import repository.IDocumentRepository;

import java.util.List;

public class DocumentService implements IDocumentService {

    private final IDocumentRepository documentRepository = new DocumentRepository();

    @Override
    public void addDoc(Document doc) {
        documentRepository.addDocument(doc);
    }

    @Override
    public List<String> searchWord(String word) {
        return documentRepository.getDocumentIdsByWord(word);
    }

    @Override
    public List<String> getDocumentIdsByPhrase(String phrase) {
        return documentRepository.getDocumentIdsByPhrase(phrase);
    }

    //searchWord & searchPhrase can be combined now and phrase will word for both
    //Keeping like this to keep interview flow as third method was added later on
}
