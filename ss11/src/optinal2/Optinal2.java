package optinal2;

import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

public class Optinal2 {
    public static void main(String[] args) {
        System.out.print("Nhập vào chuỗi cần kiểm tra:");
        Scanner in=new Scanner(System.in);
        String inputString = in.nextLine();
        Stack stack = new Stack();
        for(int i = 0; i < inputString.length(); i++){
            stack.push(inputString.charAt(i));
        }
        Queue queue = new LinkedList();
        for (int i = inputString.length()-1; i >=0; i--) {
            queue.add(inputString.charAt(i));
        }
        if (stack.equals(queue))
            System.out.println("Đây là chuỗi đối xứng.");
        else
            System.out.println("Đây không phải là chuỗi đối xứng.");
    }
}
