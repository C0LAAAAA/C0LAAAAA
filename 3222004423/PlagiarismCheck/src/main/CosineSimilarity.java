package Main;

public class CosineSimilarity {
    public static double getSimilarity(int[] number1, int[] number2) {
        float square1=0,square2=0,product=0;
        for(int i=0;i<number1.length;i++){

            product+=number1[i]*number2[i];

            square1 += (float) Math.pow(number1[i], 2);
            square2 += (float) Math.pow(number2[i], 2);
        }
        return (float) (product / (Math.sqrt(square1) * Math.sqrt(square2)));
    }
}
