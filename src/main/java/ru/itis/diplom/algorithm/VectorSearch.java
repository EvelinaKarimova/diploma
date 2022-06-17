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
        //String[] answerArray = answer.toLowerCase().split("[^а-я]");
        double[] searchVector = new double[numOfAllWords];
        for (int i = 0; i < numOfAllWords; i++) {
            searchVector[i] = tfCounter.frequency(answer, allWords[i].toString());
        }
        double[] similarity = new double[numOfVectors];

        double aixbi = 0;
        double ai2 = 0;
        double bi2 = 0;
        double max = 0;
        int maxIndex = 0;
        for (int i = 0; i < numOfVectors; i++) {
            for (int j = 0; j < numOfAllWords; j++) {
                aixbi += examplesAsVectors[i][j] * searchVector[j];
                ai2 += examplesAsVectors[i][j] * examplesAsVectors[i][j];
                bi2 += searchVector[j] * searchVector[j];
            }
            similarity[i] = aixbi / (Math.sqrt(ai2) * Math.sqrt(bi2));
            if (similarity[i] > max) {
                max = similarity[i];
                maxIndex = i;
            }
        }
        return max > 0.5;
    }

    /*
    public static void main(String[] args) {
        Words words = new Words();
        for (int i = 0; i <= N; i++) words.createWordsFile(i);
        words.createAllWordsFile();
        ArrayList<String> allWordsArray = new ArrayList<>(words.getAllWords());
        int numOfAllWords = allWordsArray.size();
        TFCounter tfCounter = new TFCounter(numOfAllWords);
        double[][] vectors = new double[actN + 1][numOfAllWords];
        for (int i = 0; i <= actN; i++) {
            for (int j = 0; j < numOfAllWords; j++) {
                vectors[i][j] = tfCounter.frequency("D:\\прог\\java\\infopoisk-homeworks\\vector_search\\src\\files\\file" + i + ".txt", allWordsArray.get(j));
                System.out.print(vectors[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Закончился подсчет векторов");
        System.out.println("Введите запрос: ");
        Scanner scanner = new Scanner(System.in);
        String searchLine = scanner.nextLine().toLowerCase();
        ArrayList<String> search = new ArrayList<>(List.of(searchLine.split(" ")));
        search.retainAll(allWordsArray);

        double[] searchVector = new double[numOfAllWords];
        for (int i = 0; i < numOfAllWords; i++) {
            searchVector[i] = tfCounter.frequency(search, allWordsArray.get(i));
            System.out.print(searchVector[i]);
        }
        System.out.println();

        double[] similarity = new double[actN + 1];

        double aixbi = 0;
        double ai2 = 0;
        double bi2 = 0;
        double max = 0;
        int maxIndex = 0;
        for (int i = 0; i <= actN; i++) {
            for (int j = 0; j < numOfAllWords; j++) {
                aixbi += vectors[i][j] * searchVector[j];
                ai2 += vectors[i][j] * vectors[i][j];
                bi2 += searchVector[j] * searchVector[j];
            }
            similarity[i] = aixbi / (Math.sqrt(ai2) * Math.sqrt(bi2));
            System.out.print(similarity[i] + " ");
            if (similarity[i] > max) {
                max = similarity[i];
                maxIndex = i;
            }
        }
        System.out.println("\n" + maxIndex);
    }

     */
}
