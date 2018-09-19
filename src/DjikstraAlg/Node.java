package DjikstraAlg;

public class Node
{
    private int actTempDist;
    private String predecessorNode;
    private Boolean visited;


    public Node()
    {
        this.visited = false;
        this.actTempDist = -1;
    }

    public void setTempDist(int dist)
    {
        this.actTempDist = dist;
    }

    public void addTempDist(int dist)
    {
        this.actTempDist += dist;
    }

    public int getTempDist()
    {
        return this.actTempDist;
    }

    public void setPredecessorNode(String node)
    {
        predecessorNode = node;
    }

    public String getPredecessorNode()
    {
        return predecessorNode;
    }

    public void  setVisited(Boolean value)
    {
        this.visited = value;
    }

    public Boolean getVisited()
    {
        return this.visited;
    }
}
