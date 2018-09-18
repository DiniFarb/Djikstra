package DjikstraAlg;

public class Node
{
    int actTempDist;
    Node predecessorNode = new Node();
    Boolean visited;


    public Node()
    {
        this.visited = false;
        this.actTempDist = -1;
    }

    public void setTempDist(int dist)
    {

    }

    public int getTempDist()
    {

        return 0;
    }

    public void setPredecessorNode(Node node)
    {

    }

    public Node getPredecessorNode()
    {

        return predecessorNode;
    }

    public void  setVisited(Boolean value)
    {

    }

    public Boolean getVisited()
    {

        return false;
    }
}
