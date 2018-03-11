package Tests;


import org.junit.Assert;
import org.junit.Test;
import sample.Edge;
import sample.Graph;
import sample.IDManager;
import sample.Vertex;

public class GraphTest{



    @Test
    public void testAddVertex() {
        Graph.addVertex(new Vertex("test"));
        Assert.assertEquals(Graph.getVertexesSize(), 1);

        Vertex tmp = new Vertex("");
        String id = IDManager.setCustomID("2");
        tmp.setID(id);
        Graph.addVertex(tmp);
        Graph.addVertex(new Vertex("asd"));

        Vertex vertex = Graph.getVertex(id);

        Assert.assertNotNull(vertex);

        Assert.assertEquals(vertex.getName(), "");
    }

    @Test
    public void testAddEdge() {
        Edge tmp = new Edge("0","0",1);
        String id = IDManager.setCustomID("1");
        tmp.setID(id);
        Graph.addEdge(tmp);
        Assert.assertEquals(Graph.getEdgesSize(), 1);

        Graph.addEdge(new Edge("0", "0" , 0));
        Graph.addEdge(new Edge("3", "2", 3));

        Edge edge = Graph.getEdge(id);

        Assert.assertNotNull(edge);

        Assert.assertEquals(edge.getId(), id);
    }
}