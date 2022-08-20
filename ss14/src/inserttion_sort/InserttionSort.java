package inserttion_sort;

public class InserttionSort {
    public static void main(String[] args) {
        int[] array = {2,3,2,5,6,1,-2,3,14,12};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
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
                pos--;
            }
            array[pos] = x;
        }
        System.out.println("\nMảng sau khi sắp xếp: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
