/**
 * This class uses the basis of alphanumeric keyboards to create a
 * basic 'Predictive' text system. This class has 2 methods:
 *
 * Constructor
 *
 * signatureToWords -> This takes a signature and searches through
 * the list using a binary search
 *
 * @sami Cass Darweish
 */

package predictive;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static predictive.PredictivePrototype.isValidSig;
import static predictive.PredictivePrototype.isValidWord;

public class MapDictionary implements Dictionary{

    private Map<String, Set<String>> mappyMcMapFace = new HashMap<>();

    private Set<String> wordSet = new HashSet<>();



    public MapDictionary(String pathToWords){

        Path p = Paths.get(pathToWords);

        try {

            String word = null;

            Scanner s = new Scanner(p);

            while (s.hasNext()) {

                word = s.next().toLowerCase();

                if (isValidWord(word)) {


                    //need to convert word to signature

                    String signature = PredictivePrototype.wordToSignature(word);

                    //check if it contains key

                    if (!mappyMcMapFace.containsKey(signature)){

                        //make a new hash Set for the words

                        Set<String> wordSet = new HashSet<>();

                        //add the word to the set

                        wordSet.add(word);

                        //add the word and the set to the map

                        mappyMcMapFace.put(signature,wordSet);
                    }

                    else

                        //get the set of words
                        mappyMcMapFace.get(signature).add(word);

                }
            }
        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }




    @Override
    public Set<String> signatureToWords(String signature) {

        if (!isValidSig(signature))

            return new HashSet<>();

        else
           return mappyMcMapFace.get(signature);
    }
}
