package Tests;


import org.junit.Assert;
import org.junit.Test;
import sample.Edge;
import sample.Graph;
import sample.Vertex;

public class GraphTest{



    @Test
    public void testAddVertex() {
        Graph.addVertex(new Vertex("test"));
        Assert.assertEquals(Graph.getVertexesSize(), 1);

        Graph.addVertex(new Vertex(""));
        Graph.addVertex(new Vertex("asd"));

        Vertex vertex = Graph.getVertex(2);

        Assert.assertNotNull(vertex);

        Assert.assertEquals(vertex.getName(), "asd");
    }

    @Test
    public void testAddEdge() {
        Graph.addEdge(new Edge(0, 0, 1));
        Assert.assertEquals(Graph.getEdgesSize(), 1);

        Graph.addEdge(new Edge(0, 0 , 0));
        Graph.addEdge(new Edge(3, 2, 3));

        Edge edge = Graph.getEdge(1);

        Assert.assertNotNull(edge);

        Assert.assertEquals(edge.getId(), 1);
    }
}