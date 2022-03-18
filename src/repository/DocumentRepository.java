package repository;

import entity.Document;

import java.util.*;

public class DocumentRepository implements IDocumentRepository{
    Map<String, Map<String, TreeSet<Integer>>> documentMap;

    public DocumentRepository(){
        documentMap = new HashMap<>();
    }

    @Override
    public void addDocument(Document doc) {
        String[] words = doc.getContent().split(" ");
        int position = 0;
        for(String word: words){
            if(documentMap.containsKey(word)){
                if(documentMap.get(word).containsKey(doc.getDocumentId())){
                    documentMap.get(word).get(doc.getDocumentId()).add(position);
                }else{
                    TreeSet<Integer> tempSet = new TreeSet<>();
                    tempSet.add(position);
                    documentMap.get(word).put(doc.getDocumentId(), tempSet);
                }
            }else{
                Map<String, TreeSet<Integer>> tempMap = new HashMap<>();
                TreeSet<Integer> tempSet = new TreeSet<>();
                tempSet.add(position);
                tempMap.put(doc.getDocumentId(), tempSet);
                documentMap.put(word, tempMap);
            }

            position++;
        }
    }

    @Override
    public List<String> getDocumentIdsByWord(String word) {
        return new ArrayList<>(documentMap.get(word).keySet());
    }

    //searchWord & searchPhrase can be combined now and phrase will word for both
    //Keeping like this to keep interview flow as third method was added later on


    @Override
    public List<String> getDocumentIdsByPhrase(String phrase) {
        String[] words = phrase.split(" ");
        int length = words.length;

        Map<String, TreeSet<Integer>> map = documentMap.get(words[0]);
        if(map == null){
            return new ArrayList<>();
        }

        for(int position = 1; position < length; position++){
            map = getIntersection(map, documentMap.get(words[position]));
        }

        ArrayList<String> result = new ArrayList<>();
        TreeSet<Integer> tempSet;
        for(Map.Entry<String, TreeSet<Integer>> entry : map.entrySet()){
            tempSet = entry.getValue();
            if(tempSet.last() - tempSet.first() == length - 1){
                result.add(entry.getKey());
            }
        }

        return result;
    }

    private Map<String, TreeSet<Integer>> getIntersection(Map<String, TreeSet<Integer>> mapOne, Map<String, TreeSet<Integer>> mapTwo)
    {
        Map<String, TreeSet<Integer>> intersection = new HashMap<>();
        for (String key: mapOne.keySet())
        {
            if (mapTwo.containsKey(key)) {
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.addAll(mapOne.get(key));
                treeSet.addAll(mapTwo.get(key));
                intersection.put(key, treeSet);
            }
        }
        return intersection;
    }
}
