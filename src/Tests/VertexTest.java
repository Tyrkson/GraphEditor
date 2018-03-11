package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.IDManager;
import sample.Vertex;

public class VertexTest {

    Vertex vertex;
    String id;

    @Before
    public void setUp(){
        id = IDManager.setCustomID("69");
        vertex = new Vertex("Name");
        vertex.setID(id);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(vertex.getName(), "Name");
    }

    @Test
    public void testSetName() {
        vertex.setName("Vertex");
        Assert.assertEquals(vertex.getName(), "Vertex");
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(vertex.getId(), id);
    }

}
