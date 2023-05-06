package Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundWildCard {
    public static void main(String[] args) {
        System.out.println("-------wildcard ile alt sınır----------");
        List<Integer> integerList=new ArrayList<>();
        addElements(integerList);
        System.out.println(integerList);

        List<Number> numberList=new ArrayList<>();
        addElements(numberList);
        System.out.println(numberList);

        List<Double> doubleList=new ArrayList<>();
        //cte verir..Integerın parentlerını kabul eder

        System.out.println("-------wildcard ile ust sınır----------");
        multiplyByTwo(integerList);
        multiplyByTwo(doubleList);
        multiplyByTwo(numberList);


        System.out.println("-------wildcard veya Object----------");
        List<String> stringList=new ArrayList<>();
        printElements(integerList);
        printElements(stringList);
        //---------print object----------------------
        List<Object> objectList=new ArrayList<>();
        printElementsObject(objectList);
        //printElementsObject(stringList);--> List<Object> List<String> in parent ı degildir

    }

    //Integer data tipinin super class ları ile olusan liste eleman ekleyen method
    //Integer, Number, Object
    //wildcard:? :nilinmeyen data tipi
    public static void addElements(List<? super Integer> list){
        for (int i=1;i<=10;i++){
            list.add(i);
        }
    }
    //alt sınır için super keywordu ile
    //ust sınır icin extends keywordu ile
    //T ile ? aynı anlamda degildir!!!!!!

    //upperbound da wildcard kullanımı
    public static void multiplyByTwo(List<? extends Number> list){
        //list.add(1);--> listte degisiklige izin vermez
        list.stream().map(t->2*t.doubleValue()).forEach(System.out::println);
    }

    //wildcard kısıtlaması:wildcard okunabilirliği artırır ancak bazı kıstlamaları var
    public static void printElements(List<?> listOfUnknown){
        //listOfUnknown.add("Java"); -->tür bilinmediği için izin vermiyor.
        // add metodu gibi işlemlere izin vermez.
        //okumaya izin verir. salt-okunur değil ama böyle düşünülebilir.
        // türden bağımsız işlemlere izin verir. size,clear,remove...
        //listOfUnknown.size();

        //listOfUnknown.add(null);//-->null :data tipi yok
        for (Object object:listOfUnknown){
            System.out.println(object);
        }
    }
    public static void printElementsObject(List<Object> listOfUnknown){
        //listOfUnknown.add("Java"); -->tür bilinmediği için izin vermiyor.
        for (Object object:listOfUnknown){
            System.out.println(object);
        }
    }

}
