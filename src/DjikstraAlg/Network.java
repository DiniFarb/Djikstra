package DjikstraAlg;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class Network: Create a new object from network
 * class Network contains the map with all nodes, neighbours and their distance.
 *
 * @version 1.0
 * @autor   Andreas and Patrick
 * @date    21.09.2018
 */
public class Network
{
    private String[][] mainNodeList = {
            {"A","B","6"},
            {"A","D","7"},
            {"B","C","4"},
            {"B","E","4"},
            {"C","F","6"},
            {"C","I","8"},
            {"D","G","5"},
            {"E","J","5"},
            {"F","K","5"},
            {"G","H","5"},
            {"G","I","7"},
            {"H","L","5"},
            {"I","M","5"},
            {"J","K","7"},
            {"J","T","4"},
            {"K","U","9"},
            {"L","M","6"},
            {"M","N","5"},
            {"N","O","7"},
            {"O","Q","5"},
            {"P","Q","8"},
            {"P","U","2"},
            {"Q","X","7"},
            {"R","T","8"},
            {"R","Y","10"},
            {"R","Z","4"},
            {"S","W","2"},
            {"S","X","4"},
            {"T","V","7"},
            {"W","Y","9"},
            {"X","Y","11"}};


    /**
     * Constructure:
     *
     */
    public Network()
    {

    }


    /**
     * Create a list (HashMap) from all nodes.
     * Into HashMap the nodes are stored like:  {"A", Node},{"B", Node}
     *
     * @return  none
     */
    public HashMap<String, Node> createNodes()
    {
        HashMap<String, Node> mapWithAllNodes = new HashMap<>();

        /* Temprary ArrayList for create a table from all nodes without duplicates */
        ArrayList<String> nodeNames = new ArrayList<>();
        for(int i = 0; i < mainNodeList.length; i++)
        {
            /* Eliminate duplicate nodes */
            /* and create for every node a new object */
            /* store the node-objects into a HashMap */
            if(nodeNames.indexOf(mainNodeList[i][0]) == -1)
            {
                nodeNames.add(mainNodeList[i][0]);
                mapWithAllNodes.put(mainNodeList[i][0], new Node(mainNodeList[i][0]));
            }
            if(nodeNames.indexOf(mainNodeList[i][1]) == -1)
            {
                nodeNames.add(mainNodeList[i][1]);
                mapWithAllNodes.put(mainNodeList[i][1], new Node(mainNodeList[i][0]));
            }
        }

        return mapWithAllNodes;
    }


    /**
     * Search and store into a list all neighbours with their distance to the requested node
     *
     * @param node Node from where you want to know his neighbours with their distance
     * @return HashMap Map with all neighbours and their distance to the requested node
     */
    public HashMap<String, Integer> getNeighboursAndDistance(String node)
    {
        HashMap<String, Integer> neighbourAndDistanceMap = new HashMap<>();

        for (int i = 0; i < mainNodeList.length; i++)
        {
            if(node.indexOf(mainNodeList[i][0]) != -1)
            {
                neighbourAndDistanceMap.put(mainNodeList[i][1], Integer.parseInt(mainNodeList[i][2]));
            }
            if(node.indexOf(mainNodeList[i][1]) != -1)
            {
                neighbourAndDistanceMap.put(mainNodeList[i][0], Integer.parseInt(mainNodeList[i][2]));
            }
        }
        return neighbourAndDistanceMap;
    }


    /**
     * Search and return the actual shortest distance from the complete node map
     *
     * @return String shortest distance
     */
    public String getNodeWithActualShortestDistance(HashMap<String, Node> mapWithAllNodes)
    {
        int minDistance = Integer.MAX_VALUE;
        String minNode = "null";

        for (int i = 0; i < mapWithAllNodes.size(); i++)
        {
            /* Calculate from the unvisited and distance not -1 nodes the shortest distance to the predecessorNode */
            if((mapWithAllNodes.get(mapWithAllNodes.keySet().toArray()[i]).getTemporaryDistance() != Integer.MAX_VALUE) && (mapWithAllNodes.get(mapWithAllNodes.keySet().toArray()[i]).getVisited() == false))
            {
                if(mapWithAllNodes.get(mapWithAllNodes.keySet().toArray()[i]).getTemporaryDistance() < minDistance)
                {
                    minDistance = mapWithAllNodes.get(mapWithAllNodes.keySet().toArray()[i]).getTemporaryDistance();
                    minNode = (String)mapWithAllNodes.keySet().toArray()[i];
                }
            }
        }
        return minNode;
    }


    /**
     * Return the property if the node is visited or not visited
     *
     * @return Boolean true or false
     */
    public Boolean checkIfUnvisitedNodesAvaible(HashMap<String, Node> mapWithAllNodes)
    {
        for (int i = 0; i < mapWithAllNodes.size(); i++)
        {
            if(mapWithAllNodes.get(mapWithAllNodes.keySet().toArray()[i]).getVisited() == false)
            {
                return true;
            }
        }
        return false;
    }
}

