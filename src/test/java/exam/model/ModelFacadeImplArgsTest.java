package exam.model;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

/**
 * This set of testcases tests command line argument validation process.
 */
public class ModelFacadeImplArgsTest {

    @Test
    public void testConstructorNullArgs() throws FileNotFoundException {
        try {
            new ModelFacadeImpl(null);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testConstructorEmptyArgs() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        try {
            new ModelFacadeImpl(args);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testConstructorNotEnoughArgs() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("online");
        try {
            new ModelFacadeImpl(args);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testConstructorTooManyArgs() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("online");
        args.add("online");
        args.add("online");
        args.add("online");
        try {
            new ModelFacadeImpl(args);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testConstructorInvalidArgs1() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add(null);
        args.add(null);
        try {
            new ModelFacadeImpl(args);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testConstructorInvalidArgs2() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("");
        args.add("offline");
        try {
            new ModelFacadeImpl(args);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testConstructorInvalidArgs3() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("online");
        args.add("lsdjfljsk");
        try {
            new ModelFacadeImpl(args);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testConstructorInvalidArgs4() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("online");
        args.add(null);
        try {
            new ModelFacadeImpl(args);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    @Test
    public void testConstructorValidArgs1() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("online");
        args.add("online");
        try {
            new ModelFacadeImpl(args);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void testConstructorValidArgs2() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("online");
        args.add("offline");
        try {
            new ModelFacadeImpl(args);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void testConstructorValidArgs3() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("offline");
        args.add("online");
        try {
            new ModelFacadeImpl(args);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }

    @Test
    public void testConstructorValidArgs4() throws FileNotFoundException {
        List<String> args = new ArrayList<>();
        args.add("offline");
        args.add("offline");
        try {
            new ModelFacadeImpl(args);
        } catch (IllegalArgumentException e) {
            fail();
        }
    }
}
