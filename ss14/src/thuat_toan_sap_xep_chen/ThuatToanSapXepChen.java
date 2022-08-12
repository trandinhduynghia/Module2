package thuat_toan_sap_xep_chen;

import java.awt.*;

public class ThuatToanSapXepChen {
    public static void main(String[] args) {
        int[] array = {2,3,2,5,6,1,-2,3,14,12};
        insertionSort(array);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                System.out.println("Đổi chỗ "+array[pos]+" với "+array[pos-1]);
                pos--;
            }
            array[pos] = x;
        }
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
