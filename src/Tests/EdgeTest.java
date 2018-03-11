package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.Edge;

public class EdgeTest{
    Edge edge;


    @Before
    public void setUp() {
        edge = new Edge("0", "1", 5);
    }

    @Test
    public void testGetVertexFromID() {
        Assert.assertEquals(edge.getVertexFromID(), "0");
    }

    @Test
    public void testGetVertexToID() {
        Assert.assertEquals(edge.getVertexToID(), "1");
    }

    @Test
    public void testGetWeight() {
        Assert.assertEquals(edge.getWeight(), 5);
    }

    @Test
    public void testSetWeight() {
        edge.setWeight(0);
        Assert.assertEquals(edge.getWeight(), 0);
    }

    @Test
    public void testGetAmountOfIds(){
        Assert.assertEquals(Edge.getAmountOfIds(), 1);
    }

    @After
    public void tearDown(){
        Edge.delete(edge);
    }
}
