package Generics.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {
        NonGenericClass nonGeneric1=new NonGenericClass();
        NonGenericClass nonGeneric2=new NonGenericClass();

        nonGeneric1.setObject("Advanced Java");
        nonGeneric2.setObject(65);

        //-----------------------------------------

        String str=(String) nonGeneric1.getObject();//CAST problemi
        System.out.println(str);

       // String str2=(String) nonGeneric2.getObject();
       // System.out.println(str2);//RTE !!

        Integer num=(Integer) nonGeneric2.getObject();
        System.out.println(num);
    }
}
