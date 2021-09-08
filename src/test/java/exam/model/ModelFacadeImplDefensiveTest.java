package exam.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;

/**
 * Some trivial defensive checks.
 */
public class ModelFacadeImplDefensiveTest {
    private ModelFacade model;

    @Before
    public void setup() throws FileNotFoundException {
        /**
         * Initialise the model to be in offline mode first.
         */
        List<String> args = Arrays.asList("offline", "offline");
        model = new ModelFacadeImpl(args);
    }

    @Test
    public void testLocateNull() throws IOException {
        try {
            model.locate(null);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testLocateEmpty() throws IOException {
        try {
            model.locate("");
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testGenerateReportNull() throws IOException {
        try {
            model.generateReport(null);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testSetGMTLess() {
        try {
            model.setGMT(-13);
            fail();
        } catch(IllegalArgumentException e) {}

        try {
            model.setGMT(Integer.MIN_VALUE);
            fail();
        } catch(IllegalArgumentException e) {}
    }

    @Test
    public void testSetGMTOver() {
        try {
            model.setGMT(13);
            fail();
        } catch(IllegalArgumentException e) {}

        try {
            model.setGMT(Integer.MAX_VALUE);
            fail();
        } catch(IllegalArgumentException e) {}
    }
}
