package optional1;

import stack.Stack;

import java.util.Scanner;

public class Optional1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số: ");
        int number = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (number != 0){
            int number1 = number % 2;
            stack.push(number1);
            number /= 2;
        }
        System.out.println("Số sau khi đổi thành nhị phận: ");
        while (!(stack.isEmty())){
            System.out.print(stack.pop());
        }
    }
}
