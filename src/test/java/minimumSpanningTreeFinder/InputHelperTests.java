package minimumSpanningTreeFinder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author sergeioff
 */
public class InputHelperTests {
    InputHelper inputHelper = new InputHelper();

    @Test
    public void readIntegerTest() {
        inputHelper.setNewInputStream(new ByteArrayInputStream("412451".getBytes()));
        assertEquals(412451, inputHelper.readInteger());

        inputHelper.setNewInputStream(new ByteArrayInputStream("0".getBytes()));
        assertEquals(0, inputHelper.readInteger());
    }

    @Test(expected = StackOverflowError.class)
    public void readIntegerMustBrokeTest() {
        inputHelper.setNewInputStream(new ByteArrayInputStream("fawsf".getBytes()));
        inputHelper.readInteger();
    }

    @Test
    public void readIntegersTest() {
        inputHelper.setNewInputStream(new ByteArrayInputStream("1 2 3".getBytes()));
        int[] numbers = inputHelper.readIntegers();

        assertArrayEquals(new int[]{1, 2, 3}, numbers);
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void readIntegersFailTest() {
        exit.expectSystemExitWithStatus(1);

        inputHelper.setNewInputStream(new ByteArrayInputStream("1".getBytes()));
        inputHelper.readIntegers();
    }

    @Test
    public void readIntegersFailTest2() {
        exit.expectSystemExitWithStatus(1);

        inputHelper.setNewInputStream(new ByteArrayInputStream("T D D".getBytes()));
        inputHelper.readIntegers();
    }
}
