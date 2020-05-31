package locking.serverbased;

import locking.clientbased.IntegerIterator;

//Use an ADAPTER to change the API and add locking when we don't own the server code
public class ThreadSafeIntegerIterator {
    private IntegerIterator iterator = new IntegerIterator();

    public synchronized Integer getNextOrNull() {
        if (iterator.hasNext())
            return iterator.next();
        return null;
    }
}
