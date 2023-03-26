package org.example;

import java.text.BreakIterator;
import java.util.Locale;
import java.util.regex.Pattern;

public class StringDataServiceImp implements StringDataService {
    public StringOutputData stringExtractionService(String input){
        Locale currentLocale = new Locale("en", "US");
        BreakIterator sentenceIterator
                = BreakIterator.getSentenceInstance(currentLocale);
        StringOutputData data = new StringOutputData();

        data.setPalindrome(countAllPalindromes(input));
        data.setSentenceCount(countSentences(input, sentenceIterator));
        data.setPhoneAndIdNumbersCount(countNumbersAndID(input));

        return data;
    }

    private static int checkPalindromeByTwoWayExpansion(String input, int leftPart, int rightPart) {
        int count = 0;
        for (; leftPart >= 0 && rightPart < input.length(); --leftPart, ++rightPart) {
            if (input.charAt(leftPart) != input.charAt(rightPart)) {
                break;
            }
            count++;
        }
        return count;
    }

    private static int countAllPalindromes(String input) {
        int count = 0;
        for(int i = 0 ; i < input.length() ; ++i) {
            count+= checkPalindromeByTwoWayExpansion(input, i-1, i+1);
            count+= checkPalindromeByTwoWayExpansion(input, i, i+1);
        }
        return count;
    }

    private int countNumbersAndID(String input) {
        return (int) Pattern.compile("(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})|\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}|[A-Za-z]{2}[0-9]{6}$")
                .matcher(input)
                .results()
                .count();
    }

    private int countSentences(String target, BreakIterator iterator) {
        StringBuilder markers = new StringBuilder();
        markers.setLength(target.length() + 1);
        for (int i = 0; i < markers.length(); i++) {
            markers.setCharAt(i, ' ');
        }
        int count = 0;
        iterator.setText(target);
        int boundary = iterator.first();
        while (boundary != BreakIterator.DONE) {
            markers.setCharAt(boundary, '^');
            ++count;
            boundary = iterator.next();
        }
        return count-1;
    }
}
