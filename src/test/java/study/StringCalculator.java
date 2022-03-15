package study;

public class StringCalculator {

    public static String[] blankSplit(String input){
        return input.split(" ");
    }

    public static int stringToInteger(String input){
        return Integer.parseInt(input);
    }

    public static int arithmetic2Elements(int a, String sign, int b){
        if(sign.equals("+")) a+=b;
        if(sign.equals("-")) a-=b;
        if(sign.equals("*")) a*=b;
        if(sign.equals("/")) a/=b;
        return a;
    }

    public static int arithmeticLogic(String[] input){
        //재귀하려면 inner배열을 복사하는 과정에서 시간복잡도 늘어나므로 그냥 for문 순차진행

        int output = stringToInteger(input[0]);
        for(int i=2; i<input.length; i+=2){
            int chain = stringToInteger(input[i]);
            output = arithmetic2Elements(output, input[i-1], chain);
        }

        return output;
    }
}
