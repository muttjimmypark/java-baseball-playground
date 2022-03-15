package study;

import java.util.Scanner;

public class StringCalculatorMain {

    public static void main(String[] args){
        // 불완전한 수식이 들어오는경우 (띄어쓰기가 없는 경우, 숫자기호 순서가 뒤죽박죽 등)
        // 괄호 등 다른 기호가 들어오는경우
        // 결과가 정수형이 아닌경우

        StringCalculator stringCalculator = new StringCalculator();

        System.out.print("수식 입력 : ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        int output = stringCalculator.arithmeticLogic(stringCalculator.blankSplit(value));
        System.out.println("계산 결과 : " + output);
    }
}
