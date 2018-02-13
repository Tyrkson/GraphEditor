package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sample.Vertex;

public class VertexTest {

    Vertex vertex;
    int id;

    @Before
    public void setUp(){
        id = Vertex.getAmountOfIds();
        vertex = new Vertex("Name");
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
