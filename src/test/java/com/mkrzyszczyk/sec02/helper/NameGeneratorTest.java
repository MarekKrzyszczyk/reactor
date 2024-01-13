package com.mkrzyszczyk.sec02.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class NameGeneratorTest {
    /**
     * Method under test: {@link NameGenerator#getNames(int)}
     */
    @Test
    void testGetNames() {
        assertEquals(3, NameGenerator.getNames(3).size());
        assertEquals(2, NameGenerator.getNames(2).size());
    }

    /**
     * Method under test: {@link NameGenerator#getNamesFlux(int)}
     */
    @Test
    void testGetNamesFlux() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by getNamesFlux(int)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        NameGenerator.getNamesFlux(3);
    }

    /**
     * Method under test: {@link NameGenerator#getNamesFlux(int)}
     */
    @Test
    void testGetNamesFlux2() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by getNamesFlux(int)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        NameGenerator.getNamesFlux(1);
    }

    /**
     * Method under test: {@link NameGenerator#getNamesFlux(int)}
     */
    @Test
    void testGetNamesFlux3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by getNamesFlux(int)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        NameGenerator.getNamesFlux(0);
    }

    /**
     * Method under test: {@link NameGenerator#getNamesFlux(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetNamesFlux4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: count >= required but it was -1
        //       at reactor.core.publisher.FluxRange.<init>(FluxRange.java:39)
        //       at reactor.core.publisher.Flux.range(Flux.java:1791)
        //       at com.mkrzyszczyk.sec02.helper.NameGenerator.getNamesFlux(NameGenerator.java:20)
        //   In order to prevent getNamesFlux(int)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getNamesFlux(int).
        //   See https://diff.blue/R013 to resolve this issue.

        NameGenerator.getNamesFlux(-1);
    }
}

