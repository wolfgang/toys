/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:13 PM
 */

package unittests;

import lib.OpCodeRegistry;
import lib.OpCodeRegistryLoader;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;


@SuppressWarnings("ALL")
public class OpCodeRegistryLoaderTest {

    private OpCodeRegistry opCodeRegistry;
    private OpCodeRegistryLoader loader;

    @Before
    public void setUp() throws Exception {
        opCodeRegistry = mock(OpCodeRegistry.class);
        loader = new OpCodeRegistryLoader(opCodeRegistry, null, null);
    }

    @Test
    public void registerKnownOPpCodes() throws Exception {
    }
}
