package Threads;
/*
Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.

wait yada notify monitor edilen(kilitleme) obje icin cagrilir
*/
public class WaitNotify {

    public static int balance=0;//her iki thread de bakiyeyi degistirmeye calisiyor

    public static void main(String[] args) {

        WaitNotify obj=new WaitNotify();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("ogrenci");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.deposit(2000);
            }
        });
        thread2.setName("veli");
        thread2.start();


    }


    //para çekme işlemi için metod oluşturalım
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor.");
        if(balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz...Mevcut bakiye :"+balance);
            System.out.println("Bakiyenin güncellenmesini bekliyor.");
            try {
                wait();//Object classinin static metodu wait methodu hamgi thread uzerinde is thread gecici olarak beklemeye alinir
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//bakiye yeterli ise
        if(balance>=amount){
            balance=balance-amount;
            System.out.println("Para çekme işlemi gerçekleşti... Mevcut bakiye : "+balance);
        }else{
            System.out.println("Bakiye yetersiz...Mevcut bakiye :"+balance);
            System.out.println("Umudunu kaybetme, yarın yine gel:)");
        }
    }
    //para yatırma metodu
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor...");
        balance=balance+amount;
        System.out.println("Para yatırma işlemi gerçekleşti...Mevcut bakiye:"+balance);
        //bakiye guncelleme yapildigi icin diger thread e haber gonderir
        notify();//obj serbest birakmaz
        System.out.println();
        System.out.println("notify metodu çağırılınca hemen kilidi serbest bırakmıyor metodun tamamlanmasını bekler. ");
    }



}