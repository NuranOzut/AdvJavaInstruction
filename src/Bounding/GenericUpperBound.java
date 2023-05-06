package Bounding;
//parametre olarak aldığımız data tipini sınırlandırabiliriz
//Bu class ta sadece Number ın child ları kullanılsın

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.font.TextHitInfo;

public class GenericUpperBound <T extends Number> {
    //T:Integer,Double,Long,Float,Number; class ı üstten sınırlandırdık.

    private T[] numberArray;//field, özellik

    public GenericUpperBound(T[] numberArray){
        this.numberArray=numberArray;

    }

    //numberArray icindeki degerlerin ortalamasını bulan metod
    public double getAvarage(){
        double sum=0;
        for (T t:this.numberArray) {
            sum+=t.doubleValue();
        }
        double avg=sum/this.numberArray.length;
        return avg;
    }
    //T upperbound olarak Number class'ini extend ettiginden
    // Number Class'inin methodlarini kullanabiliyor.

    //main method
    public static void main(String[] args) {
        Integer[] intArr={2,3,5,99};
        Double[] doubleArr={2.3,5.5,88.9};
        String[] strArr={"Generic","tipleri","üstten","sınırlandırabiliriz"};

        GenericUpperBound<Integer> obj1=new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAvarage());

        GenericUpperBound<Double> obj2=new GenericUpperBound<>(doubleArr);
        System.out.println(obj2.getAvarage());

       // GenericUpperBound<String> obj3=new GenericUpperBound<>(strArr);-->data tipini
        // number ile sınırlandırdık cte verdi





    }




}
