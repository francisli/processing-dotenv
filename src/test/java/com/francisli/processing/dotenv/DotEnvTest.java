package com.francisli.processing.dotenv;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import processing.core.PApplet;

/**
 * Unit test for simple App.
 */
public class DotEnvTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DotEnvTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DotEnvTest.class );
    }

    /**
     * Executes a GET request. TODO: make it into an actual test.
     */
    public void testGet()
    {
        PApplet stub = new PApplet();
        stub.sketchPath();
        DotEnv ENV = new DotEnv(stub);
        assertEquals("TEST_VALUE", ENV.get("TEST_KEY"));
    }
}
