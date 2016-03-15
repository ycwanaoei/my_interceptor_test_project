/**
 * Created by ycw on 2016/3/8.
 */
public class Singleton {
    public Singleton(){}

    private static Singleton instance = null;

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args){
        Singleton instance =  Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
        System.out.println(instance == instance1);

    }
}
