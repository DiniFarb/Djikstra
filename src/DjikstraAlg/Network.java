package DjikstraAlg;

import java.util.ArrayList;
import java.util.HashMap;

public class Network extends Node
{
    private HashMap<String, Node> nodeList = new HashMap<>();
    private HashMap<String, Node> nodeListTest = new HashMap<>();

    private String[][] mainList = {
            {"A","B","6"},
            {"A","D","7"},
            {"B","E","4"},
            {"B","C","4"},
            {"C","F","6"},
            {"C","I","8"},
            {"D","G","5"},
            {"E","J","5"},
            {"F","K","5"},
            {"G","I","7"},
            {"G","H","5"},
            {"H","L","5"},
            {"I","M","5"},
            {"J","K","7"},
            {"J","T","4"},
            {"K","U","9"},
            {"L","M","6"},
            {"M","N","5"},
            {"N","O","7"},
            {"Q","P","8"},
            {"Q","X","7"},
            {"R","Z","4"},
            {"R","Y","10"},
            {"S","W","2"},
            {"T","V","7"},
            {"T","R","8"},
            {"U","P","2"},
            {"W","Y","9"},
            {"X","Y","11"}};

    public Network()
    {
        createNode();
    }

    private void createNode()
    {
        /***************************************************************************************
         *
         *
         *
         *
         */
        /* Temprary ArrayList for create a table from all nodes without duplicates */
        ArrayList<String> nodeNames = new ArrayList<>();
        for(int i = 0; i < mainList.length; i++)
        {
            /* Eliminate duplicate nodes */
            /* and create for evry node a new object */
            /* store the node-objecst into a HashMap */
            if(nodeNames.indexOf(mainList[i][0]) == -1)
            {
                nodeNames.add(mainList[i][0]);
                nodeListTest.put(mainList[i][0], new Node());
            }
        }
        /***************************************************************************************
         *
         *
         *
         *
         */



        Node A = new Node(); nodeList.put("A",A);
        Node B = new Node(); nodeList.put("B",B);
        Node C = new Node(); nodeList.put("C",C);
        Node D = new Node(); nodeList.put("D",D);
        Node E = new Node(); nodeList.put("E",E);
        Node F = new Node(); nodeList.put("F",F);
        Node G = new Node(); nodeList.put("G",G);
        Node H = new Node(); nodeList.put("H",H);
        Node I = new Node(); nodeList.put("I",I);
        Node J = new Node(); nodeList.put("J",J);
        Node K = new Node(); nodeList.put("K",K);
        Node L = new Node(); nodeList.put("L",L);
        Node M = new Node(); nodeList.put("M",M);
        Node N = new Node(); nodeList.put("N",N);
        Node O = new Node(); nodeList.put("O",O);
        Node P = new Node(); nodeList.put("P",P);
        Node Q = new Node(); nodeList.put("Q",Q);
        Node R = new Node(); nodeList.put("R",R);
        Node S = new Node(); nodeList.put("S",S);
        Node T = new Node(); nodeList.put("T",T);
        Node U = new Node(); nodeList.put("U",U);
        Node V = new Node(); nodeList.put("V",V);
        Node W = new Node(); nodeList.put("W",W);
        Node X = new Node(); nodeList.put("X",X);
        Node Y = new Node(); nodeList.put("Y",Y);
        Node Z = new Node(); nodeList.put("Z",Z);
    }


    public HashMap<String, Node> getNodeList()
    {
        return this.nodeList;
    }


    public HashMap<String, String> getNeighboursAndDistance(String node)
    {
        HashMap<String, String> neighbourAndDistanceMap = new HashMap<>();

        for (int i = 0; i < mainList.length; i++)
        {
            if(node.indexOf(mainList[i][0]) != -1)
            {
                neighbourAndDistanceMap.put(mainList[i][1], mainList[i][2]);
            }
        }
        return neighbourAndDistanceMap;
    }

    public String getShortestDistance()
    {
        int minDistance = -1;
        String minNode = "null";

        for (int i = 0; i < nodeList.size(); i++)
        {
            /* Calculate from the unvisited and distance not -1 nodes the shortest distance to the predecessorNode */
            if((nodeList.get(nodeList.keySet().toArray()[i]).getTempDist() != -1) && (nodeList.get(nodeList.keySet().toArray()[i]).getVisited() == false))
            {
                if((((nodeList.get(nodeList.keySet().toArray()[i]).getTempDist() < minDistance) && (nodeList.get(nodeList.keySet().toArray()[i]).getTempDist() >= 0))) || (minDistance == -1))
                {
                    minDistance = nodeList.get(nodeList.keySet().toArray()[i]).getTempDist();
                    minNode = (String)nodeList.keySet().toArray()[i];
                }
            }
        }
        return minNode;
    }

    public Boolean checkUnvisitedNode()
    {
        for (int i = 0; i < nodeList.size(); i++)
        {
            if(nodeList.get(nodeList.keySet().toArray()[i]).getVisited() == false)
            {
                System.out.println("Visited Node: " + nodeList.keySet().toArray()[i]);
                return true;
            }
        }
        return false;
    }
}

