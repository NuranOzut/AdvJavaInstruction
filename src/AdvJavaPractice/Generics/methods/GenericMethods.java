package AdvJavaPractice.Generics.methods;

import java.util.Arrays;

public class GenericMethods {
    public static void main(String[] args) {
        String[] stdList ={"Bilal Bey","Ebubekir Bey","Nesrin Hanim"};
        Double[] pointList={95.4,54.3,40.2};
        Character[] gradeList={'A','B','Z','K'};

        //Listeleri ekrana basalim
        printArray(stdList);
        printArray(pointList);
        printArray(gradeList);

        //Listeleri data turlerine gore siralayalim
        System.out.println(Arrays.toString(orderArr(stdList)));
        System.out.println("**********");
        System.out.println(Arrays.toString(orderArr(pointList)));
        System.out.println("**********");
        System.out.println(Arrays.toString(orderArr(gradeList)));
        System.out.println("**********");

    }

    public static <T> void printArray(T[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> T[] orderArr(T[] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = i; j <array.length ; j++) {
                if(array[i].compareTo(array[j])>0){ //i, jden buyukse 1 doner, esitse 0 doner, kucukse -1 doner
                    T temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }


}
