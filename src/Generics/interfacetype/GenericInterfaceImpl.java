package Generics.interfacetype;
//eğer bir class generic interface i implement ederse, bu classın da generic yapıda olması gerekir.
public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    @Override
    public void printValue(T type) {

    }

    @Override
    public T getValue() {
        return null;
    }
}