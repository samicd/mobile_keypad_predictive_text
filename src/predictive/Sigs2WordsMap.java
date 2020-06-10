package predictive;

import java.util.Set;

public class Sigs2WordsMap {

    public static void main(String[] args) {

        String s = "words";

        MapDictionary mapOfWords = new MapDictionary(s);

        StringBuffer words = new StringBuffer();

        long startQ;

        long endQ;

        long totQ;

        startQ = System.currentTimeMillis();

        //This loop, looks at each argument and performs the action one at a time

        for( int i= 0; i< args.length; i++) {

            //calculates the set of words that match the signature

            Set<String> answer = mapOfWords.signatureToWords(args[i]);

            words.append(args[i]);

            words.append(" : ");

            words.append(answer);

            words.append('\n');
        }

        System.out.print(words);

        endQ=System.currentTimeMillis();

        totQ=endQ-startQ;

        System.out.print('\n'+"Total time to process Map: " + totQ + '\n' + '\n');



    }



}
