package DjikstraAlg;

import java.util.ArrayList;
import java.util.HashMap;

public class Djikstra {
    HashMap<String, Node> unvisitedNodeList;
    Network network;
    String currentNode;
    String startpoint;
    String endpoint;


    public Djikstra() {
        network = new Network();
        unvisitedNodeList = new HashMap<>(network.getNodeList());
    }

    public void getDirection(String startpoint, String viapoint, String endpoint)
    {
        getDirection(startpoint, viapoint);
        System.out.println("Via position:");
        getDirection(viapoint, endpoint);
    }

    public void getDirection(String startpoint, String endpoint)
    {
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
            unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i])
                    .setTempDist(actNeighboursAndDistance.get(actNeighboursAndDistance.keySet().toArray()[i]));

            /* set on the neigbours the predecessorNode (startpoint) */
            unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(startpoint);
        }

        /* Set on the startpoint the tempDistance to 0(zero) and visited as true */
        unvisitedNodeList.get(startpoint).setTempDist(0);
        unvisitedNodeList.get(startpoint).setVisited(true);

        /* choose the shortest or longest way */
        /* actually only the shortestDistance possible */
        calculateShortestDistance();
    }


    private void calculateShortestDistance() {
        HashMap<String, Integer> actNeighboursAndDistance = new HashMap<>();
        int currentDistance = 0;

        while (network.checkUnvisitedNode() == true)
        {
            currentNode = network.getShortestDistance();
            if (currentNode == "null") {
                System.out.println("Callculated done.");
                printShortestDistnace();
                return;
            }

            /* Store the actual Distance */
            currentDistance = unvisitedNodeList.get(currentNode).getTempDist();

            /* Search the neighbours form the currentNode */
            actNeighboursAndDistance = network.getNeighboursAndDistance(currentNode);

            /* Write the new calculated tempDistance for all Neighbours from the currentNode*/
            for (int i = 0; i < actNeighboursAndDistance.size(); i++) {
                /* Until jet, no way to this node found */
                if (unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).getTempDist() == -1) {
                    unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i])
                            .setTempDist(currentDistance + actNeighboursAndDistance.get(actNeighboursAndDistance.keySet().toArray()[i]));
                    unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(currentNode);
                }
                /* Read and store the distance, including the tempDistance form the predecessor node */
                /* Whe the distance is lower as the the stored distance, write the new distance with the new predecessorNode. --> Shorter distance found! */
                else if (unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).getTempDist() >
                        (currentDistance + unvisitedNodeList.get(currentNode).getTempDist())) {
                    unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i])
                            .addTempDist(actNeighboursAndDistance.get(actNeighboursAndDistance.keySet().toArray()[i]));
                    unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(currentNode);
                }
            }

            /* Set on the startpoint the tempDistance to 0(zero) and visited as true */
            unvisitedNodeList.get(currentNode).setVisited(true);
//            System.out.println("Nodes: " + currentNode + " Neighbour: " + unvisitedNodeList.get(currentNode).getPredecessorNode());
        }

//        System.out.println("Callculated done.");
        printShortestDistnace();
    }

    private void printShortestDistnace() {
        ArrayList<String> waypoints = new ArrayList<>();
        String actWaypoint = "";

        waypoints.add(endpoint);
        actWaypoint = endpoint;

        while(startpoint.equals(actWaypoint) == false) {
            actWaypoint = unvisitedNodeList.get(actWaypoint).getPredecessorNode();
            waypoints.add(actWaypoint);
        }

        System.out.println("The shortest way from " + startpoint + " to " + endpoint + " is:");
        for (int i = waypoints.size()-1; i >= 0; i--)
        {
            System.out.println(waypoints.get(i));
        }
    }
}