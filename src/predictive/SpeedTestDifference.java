package predictive;

/**
 * This Main method allows for a quick comparison in speeds for the
 * SignatureToWord methods for MapDictionary, ListDictionary and PredictivePrototype
 */
public class SpeedTestDifference {

    public static void main(String[] args) {

        Sigs2WordsMap.main(args);

        Sigs2WordsList.main(args);

        Sigs2WordsProto.main(args);
    }
}
