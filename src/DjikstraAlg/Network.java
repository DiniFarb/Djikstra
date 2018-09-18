package DjikstraAlg;

import java.util.ArrayList;

public class Network
{
    private ArrayList<Node> nodeList = new ArrayList<>();

    private int[][] mainList = {
            {(int)'A',(int)'B',6}, 
            {(int)'A',(int)'D',7},
            {(int)'B',(int)'E',4},
            {(int)'B',(int)'C',4},
            {(int)'C',(int)'F',6},
            {(int)'C',(int)'I',8},
            {(int)'D',(int)'G',5},
            {(int)'E',(int)'J',5},
            {(int)'F',(int)'K',5},
            {(int)'G',(int)'I',7},
            {(int)'G',(int)'H',5},
            {(int)'H',(int)'L',5},
            {(int)'I',(int)'M',5},
            {(int)'J',(int)'K',7},
            {(int)'J',(int)'T',4},
            {(int)'K',(int)'U',9},
            {(int)'L',(int)'M',6},
            {(int)'M',(int)'N',5},
            {(int)'N',(int)'O',7},
            {(int)'Q',(int)'P',8},
            {(int)'Q',(int)'X',7},
            {(int)'R',(int)'Z',4},
            {(int)'R',(int)'Y',10},
            {(int)'S',(int)'W',2},
            {(int)'T',(int)'V',7},
            {(int)'T',(int)'R',8},
            {(int)'U',(int)'P',2},
            {(int)'W',(int)'Y',9},
            {(int)'X',(int)'Y',11},
            {(int)'Y',(int)'Y',10},
            {(int)'A',(int)'B',6},
            {(int)'A',(int)'D',7},
            {(int)'B',(int)'E',4},
            {(int)'B',(int)'C',4},
            {(int)'C',(int)'F',6},
            {(int)'C',(int)'I',8},
            {(int)'D',(int)'G',5},
            {(int)'E',(int)'J',5},
            {(int)'F',(int)'K',5},
            {(int)'G',(int)'I',7},
            {(int)'G',(int)'H',5},
            {(int)'H',(int)'L',5},
            {(int)'I',(int)'M',5},
            {(int)'J',(int)'K',7},
            {(int)'J',(int)'T',4},
            {(int)'K',(int)'U',9},
            {(int)'L',(int)'M',6},
            {(int)'M',(int)'N',5},
            {(int)'N',(int)'O',7},
            {(int)'Q',(int)'P',8},
            {(int)'Q',(int)'X',7},
            {(int)'R',(int)'Z',4},
            {(int)'R',(int)'Y',10},
            {(int)'S',(int)'W',2},
            {(int)'T',(int)'V',7},
            {(int)'T',(int)'R',8},
            {(int)'U',(int)'P',2},
            {(int)'W',(int)'Y',9},
            {(int)'X',(int)'Y',11},
            {(int)'Y',(int)'Y',10}};

    public Network()
    {
        createNode();
    }

    private void createNode()
    {
        Node A = new Node();
        Node B = new Node();
        Node C = new Node();
        Node D = new Node();
        Node E = new Node();
        Node F = new Node();
        Node G = new Node();
        Node H = new Node();
        Node I = new Node();
        Node J = new Node();
        Node K = new Node();
        Node L = new Node();
        Node M = new Node();
        Node N = new Node();
        Node O = new Node();
        Node P = new Node();
        Node Q = new Node();
        Node R = new Node();
        Node S = new Node();
        Node T = new Node();
        Node U = new Node();
        Node V = new Node();
        Node W = new Node();
        Node X = new Node();
        Node Y = new Node();
        Node Z = new Node();

    }

    public ArrayList<Node> getNodeList()
    {
        return this.nodeList;
    }

    public ArrayList<Node> getNeighboursAndDistance(Node node)
    {
        ArrayList<Node> neighbourList = new ArrayList<>();

        neighbourList.add(node);
        /* Muss noch geaendert werden */
        return neighbourList;
    }


    public Node getShortestNode(Node startpoint)
    {

        return startpoint;
    }


    public int getDistance(Node startpoint, Node endpoint)
    {

        return 0;
    }

}
