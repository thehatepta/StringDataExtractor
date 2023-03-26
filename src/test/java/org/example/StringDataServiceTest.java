package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringDataServiceTest {

    StringDataService service = new StringDataServiceImp();
    @Test
    void countPalindromeTest(){
        StringOutputData result =  service.stringExtractionService("MALAYALAM");
        assertEquals(result.getPalindrome(), 6);
    }

    @Test
    void countPhoneNumberTest(){
        StringOutputData result =  service.stringExtractionService("asdaffnsz;lkndga +1 800 555-1234ashfv     (123)456-7890zxcvAB123456");
        assertEquals(result.getPhoneAndIdNumbersCount(), 3);
    }

    @Test
    void countSentencesTest(){
        StringOutputData result =  service.stringExtractionService("This.is.a.sentence? Yes!");
        assertEquals(result.getSentenceCount(), 2);
    }
}
