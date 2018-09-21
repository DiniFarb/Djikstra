package DjikstraAlg;

/**
 * Class node: Describes the properties for the node.
 *
 * @version 1.0
 * @autor   Andreas and Patrick
 * @date    21.09.2018
 */
public class Node
{
    private int actTempDist;
    private String predecessorNode;
    private Boolean visited;
    private String name;


    /**
     * Constructure: Create a new object from node
     *
     * @param name Name for the node
     * @return  none
     */
    public Node(String name)
    {
        this.name = name;
        this.visited = false;
        this.actTempDist = Integer.MAX_VALUE;
    }


    /**
     * Constructure: Create a new object from node
     *
     * @param name Name for the node
     * @return  none
     */
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
