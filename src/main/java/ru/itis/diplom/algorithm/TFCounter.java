package ru.itis.diplom.algorithm;

import com.github.demidko.aot.WordformMeaning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TFCounter {
    private int N;

    public TFCounter(int N) {
        this.N = N;
    }

    public double frequency(String array, String word) {
        int count = 0;
        String[] arrayList = array.toLowerCase().split("[^а-я]");
        for (int i = 0; i < arrayList.length; i++) {
            try {
                List<WordformMeaning> meanings = WordformMeaning.lookupForMeanings(arrayList[i]);
                if (meanings.size() > 0) {
                    arrayList[i] = meanings.get(0).getLemma().toString();
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
        for (String s : arrayList) {
            if (s.equals(word)) count++;
        }
        return ((double) count / arrayList.length);
    }

    public double frequency(ArrayList<String> arrayList, String word) {
        int count = 0;
        for (String s : arrayList) {
            if (s.equals(word)) count++;
        }
        return ((double) count / arrayList.size());
    }
}
