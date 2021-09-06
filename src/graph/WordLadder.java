package graph;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Stream;

//https://leetcode.com/problems/word-ladder
public class WordLadder {
    public static void main(String[] args) {
        String words [] = {"hot", "dog", "dot", "lot", "log", "cog"};
        String start = "hit";
        String end = "cog";

        // first thing is to create a graph of connected(word differ by one) word.
        // one way is to iterate all array for each word, which is inefficient
        // other good way is to pre process the words.

        int L = start.length();

        Map<String, List<String>> bigDict = new HashMap<>();

        Stream.of(words).forEach(word ->{
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = bigDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                bigDict.put(newWord, transformations);
            }
        });

        System.out.println();

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(Pair.of(start, 1));

        Set<String> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()){
            // find all generics of given word and find their actual world and put to queue
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getLeft();
            Integer level = pair.getRight();

            for (int i = 0; i < L; i++) {
                String genericWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                for(String adjacentWord : bigDict.getOrDefault(genericWord, new ArrayList<>())){

                    if (adjacentWord.equals(end)) {
                        System.out.println("found the word");
                        System.out.println(level + 1);
                        return;
                    }

                    if(!visited.contains(adjacentWord)){
                        visited.add(adjacentWord);
                        queue.add(Pair.of(adjacentWord, level+1));
                    }
                }
            }

        }
    }
}
