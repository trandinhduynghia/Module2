package stack;

import java.util.*;
import java.util.Stack;
public class StackTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = {5,4,3,2,1};
        Stack<Integer> stack = new Stack<>();
        System.out.print("Mang so nguyen la: ");
        for(int i = 0; i < numbers.length; i++){
            System.out.print(stack.push(numbers[i]));
        }
        System.out.println("\nMang so nguyen sau khi dao nguoc la: ");
        for(int i = 0; i < numbers.length; i++){
            System.out.print(stack.pop());
        }

        Stack<Character> stack1 = new Stack<>();
        String s = "tran dinh duy nghia";
        System.out.println("\nChuoi la: ");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(stack1.push(s.charAt(i)));
        }
        System.out.println("\nChuoi sau khi dao nguoc la: ");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(stack1.pop());
        }
    }
}
