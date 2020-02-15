package com.practice.strings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustifiedText {

    @Test
    public void test() {
        List<String> input = Arrays.asList("This", "is", "an", "example", "of", "text", "justification.");
        ArrayList<String> output = fullJustify(input, 16);
        for (String l : output) {
            System.out.println(l + "|");
        }
    }

    public static final String SPACE = " ";

    public ArrayList<String> fullJustify(List<String> input, int lineLength) {
        ArrayList<String> output = new ArrayList<>();

        int wordsLength = 0;
        ArrayList<String> words = new ArrayList<>();
        for (String word : input) {
            if (wordsLength + word.length() + words.size() > lineLength) {
                output.add(justifyLine(words, wordsLength, lineLength));
                wordsLength = 0;
                words = new ArrayList<>();
            }

            words.add(word);
            wordsLength += word.length();
        }

        if (!words.isEmpty()) {
            output.add(justifyLastLine(lineLength, words));
        }

        return output;
    }

    private String justifyLastLine(int lineLength, ArrayList<String> words) {
        String line = "";
        for (String word : words) {
            line += word + SPACE;
        }

        line = line.trim();
        for (int i = line.length(); i < lineLength; i++) {
            line += SPACE;
        }
        return line;
    }

    private String justifyLine(ArrayList<String> words, int wordsLength, int lineLength) {
        if (words.size() == 1) {
            String line = words.get(0);
            for (int i = line.length(); i < lineLength; i++) {
                line += SPACE;
            }
            return line;
        }

        int totalSpaces = lineLength - wordsLength;
        int space = totalSpaces / (words.size() - 1);
        int extraSpaces = totalSpaces % (words.size() - 1);

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));
            if (i != words.size() - 1) {
                for (int j = 0; j < space; j++) {
                    line.append(SPACE);
                }

                if (extraSpaces > 0) {
                    line.append(SPACE);
                    extraSpaces--;
                }
            }
        }

        return line.toString();
    }
}
