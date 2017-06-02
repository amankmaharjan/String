package io;

import java.util.HashMap;

/**
 * Created by aman on 6/1/17.
 */
public class EachCharacterCountInString {

    public static HashMap<Character, Integer> characterCounter(String input) {
        HashMap<Character, Integer> charactercounterMap = new HashMap<>();
        char[] inputCharacter = input.toCharArray();
        for (char c : inputCharacter) {
            if (charactercounterMap.containsKey(c)) {
                charactercounterMap.put(c, charactercounterMap.get(c) + 1);
            } else {
                charactercounterMap.put(c, 1);
            }
        }
        return charactercounterMap;

    }
    public static void main(String[] args) {
        System.out.println(characterCounter("hello"));

    }
}
