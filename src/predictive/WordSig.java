/**
 * This class makes pairs between words and their signatures.
 * This class has 2 constructors,
 *      - One in which the word is known but not the signature
 *      - Another that allows both to be input
 *
 * @Author Sami Cass Darweish
 */

package predictive;

import static predictive.PredictivePrototype.wordToSignature;

public class WordSig implements Comparable<WordSig> {

    private  String words;
    private String signature;

    public WordSig (String words) {
        this.words = words;

        //Signature is calculated using wordToSignature

        this.signature = wordToSignature(words);
    }

    public WordSig (String word, String signature){
        this.words = word;
        this.signature = signature;
    }


    public String getWords() {
        return words;
    }

    public String getSignature() {
        return signature;
    }

    /**
     * This compare to method will compare WordSigs by their Signature
     * @param o
     * @return
     */
    @Override
    public int compareTo(WordSig o) {

        return this.getSignature().compareTo(o.getSignature());
    }

    @Override
    public String toString() {
        return "WordSig{" +
                "words='" + words + '\'' +
                ", signature='" + signature + '\'' +
                '}' + '\n';
    }
}
