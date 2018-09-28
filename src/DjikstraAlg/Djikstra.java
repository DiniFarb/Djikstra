package DjikstraAlg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * Class Djikstra: Create a new object from Djikstra
 * class Djikstra calculate form two or more points the shortest Distance
 *
 * @version 1.0
 * @autor   Andreas and Patrick
 * @date    21.09.2018
 */
public class Djikstra
{
    private HashMap<String, Node> mapWithAllNodes;
    private Network network;
    private String currentNode;
    private String startpoint;
    private String endpoint;


    /**
     * Constructure: Create a new object from network
     *
     */
    public Djikstra()
    {
        network = new Network();
    }


    /**
     * Give the shortest distance from two points including a via point (startpoint, viapoint, endpoint)
     *
     */
    public void getDirection(String startpoint, String viapoint, String endpoint)
    {
        int distanceStartToVia, distanceViaToEnd;
        System.out.println("New way from " + startpoint + " to " + endpoint + " via " + viapoint);
        getDirection(startpoint, viapoint);
        distanceStartToVia = mapWithAllNodes.get(viapoint).getTemporaryDistance();
        System.out.println("Via position: " + viapoint);
        getDirection(viapoint, endpoint);
        distanceViaToEnd = mapWithAllNodes.get(endpoint).getTemporaryDistance();
        System.out.println("Total distance: " + (distanceStartToVia + distanceViaToEnd));
    }


    /**
     * Give the shortest distance from two points (startpoint, endpoint)
     *
     */
    public void getDirection(String startpoint, String endpoint)
    {
        mapWithAllNodes = new HashMap<>(network.createNodes());
        HashMap<String, Integer> actNeighboursAndDistance = new HashMap<>();

        /* Store start and endpoint */
        this.startpoint = this.currentNode = startpoint;
        this.endpoint = endpoint;

        /* Returns all neighbours from the startpoint  */
        actNeighboursAndDistance = network.getNeighboursAndDistance(startpoint);

        /* Write the first tempDistance for all Neighbours from the startpoint*/
        for (int i = 0; i < actNeighboursAndDistance.size(); i++) {
            /* Read and store the distance from startpoint to the neigbours */
            /* The neighbour and distance is stored into the HashMap "actNeighboursAnddistance */
            mapWithAllNodes.get(actNeighboursAndDistance.keySet().toArray()[i])
                    .setTempDist(actNeighboursAndDistance.get(actNeighboursAndDistance.keySet().toArray()[i]));

            /* set on the neigbours the predecessorNode (startpoint) */
            mapWithAllNodes.get(actNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(startpoint);
        }

        /* Set on the startpoint the tempDistance to 0(zero) and visited as true */
        mapWithAllNodes.get(startpoint).setTempDist(0);
        mapWithAllNodes.get(startpoint).setVisited(true);

        /* choose the shortest or longest way */
        /* actually only the shortestDistance possible */
        calculateShortestDistance();
    }


    /**
     * Search the shortest distance form node to node and store the calculated sum of all distance per node.
     * When all neighbours from a node as calculated, set this node as visited.
     *
     */
    private void calculateShortestDistance()
    {
        HashMap<String, Integer> actuelNeighboursAndDistance = new HashMap<>();
        int currentDistance = 0;

        while (network.checkIfUnvisitedNodesAvaible(mapWithAllNodes) == true)
        {
            currentNode = network.getNodeWithActualShortestDistance(mapWithAllNodes);

            /* Store the actual Distance */
            currentDistance = mapWithAllNodes.get(currentNode).getTemporaryDistance();

            /* Search the neighbours form the currentNode and store it with the node-to-node distance */
            actuelNeighboursAndDistance = network.getNeighboursAndDistance(currentNode);

            /* Write the new calculated tempDistance for all Neighbours from the currentNode*/
            for (int i = 0; i < actuelNeighboursAndDistance.size(); i++) {
                /* Until jet, no way to this node found */
                if (mapWithAllNodes.get(actuelNeighboursAndDistance.keySet().toArray()[i]).getTemporaryDistance() == Integer.MAX_VALUE) {
                    mapWithAllNodes.get(actuelNeighboursAndDistance.keySet().toArray()[i])
                            .setTempDist(currentDistance + actuelNeighboursAndDistance.get(actuelNeighboursAndDistance.keySet().toArray()[i]));
                    mapWithAllNodes.get(actuelNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(currentNode);
                }
                /* Read and store the distance, including the tempDistance form the predecessor node */
                /* Whe the distance is lower as the the stored distance, write the new distance with the new predecessorNode. --> Shorter distance found! */
                else if (mapWithAllNodes.get(actuelNeighboursAndDistance.keySet().toArray()[i]).getTemporaryDistance() >
                        (currentDistance + mapWithAllNodes.get(currentNode).getTemporaryDistance())) {
                    mapWithAllNodes.get(actuelNeighboursAndDistance.keySet().toArray()[i])
                            .addTempDist(actuelNeighboursAndDistance.get(actuelNeighboursAndDistance.keySet().toArray()[i]));
                    mapWithAllNodes.get(actuelNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(currentNode);
                }
            }

            /* Set on the startpoint the tempDistance to 0(zero) and visited as true */
            mapWithAllNodes.get(currentNode).setVisited(true);
        }

        printShortestDistnace();
    }


    /**
     * Give the shortest distance from the searched way on the console out.
     *
     */
    private void printShortestDistnace()
    {
        LinkedList<String> waypoints = new LinkedList<>();
        String actualWaypoints = "";

        waypoints.add(0,endpoint);
        actualWaypoints = endpoint;

        while(startpoint.equals(actualWaypoints) == false)
        {
            actualWaypoints = mapWithAllNodes.get(actualWaypoints).getPredecessorNode();
            waypoints.add(0,actualWaypoints);
        }

        System.out.println("The shortest way from " + startpoint + " to " + endpoint + " is:");
        for (int i = 0; i < waypoints.size(); i++)
        {
            System.out.println(waypoints.get(i));
        }
        System.out.println("Distance: " + mapWithAllNodes.get(endpoint).getTemporaryDistance());
    }
}