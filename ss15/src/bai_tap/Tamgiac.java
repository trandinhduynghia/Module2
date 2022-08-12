package bai_tap;

import java.util.Scanner;

public class Tamgiac{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tamgiac tamgiac = new Tamgiac();
        try {
            System.out.println("Nhập vào cạnh thứ nhất: ");
            float x = scanner.nextFloat();
            System.out.println("Nhập vào cạnh thứ hai: ");
            float y = scanner.nextFloat();
            System.out.println("Nhập vào cạnh thứ ba: ");
            float z = scanner.nextFloat();
            try{
                tamgiac.checkTriangleEdges(x,y,z);
            }catch (TriangleEdgesException e){
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println("Các cạnh tam giác phải lớn hơn 0");
        }
        scanner.close();
    }
    public void checkTriangleEdges(float x, float y, float z) throws TriangleEdgesException{
        if(x + y <= z || x + z <= y || y + z <= x){
            System.out.println("ba cạnh không là tam giác");
        }else{
            System.out.println("ba cạnh  là tam giác");
        }
    }
}
