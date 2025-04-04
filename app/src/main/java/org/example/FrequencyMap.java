package org.example; 
import java.util.HashMap;

public class FrequencyMap
{
    public static HashMap<Character, Integer> buildMap(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        str = processString(str);

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    public static String processString(String str)
    {
        return str.toLowerCase().replaceAll("\\s+", "");
    }
}