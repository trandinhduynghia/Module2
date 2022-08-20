package inserttion_sort;

public class MinhHoaInserttionSort {
    public static void main(String[] args) {
        int[] array = {12,2,8,5,1,6,4,15};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        insertionSort(array);
    }
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1];
                System.out.println("\nĐổi chỗ "+x+" với "+array[pos]);
                pos--;
            }
            array[pos] = x;
        }
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
