package serialization;

import java.io.*;

//ObjectOutputStream Java objelerini kodlar ve karşılık gelen akışları oluşturur.
//bu işleme serialization denir.

public class Serialization_Deserialization {
    public static void main(String[] args) {

        //writeObjects();
        readObject();
    }

    //objectleri dosyaya yazdırma
    public static void writeObjects() {
        System.out.println("User objeleri oluşturuluyor...");
        User user1 = new User(1L, "Ferit", "55522233311");
        User user2 = new User(2L, "Necmi", "55522233312");
        User user3 = new User(3L, "Şaban", "55522233313");
        User user4 = new User(4L, "Mahmut", "55522233314");

        try {
            //objelerin yazılacacağı dosyaya yazmak için
            FileOutputStream fos = new FileOutputStream("user.txt");
            //objeleri yazmak için
            ObjectOutputStream output = new ObjectOutputStream(fos);
            //OOS in objeleri akısıa yazdırabilmesi icin objelerin classı serializable interface ini
            //imp etmiş olmalı Cunku objelerin serilestirilmesi gerekli
            output.writeObject(user1);
            output.writeObject(user2);
            output.writeObject(user3);
            output.writeObject(user4);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Objectleri dosyadan okuma: de-serialization
    public static void readObject() {

        try {
            //okuyacağımız dosyayı belirleme
            FileInputStream fis = new FileInputStream("user.txt");
            //objeleri okuma icin
            ObjectInputStream input=new ObjectInputStream(fis);
            User user1=(User)input.readObject();
            User user2=(User)input.readObject();
            User user3=(User)input.readObject();
            User user4=(User)input.readObject();

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);


        } catch(FileNotFoundException e){
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    }
