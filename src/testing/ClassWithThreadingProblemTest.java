package testing;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * This test is trying to prove that the code in
 * ClassWithThreadingProblem is broken. If this test passes, it proved that the
 * code was broken. If this test fails, the test was unable to prove that the code
 * is broken.
 */
public class ClassWithThreadingProblemTest {
    @Test
    public void twoThreadsShouldFailEventually() throws Exception {
        final ClassWithThreadingProblem classWithThreadingProblem
                = new ClassWithThreadingProblem();
        Runnable runnable = new Runnable() {
            public void run() {
                classWithThreadingProblem.takeNextId();
            }
        };

        for (int i = 0; i < 50000; ++i) {
            int startingId = classWithThreadingProblem.lastId;
            int expectedResult = 2 + startingId;

            Thread t1 = new Thread(runnable);
            Thread t2 = new Thread(runnable);
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            int endingId = classWithThreadingProblem.lastId;

            if (endingId != expectedResult)
                return;
        }

        fail("Should have exposed a threading issue but it did not.");
    }
}
