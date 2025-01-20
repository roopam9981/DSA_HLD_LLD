package DataStructure.Tree;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.plaf.ButtonUI;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class BinaryTree {

    // create a Node ================================================
    static class Node{
        int data ;
        Node left;
        Node right ;

        Node (int data){
            this.data = data;
            this.left =  null;
            this.right = null;
        }
    }

    // Create a Binary Tree ================================================

    static class Bt{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // ====================Traverse The Tree =============================================
    //  ===================       DFS     ================================================
    public static void Preorder (Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void inorder (Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //  ===================       BFS     =============================================
    public static void levelorder( Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currentNode.data + " ");
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
        }
    }

    //============================ Count Nodes ====================

    public static int countOfNodes(Node root){
        if (root == null){
            return 0;
        }
        int lftNodes = countOfNodes(root.left);
        int ritNodes = countOfNodes(root.right);
        return lftNodes + ritNodes + 1;
    }

    //======================== Sum of node ========================

    public static int  sumofNode(Node root){
        if (root == null){
            return 0;
        }
        int lftNode  = sumofNode(root.left);
        int ritNode  = sumofNode(root.right);
        return  lftNode + ritNode + root.data;
    }

    // ==================== Height of tree ========================

    public static int HightOfTree( Node root){
        if (root == null){
            return 0;
        }
        int lftHight = HightOfTree(root.left);
        int ritHight = HightOfTree(root.right);
        int myHight = Math.max(lftHight , ritHight) + 1;

        return myHight;

    }

    // ==================== Diameter of tree ========================
    // APPROACH 1 :  0(N^2)

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = HightOfTree(root.left) +  HightOfTree(root.right) + 1;
        return Math.max(diam3,Math.max(diam1,diam2));
    }

    // APPROACH 2 : 0(N)


    public static void main (String[] args){
        int nodes[] =  {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Bt tree = new Bt();
        Node root = tree.buildTree(nodes);
        assert root != null;
       // System.out.println(root.data);
        Preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelorder(root);
        System.out.println(countOfNodes(root));

        System.out.println(sumofNode(root));

        System.out.println(HightOfTree(root));

        System.out.println(diameter(root));



    }

}
