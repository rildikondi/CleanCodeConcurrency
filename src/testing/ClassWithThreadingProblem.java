package testing;

public class ClassWithThreadingProblem {
    int lastId;

    public int takeNextId() {
        return lastId++;
    }


}
