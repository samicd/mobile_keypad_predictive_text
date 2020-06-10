package predictive;

public class Words2SigProto {

    public static void main(String[] args) {
        int i= 0;


        while(i< args.length)

            if(PredictivePrototype.isValidWord(args[i])) {

                System.out.println(
                        //args[i] + " : " +
                        PredictivePrototype.wordToSignature(args[i]));
                i++;
            }
            else {
                i++;
            }

    }
}
