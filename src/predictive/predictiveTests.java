package predictive;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static predictive.PredictivePrototype.isValidSig;
import static predictive.PredictivePrototype.isValidWord;

public class predictiveTests {

    /**
     * Word To signature test
     */
    @Test
    public void test1(){

        //base test including capitals
        String expectedResult = "4663";

        String actualResult = PredictivePrototype.wordToSignature("HOME");

        assertEquals(expectedResult,actualResult);

        //test for non char

        String aexpectedResult = "466 3";

        String aactualResult = PredictivePrototype.wordToSignature("HOM!E");

        assertEquals(aexpectedResult,aactualResult);

        //empty test
        String emptyString = "";
        String actualEmpty = PredictivePrototype.wordToSignature("");

        assertEquals(emptyString,actualEmpty);

    }

    /**
     * Testing the isValidWords and sig methods
     */
    @Test
    public void test2(){

        String failsTest = "h3llo";

        assertFalse(isValidWord(failsTest));

        String passesTest = "HELLO";

        assertTrue(isValidWord(passesTest));

        String sigPasses = "43556";
        String sigFails = "456a";

        assertTrue(isValidSig(sigPasses));

        assertFalse(isValidSig(sigFails));

        //empty test
        String emptyString = "";
        assertTrue(isValidWord(emptyString));
    }

    /**
     * Testing for the PredictivePrototype signatureToWords()
     */
    @Test
    public void test3(){

        //43556 = hello test

        Set<String> expectedWords = new HashSet<>();
        expectedWords.add("hello");
        expectedWords.add("gekko");

        Set<String> actualWords = PredictivePrototype.signatureToWords("43556");

        assertEquals(expectedWords,actualWords);

        //inValid signature returns empty set

        Set<String> actualInvalidWords = PredictivePrototype.signatureToWords("4e556");

        Set<String> expectedInvalidWords = new HashSet<>();

        assertEquals(expectedInvalidWords,actualInvalidWords);


        //empty test
        Set<String> emptyString = new HashSet<>();
        Set<String> actualEmpty = PredictivePrototype.signatureToWords("");

        assertEquals(emptyString,actualEmpty);

        //Testing the last value in the dictionary
        Set<String> endExpectedWords = new HashSet<>();
        endExpectedWords.add("xyz");
        endExpectedWords.add("xxx");
        endExpectedWords.add("zzz");


        Set<String> endActualWords = PredictivePrototype.signatureToWords("999");

        assertEquals(endExpectedWords,endActualWords);

        //Testing the first value in the dictionary

        Set<String> startExpectedWords = new HashSet<>();
        startExpectedWords.add("a");
        startExpectedWords.add("b");
        startExpectedWords.add("c");


        Set<String> startActualWords = PredictivePrototype.signatureToWords("2");

        assertEquals(startExpectedWords,startActualWords);


    }

    /**
     * Testing the List dictionary method
     */
    @Test
    public void test4(){

        ListDictionary testDictionary = new ListDictionary("words");

        //43556 = hello test

        Set<String> expectedWords = new HashSet<>();
        expectedWords.add("gekko");
        expectedWords.add("hello");
        

        Set<String> actualWords = testDictionary.signatureToWords("43556");

        assertEquals(expectedWords,actualWords);

        //inValid signature returns empty set

        Set<String> actualInvalidWords = testDictionary.signatureToWords("4e556");

        Set<String> expectedInvalidWords = new HashSet<>();

        assertEquals(expectedInvalidWords,actualInvalidWords);

        //empty test
        Set<String> emptyString = new HashSet<>();
        Set<String> actualEmpty = testDictionary.signatureToWords("");

        assertEquals(emptyString,actualEmpty);

        //Testing the last value in the dictionary
        Set<String> endExpectedWords = new HashSet<>();
        endExpectedWords.add("xyz");
        endExpectedWords.add("xxx");
        endExpectedWords.add("zzz");


        Set<String> endActualWords = testDictionary.signatureToWords("999");

        assertEquals(endExpectedWords,endActualWords);

        //Testing the first value in the dictionary

        Set<String> startExpectedWords = new HashSet<>();
        startExpectedWords.add("a");
        startExpectedWords.add("b");
        startExpectedWords.add("c");


        Set<String> startActualWords = testDictionary.signatureToWords("2");

        assertEquals(startExpectedWords,startActualWords);

    }

    /**
     * Testing WordSig
     */
    @Test
    public void test5(){

        WordSig actualWS = new WordSig("hello");

        String word = "hello";

        String signature = "43556";

        assertEquals(word,actualWS.getWords());

        assertEquals(signature,actualWS.getSignature());
    }

    /**
     * Map Dictionary Test
     */
    @Test
    public void test6(){

        MapDictionary mapOfWords = new MapDictionary("words");

        //Testing the last value in the dictionary

        Set<String> endExpectedWords = new HashSet<>();
        endExpectedWords.add("xyz");
        endExpectedWords.add("xxx");
        endExpectedWords.add("zzz");


        Set<String> endActualWords = mapOfWords.signatureToWords("999");

        assertEquals(endExpectedWords,endActualWords);

        //Testing the first value in the dictionary

        Set<String> startExpectedWords = new HashSet<>();
        startExpectedWords.add("a");
        startExpectedWords.add("b");
        startExpectedWords.add("c");


        Set<String> startActualWords = mapOfWords.signatureToWords("2");

        assertEquals(startExpectedWords,startActualWords);




    }

}
