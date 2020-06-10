package predictive;

import java.util.Set;

/**
 * Commndline application that will return the set of words that match the given signature
 */
public class Sigs2WordsList {

    public static void main(String[] args) {

        String s = "words";

        ListDictionary dictionaryOfWords = new ListDictionary(s);

        StringBuffer words = new StringBuffer();

        long startQ;

        long endQ;

        long totQ;

        startQ = System.currentTimeMillis();

        //This loop, looks at each argument and performs the action one at a time

        for(String x:args) {

            //calculates the set of words that match the signature

            Set<String> answer = dictionaryOfWords.signatureToWords(x);

            words.append(x);

            words.append(" : ");

            words.append(answer);

            words.append('\n');
        }

        System.out.print(words);

        endQ=System.currentTimeMillis();

        totQ=endQ-startQ;

        System.out.print('\n'+"Total time to process Quick: " + totQ + '\n' + '\n');
    }

}
