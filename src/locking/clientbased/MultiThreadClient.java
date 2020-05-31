package locking.clientbased;

public class MultiThreadClient {

    public static void main(String[] args) {

        IntegerIterator iterator = new IntegerIterator();
        while (true) {
            int nextValue;

            synchronized (iterator) {
                if (!iterator.hasNext())
                    break;
                nextValue = iterator.next();
            }
            //doSometingWith(nextValue);
        }
    }
}
