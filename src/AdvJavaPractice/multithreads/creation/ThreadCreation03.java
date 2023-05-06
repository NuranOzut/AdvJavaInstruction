package AdvJavaPractice.multithreads.creation;

public class ThreadCreation03 {
    public static void main(String[] args) {
        //Task 3 : Anonymous class ile thread olusumu
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Cim");
                String name= Thread.currentThread().getName();
                for (int i = 1; i <=100 ; i++) {
                    System.out.println(name +" kaciyorum..");
                }
            }
        });
        //Task 4 : Lambda expression ile thread olusumu

        Thread thread2 = new Thread(()-> {
            Thread.currentThread().setName("Bom");
            String name = Thread.currentThread().getName();
            for(int i=1 ; i<=100; i++) {
                System.out.println(name + " : yakalayacagim...");
            }
        });

        thread1.start();
        thread2.start();
    }
}
