package predictive;


public class Sigs2WordsProto {

    public static void main(String[] args) {

        long startS;
        long endS;
        long totS;

        startS = System.currentTimeMillis();

        //This loop, looks at each argument and performs the action one at a time


        for( int i= 0; i< args.length; i++) {

            System.out.println(args[i] + " : "

                    + PredictivePrototype.signatureToWords(args[i]));
        }

        endS=System.currentTimeMillis();

        totS=endS-startS;

        System.out.print('\n'+"Total time to process Slow: " + totS);
    }
}

