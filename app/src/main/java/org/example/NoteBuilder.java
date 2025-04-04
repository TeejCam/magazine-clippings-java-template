package org.example;

import java.util.HashMap;
import java.util.Set;

public class NoteBuilder
{
    public static HashMap<Character, Integer> buildMap(String str)
    {
        return FrequencyMap.buildMap(str);
    }

    public static HashMap<Character, Integer> buildArticlesMap(String[] articles)
    {
        HashMap<Character, Integer> articleMap = new HashMap<>();

        for(int i = 0; i < articles.length; i++){
            String article = articles[i];
            HashMap<Character, Integer> articleFreq = buildMap(article);

            Object[] keysArray = articleFreq.keySet().toArray();

            for(int j = 0; j < keysArray.length; j++){
                Character c = (Character) keysArray[j];

                articleMap.put(c, articleMap.getOrDefault(c, 0) + articleFreq.get(c));
            }
        }
        return articleMap;
    }

    public static boolean canCreateNote(String note, String[] articles)
    {
        HashMap<Character, Integer> noteMap = buildMap(note);

        HashMap<Character, Integer> articleMap = buildArticlesMap(articles);

        Object[] keysArray = noteMap.keySet().toArray();
        for(int i = 0; i < keysArray.length; i++){
            Character c = (Character) keysArray[i];

            if(articleMap.getOrDefault(c,0) < noteMap.get(c)){
                return false;
            }
        }

        return true;
    }
}