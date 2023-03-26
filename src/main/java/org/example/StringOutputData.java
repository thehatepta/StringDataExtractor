package org.example;

public class StringOutputData {
    int palindromeCount;
    int sentenceCount;
    int phoneAndIdNumbersCount;

    @Override
    public String toString() {
        return "Amount of palindromes: " + palindromeCount + "\n" +
                "Amount phone numbers and passport IDs: " + phoneAndIdNumbersCount + "\n" +
                "Amount of sentences: " + sentenceCount;
    }

    public int getPalindrome() {
        return palindromeCount;
    }

    public void setPalindrome(int palindromeCount) {
        this.palindromeCount = palindromeCount;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public void setSentenceCount(int sentenceCount) {
        this.sentenceCount = sentenceCount;
    }


    public int getPhoneAndIdNumbersCount() {
        return phoneAndIdNumbersCount;
    }

    public void setPhoneAndIdNumbersCount(int phoneAndIdNumbersCount) {
        this.phoneAndIdNumbersCount = phoneAndIdNumbersCount;
    }



}
