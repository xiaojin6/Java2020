package Singleton;

public class SingletonTest {

    public static void main(String []args){

        //Singleton singleton = new Singleton();
        //tips：'Singleton()' has private access in 'Singleton'
        Singleton obj = Singleton.getInstance();
        obj.getMessage();

    }
}