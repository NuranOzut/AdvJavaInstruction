package AdvJavaPractice.multithreads.creation;

public class ThreadCreation02 {
    public static void main(String[] args) {


        //!!!Task2:Runnable interfaceni implement eden Counter isminde sınıf oluşturup
        // bu sınıfta harfleri a dan z ye kadar yazdıran iki tane thread oluşturunuz.


        System.out.println("Yaris basladi...");//main
        Counter c1 = new Counter("G");//main
        Counter c2 = new Counter("S");//main

        Thread thread1 = new Thread(c1);//th1 olusuyo
        Thread thread2 = new Thread(c2);//th2 olusuyo

        thread1.start();//main + th1
        thread2.start();//main + th1 +th2

        //main thread ini bekletelim
       /*
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
*/
        //join
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Yaris bitti....");
    }
}