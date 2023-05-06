package Threads;
//metod içerisinde istenmeyen sonuca sebep olmayan kodlar da varsa
public class SyncronizedKeyword {
    public static void main(String[] args) {
        Brackets2 brackets2=new Brackets2();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets2.generateBrackets();
                }
            }
        });
        thread2.start();

    }



}
class Brackets2{
    //[ [ [ [ [ ] ] ] ] ] şeklini ekrana yazdıran bir metod
    public synchronized void generateBrackets(){
        for (int i=1;i<=10;i++){
            if(i<=5){
                System.out.print("[ ");
            }else{
                System.out.print("] ");
            }
        }
        System.out.println();

        //asenkron çalışmasında problem olmayan kodlar
        for (int i=1;i<=5;i++){
            //başka kodlar
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}