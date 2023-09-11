
class Thread_Test extends Thread{
    int max_num = 50;
    int temp = 0;
    int [] x = new int[50];
    Thread_Test(int [] x){
        this.x = x;
    }
    @Override
    public void run() {
        for (int i=0; i < max_num; i++){
            temp += x[i];
        }
        System.out.println(Thread.currentThread().getName() );
        System.out.println(temp);
    }
    public int getTemp(){
        return this.temp;
    }
}
public class Main {
    public static int [] getArray(int x){
        int [] temp = new int [50];
        for(int i = 0; i<50; i++){
            temp[i] = (i+x);
        }
        return temp;
    }
    public static boolean run(){
        int [] intArray_first = getArray(0);
        int [] intArray_sec = getArray(50);

        Thread a = new Thread_Test(intArray_first);
        Thread b = new Thread_Test(intArray_sec);
        a.start();
        b.start();
        return true;
    }
    public static void main(String[] args) {
        run();
    }
}