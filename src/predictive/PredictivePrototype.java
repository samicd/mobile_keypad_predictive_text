/**
 * This class uses the basis of alphanumeric keyboards to create a
 * basic 'Predictive' text system. This class has 4 methods:
 *
 * wordToSignature -> This takes a word and converts it to a signature
 *
 * signatureToWords -> This takes a signature and scans through the
 *                     dictionary and returns the set of possible matches.
 *
 * isValidWord -> checks if a word is ONLY alphabetic
 *
 * isValidSig -> checks if a sig is ONLY numeric
 *
 * @sami Cass Darweish
 */

package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PredictivePrototype {


    /**
     * This method takes a String word and will convert it into its equivalent
     * predictive text signature.
     * @param word
     * @return String Signature
     */
    public static String wordToSignature(String word) {

        /*
            In this case string buffer is used as opposed to string as the string will call
            String buffer methods to add char to sig. Additionally temporary variables for
            every char that is added will be present until the method completes, this is
            not memory efficient.
         */

        StringBuffer sig = new StringBuffer();

        //convert word to lower case

        word = word.toLowerCase();

        //loop through input word converting each character at a time and appending them
        //to my desired output

        for(int i=0; i<word.length();i++)

            if(word.charAt(i)=='a' ||word.charAt(i)=='b' ||word.charAt(i)=='c' )
                sig.append(2);

            else if(word.charAt(i)=='d' ||word.charAt(i)=='e' ||word.charAt(i)=='f' )
                sig.append(3);

            else if(word.charAt(i)=='g' ||word.charAt(i)=='h' ||word.charAt(i)=='i' )
                sig.append(4);

            else if(word.charAt(i)=='j' ||word.charAt(i)=='k' ||word.charAt(i)=='l' )
                sig.append(5);

            else if(word.charAt(i)=='m' ||word.charAt(i)=='n' ||word.charAt(i)=='o' )
                sig.append(6);

            else if(word.charAt(i)=='p' ||word.charAt(i)=='q' ||word.charAt(i)=='r' || word.charAt(i)=='s')
                sig.append(7);

            else if(word.charAt(i)=='t' ||word.charAt(i)=='u' ||word.charAt(i)=='v' )
                sig.append(8);

            else if(word.charAt(i)=='w' ||word.charAt(i)=='x' ||word.charAt(i)=='y' ||word.charAt(i)=='z' )
                sig.append(9);

            //if its not a letter convert it into a space
            else
                sig.append(" ");

        //convert StringBuffer into String

        String signature = sig.toString();

        return signature;
    }


    /**
     * This method takes a predictive text Signature and returns the
     * set of words that could correspond to it.
     *
     * This method is inefficient for several reasons. For every signature
     * it is evaluating it runs through the words.txt file.
     *
     * Additionally the search is O(n) as it goes through the words.txt file
     * which is pretty bad. Especially when the file is approx 500,000 lines long.
     *
     * This method also must calculate the signature for a particular word everytime
     * it reads it.
     *
     * These three issues are addressed in the ListDictionary signatureToWords method
     *
     * @param signature
     * @return
     */
    public static Set<String> signatureToWords(String signature){

        Set<String> predictedWords = new HashSet<>();

        //a Guard Clause to prevent bad inputs

        if(!isValidSig(signature))
            return predictedWords;

        String fileName = "words";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String currentWord;

            /*  Loops through file reading each line at a time,
                At every iteration checking the validity of the
                line read. The line is then converted using wordToSignature.
                If it matches its added to the hashSet.
             */

            while ((currentWord = br.readLine()) != null) {

                if(isValidWord(currentWord)
                        && wordToSignature(currentWord).equals(signature))

                    predictedWords.add(currentWord.toLowerCase());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return predictedWords;
    }

    /**
     * A quick method to check the validity of the signature
     * @param signature
     * @return
     */
    static boolean isValidSig(String signature){
        int i = 0;

        while(i<signature.length()){

            if (!Character.isDigit(signature.charAt(i)))
                return false;
            else
                i++;
        }
        return true;
    }

    /**
     * A quick
     * @param word
     * @return
     */
    static boolean isValidWord(String word){

        int i = 0;

        while(i<word.length()) {

            if (!Character.isLetter(word.charAt(i)))
                return false;
            else
                i++;
        }
        return true;
    }
}
