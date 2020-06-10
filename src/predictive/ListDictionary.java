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

/**
 * This class allows the user to do more efficient dictionary search
 */
public class ListDictionary implements Dictionary {

    private String words;

    private ArrayList<WordSig> pairs = new ArrayList<>();

    public ListDictionary(String words) {

        //Words converted to a path object
        Path p = Paths.get(words);

        try {

            String word=null;


            Scanner s = new Scanner(p);

            //reads the dictionary in and aslong as the words are valid
            //add to pairs list

            while(s.hasNext()) {

                word = s.next();

                if(isValidWord(word)) {

                    WordSig newPair = new WordSig(word);

                    pairs.add(newPair);

                }
            }

            Collections.sort(pairs);

        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * Gets pairs list
     * @return
     */
    public ArrayList<WordSig> getPairs() {
        return pairs;
    }

    /**
     * Using a more efficient method than previously convert predictive text
     * signatures into a possible set of matching words
     *
     * The words.txt file is evaluated only once, when the object is created,
     * this saves significant time when comparing multiple words.
     *
     * This search is O(logN) due to the use of a binarySearch, as a binary search
     * returns an index that could have matching results above and below we must search
     * around for further matches. This increases the complexity of the search by some
     * constant equal to the number of matches there are for a particular signature
     *
     * Signatures for words aren't required to be calculated each time for the words.txt
     * this is via the use of the WordSig class that already creates pairs between words
     * and signatures.
     *
     * These time savings amount to this method being approximatly 1000 times quicker than
     * the prototype method.
     *
     * @param signature
     * @return
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        Set<String> predictedWords = new HashSet<>();

        //checks input is only numeric

        if(!isValidSig(signature))
            return predictedWords;

        //as we don't know the matching word, this part of the pair is null

        WordSig key = new WordSig(null,signature);

        //binary search returns an index, this index is stored

        int index = Collections.binarySearch(this.getPairs(),key);

        if (index<0)
            return predictedWords;

        //add that word at the initial index

        predictedWords.add(this.getPairs().get(index).getWords().toLowerCase());

        int lowerBound = index;

        int upperbound = index;


        //loop downwards adding all the matching signatures until there isn't a match

        while(upperbound<getPairs().size() && getPairs().get(upperbound).getSignature().equals(signature)) {

            predictedWords.add(this.getPairs().get(upperbound).getWords().toLowerCase());
            upperbound++;
        }

        //loop upwards adding all the matching signatures until there isn't a match

        while (lowerBound>0 && signature.equals(getPairs().get(lowerBound).getSignature())){

            predictedWords.add(this.getPairs().get(lowerBound).getWords().toLowerCase());
            lowerBound--;
        }

        return predictedWords;
    }
}
