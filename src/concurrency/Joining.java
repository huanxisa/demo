package concurrency;

/**
 * @author DELL
 * 了解Join方法
 */

public class Joining {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleeper", 1500);
        Sleeper grumpy = new Sleeper("Grumy", 1500);
        Joiner dopey = new Joiner("Dopey",sleeper);
        Joiner doc = new Joiner("Doc",grumpy);
        grumpy.interrupt();

    }
}

class Sleeper extends Thread{
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run(){
        try {
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName()+"was interrputed."+"isInterrupted():"+isInterrupted());
            return;
        }
        System.out.println(getName()+"has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;

    public Joiner(String name,Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println(getName() + "join completed");
    }
}

