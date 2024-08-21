package services;

public class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add() {
        count++;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Count closed");
    }

    public int getCount() {
        return count;
    }
}    
