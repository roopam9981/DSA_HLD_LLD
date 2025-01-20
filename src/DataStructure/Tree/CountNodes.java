package DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {

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

    static class Bt{
        static int idx = -1;
        public static BinaryTree.Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            BinaryTree.Node newNode = new BinaryTree.Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void Preorder (BinaryTree.Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void inorder (BinaryTree.Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(BinaryTree.Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelorder(BinaryTree.Node root){
        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            BinaryTree.Node currentNode = q.remove();
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


    public static void main (String[] args){
        int nodes[] =  {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree.Bt tree = new BinaryTree.Bt();
        BinaryTree.Node root = tree.buildTree(nodes);
        assert root != null;
        // System.out.println(root.data);
        Preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        levelorder(root);

    }

}

