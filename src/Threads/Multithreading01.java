package Threads;

public class Multithreading01 {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        CounterWithoutMultiThread counter1=new CounterWithoutMultiThread("Ebubekir");
        CounterWithoutMultiThread counter2=new CounterWithoutMultiThread("Akın");
        counter1.countMe();
        System.out.println("------------------------------");
        counter2.countMe();
        long finish=System.currentTimeMillis();

        System.out.println("WithoutMultiThread ile geçen süre : "+(finish-start));//10 sn...

        System.out.println("-----------------------------");

        long startTime=System.currentTimeMillis();
        CounterWithMultiThread counter3=new CounterWithMultiThread("İlker");
        CounterWithMultiThread counter4=new CounterWithMultiThread("Abdullah");
        counter3.start();
        counter3.setName("İlker");
        System.out.println("-----------------------------");
        counter4.start();
        counter4.setName("Abdullah");

        try {
            counter3.join();//main threade counter3 threadinin işlemi bitene kadar bekle
            counter4.join();//main threade counter4 threadinin işlemi bitene kadar bekle
            //sonra tekrar main thread devam etsin.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finishTime=System.currentTimeMillis();
        System.out.println("WithMultiThread ile geçen süre : "+(finishTime-startTime));//5sn

    }

}


class CounterWithoutMultiThread{

    public String name;

    //constructor
    public CounterWithoutMultiThread(String name) {
        this.name = name;
    }
    //thread kullanmadan 1 den 10 a kadar yazdıran metod
    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//0.5 sn yavaşlatalım.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+ " - "+name);
        }
    }
}
class CounterWithMultiThread extends Thread{

    public String name;

    public CounterWithMultiThread(String name) {
        this.name = name;
    }
    //thread ile ekrana 1 den 10 a kadar yazdırma
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" çalışmaya başladı.");
        countMe();
    }
    public void countMe(){
        for (int i=1;i<=10;i++){
            try {
                Thread.sleep(500);//0.5 sn yavaşlatalım.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("i : "+i+ " - "+name);
        }
    }

}