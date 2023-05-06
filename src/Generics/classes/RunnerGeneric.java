package Generics.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//aynı classı farklı data tipleri ile kullanabiliriz.
public class RunnerGeneric {
    public static void main(String[] args) {

        //Generics ile hangi data tipini kullanacağımızı karar verebiliriz.
        //Java 7 ile birlikte sağ tarafta data tipini yazmaya gerek kalmadı.
        GenericClass<String> object1=new GenericClass<>();
        object1.setType("Generic Class");



        //GenericClass<String> object2=new GenericClass<>();
        //     object2.setType(65);//CTE verdi, String gerekli ,int verdik.

        GenericClass<Integer> object3=new GenericClass<>();
        object3.setType(65);
        int n=object3.getType();//CASTING e gerek kalmadı.


        List<String> list=new ArrayList<>();
        list.add("Mürsel");
        list.add("Ebubekir");
        //   list.add(100);//String tipinde olduğunu belirttik.
        //   list.get(2);
        //   list.get(3);//ClassCastExceptiondan kurtulduk.

        //  NonGenericClass<String> obj=new NonGenericClass();

        Map<Integer,String> map=new HashMap<>();
        map.put(1,"Java");
        //  map.put(2,99);//CTE verir.

        //====================ÇOKLU DATA TİPİ İLE GENERIC CLASS======================================

        GenericClassTwoParam<String,Integer> mymap=new GenericClassTwoParam<>();
        mymap.setS("Generic");
        mymap.setU(99);

        System.out.println(mymap.getS()+"  "+mymap.getU());


    }


}