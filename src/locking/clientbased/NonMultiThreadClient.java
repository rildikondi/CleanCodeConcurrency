package locking.clientbased;

public class NonMultiThreadClient {

    public static void main(String[] args) {

        IntegerIterator iterator = new IntegerIterator();
        while (iterator.hasNext()) {
            int nextValue = iterator.next();
            // do something with nextValue
        }
    }
}
