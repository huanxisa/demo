package concurrency;

/**
 * @author DELL
 * 这是一个线程不安全的类，后面会有一些类来使这个线程不安全的类应用于多线程环境
 */
class Pair {
    private int x , y;

    public Pair() {
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void incrementX(){
        x++;
    }

    public void incrementY(){
        y++;
    }

    public class PairValuesNotEqualException extends RuntimeException{
        public PairValuesNotEqualException() {
            super("Pair valus not equal:"+Pair.this);
        }
    }

    public void checkState(){
        if(x != y){
            throw new PairValuesNotEqualException();
        }
    }
}
