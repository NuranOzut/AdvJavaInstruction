package Threads;
//Thread bir processin parçasıdır, birden fazla thread kullandığımızda
//multithreading yaparak eş zamanlı görevler yapabiliriz, CPU en verimli şekilde kullanabiliriz.
public class ThreadCreationWays {
    public static void main(String[] args) {
        //ilk çalışan thread main threaddir, görelim:
        System.out.println("Current thread: "+Thread.currentThread().getName());

        //Thread classını extend ederek
        MyThread thread1=new MyThread();
        //thread1.run();//run metodu içindeki kodlar çağrılır
        thread1.start();
        //start metodu threar oluşturur, override edilen run metodunu çağırır ve içerisindeki işlemleri
        //gerçekleştirir.
        //doğrudan run metodu çağrıldığında içindeki işlemler yapılır ancak thread oluşmaz. Yani run metodu main
        //thread içinde çalışmış olur.

        // Runnable interfaceini implement ederek
        MyRunnable myRunnable=new MyRunnable();
        Thread thread2=new Thread(myRunnable);
        thread2.start();

        //annonymous(isimsiz) class ile thread oluşturma
        //Runnable interfaceini implemente eden isimsiz bir class
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);//5 sn threadi duraklattık
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current thread:"+Thread.currentThread().getName());
                System.out.println("Bu thread isimsiz class ile oluşturuldu.");
            }
        });
        thread3.setName("threadcik");
        thread3.start();

        //annonymous(isimsiz) class ile thread oluşturma:2
        //lambda exp kullanarak
        Thread thread4=new Thread( ()->{
            Thread.currentThread().setName("harika");
            System.out.println("Current thread:"+Thread.currentThread().getName());
            System.out.println("Bu thread lambda ile oluşturuldu.");
        }
        );
        thread4.start();


        Thread thread5=new Thread(()-> {
            System.out.println("Current thread:"+Thread.currentThread().getName());
            System.out.println("Bu thread lambda ile oluşturuldu.");
        });
        thread5.start();



        System.out.println("main metodun işlemi burada bitti");


    }

}
//Thread oluşturma:
//1.yol : Thread Classını extend ederek
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread threadi çalışıyor. ");
    }
}

//2.yol : Runnable interfaceini implement ederek
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable ile oluşturduğumuz thread çalışıyor.");
    }
}
