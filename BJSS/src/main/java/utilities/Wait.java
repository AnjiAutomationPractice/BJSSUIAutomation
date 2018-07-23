package utilities;

public class Wait {

    public static void wait1sec(){
        try {
            Thread.sleep(1000);}
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();}
    }

    public static void wait5sec(){
        try {
            Thread.sleep(5000);}
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();}
    }

    public static void wait30sec(){
        try {
            Thread.sleep(30000);}
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();}
    }

}
