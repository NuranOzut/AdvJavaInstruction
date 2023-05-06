package Generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {
        Integer[] intArr={1,23,4,65,9};
        Double[]  doubleArr={0.5,2.3,45.9,11.75};
        String[]  strArr={"Java","harika","bir","programlama","dili:)"};

        System.out.println("----------generic olmayan metod----------------");
        printArr(intArr);
        printArr(strArr);
        printArr(doubleArr);
        System.out.println("----------generic metod----------------");
        printAllArr(intArr);
        printAllArr(doubleArr);
        printAllArr(strArr);
        System.out.println("----------generic tip döndüren metod----------------");
        int n=getFisrt(intArr);
        System.out.println(n);

        String str=getFisrt(strArr);
        System.out.println(getFisrt(strArr));
        System.out.println("----------birden fazla generic tip kullanan metod----------------");
        int num=55;
        printArrAndObject(strArr,num);
        printArrAndObject(intArr,"Harika");

    }
    //arrayleri yazdırmak için metod
    public static void printArr(Integer[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //overloading...
    public static void printArr(Double[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    public static void printArr(String[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //generic metod
    public static <T> void printAllArr(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    //sonuç döndüren generic metod
    public static <T> T getFisrt(T[] arr){
        T first=arr[0];
        return first;
    }

    //birden fazla generic tip parametresi alan metod
    public static <S,U> void printArrAndObject(S[] arr,U object){


        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
        System.out.println(object);
    }



}