package ru.itis.diplom.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.demidko.aot.WordformMeaning;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class VectorSearch {
    static int numOfAllWords;
    static int numOfVectors;
    static Object[] allWords;
    static String[][] words;


    public static void getAllWords(List<String> examples) {
        Set<String> all = new HashSet<>();
        for (String s : examples) {
            String[] temp = s.toLowerCase().split("[^а-я]");
            for (int i = 0; i < temp.length; i++) {
                try {
                    List<WordformMeaning> meanings = WordformMeaning.lookupForMeanings(temp[i]);
                    if (meanings.size() > 0) {
                        temp[i] = meanings.get(0).getLemma().toString();
                    }
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            all.addAll(Arrays.asList(temp));
        }
        allWords = all.toArray();
    }

    public static void makeWords(List<String> examples) {
        words = new String[numOfVectors][];
    }

    public static boolean check(String answer, List<String> examples) {
        getAllWords(examples);
        numOfAllWords = allWords.length;
        numOfVectors = examples.size();
        makeWords(examples);
        TFCounter tfCounter = new TFCounter(numOfAllWords);
        double[][] examplesAsVectors = new double[numOfVectors][numOfAllWords];
        for (int i = 0; i < numOfVectors; i++) {
            for (int j = 0; j < numOfAllWords; j++) {
                examplesAsVectors[i][j] = tfCounter.frequency(examples.get(i), allWords[j].toString());
            }
        }
        double[] searchVector = new double[numOfAllWords];
        for (int i = 0; i < numOfAllWords; i++) {
            searchVector[i] = tfCounter.frequency(answer, allWords[i].toString());
        }
        double[] similarity = new double[numOfVectors];

        double aixbi = 0;
        double ai2 = 0;
        double bi2 = 0;
        double max = 0;
        for (int i = 0; i < numOfVectors; i++) {
            for (int j = 0; j < numOfAllWords; j++) {
                aixbi += examplesAsVectors[i][j] * searchVector[j];
                ai2 += examplesAsVectors[i][j] * examplesAsVectors[i][j];
                bi2 += searchVector[j] * searchVector[j];
            }
            similarity[i] = aixbi / (Math.sqrt(ai2) * Math.sqrt(bi2));
            if (similarity[i] > max) {
                max = similarity[i];
            }
        }
        return max > 0.5;
    }
}
