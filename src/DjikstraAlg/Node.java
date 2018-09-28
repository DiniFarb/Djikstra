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
     * Store temporary distance to startpoint
     *
     * @param dist Temprary distance to startpoint
     */
    public void setTempDist(int dist)
    {
        this.actTempDist = dist;
    }


    /**
     * Add value dist to the internal stored distance
     *
     * @param dist Distance to add
     */
    public void addTempDist(int dist)
    {
        this.actTempDist += dist;
    }


    /**
     * Return the actual temporary distance from node to startpoint
     *
     * @return int Actual temporary distance
     */
    public int getTemporaryDistance()
    {
        return this.actTempDist;
    }


    /**
     * Store the predecessorNode
     *
     * @param node Name from predecessorNode
     */
    public void setPredecessorNode(String node)
    {
        predecessorNode = node;
    }


    /**
     * Store the actual predecessorNode
     *
     * @return String Actual predecessorNode
     */
    public String getPredecessorNode()
    {
        return predecessorNode;
    }


    /**
     * Store if the node is visited or not visited
     *
     * @param value Visited = true / notvisited = false
     */
    public void  setVisited(Boolean value)
    {
        this.visited = value;
    }


    /**
     * Return if the node is visited or not visited
     *
     * @return Boolen Visited = true / notvisited = false
     */
    public Boolean getVisited()
    {
        return this.visited;
    }
}
