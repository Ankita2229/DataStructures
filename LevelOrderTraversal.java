import java.util.*;
public class LevelOrderTraversal {
// public class Node {
//   int val;
//   Node left;
//   Node right;
//   Node() {}
//   Node(int val) { this.val = val; }
//   Node(int val, Node left, Node right) {
//     this.val = val;
//     this.left = left;
//     this.right = right;
//   }
// }

    public List<List<Integer>> level_order_traversal(Node root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<Node> nodeToVisit = new LinkedList<>();
        nodeToVisit.add(root);
        int level=0;
        while(!nodeToVisit.isEmpty()){
            answer.add(new ArrayList<>());
            int level_length = nodeToVisit.size();

            for(int i=0; i< level_length; i++){
                Node node = nodeToVisit.remove();
                answer.get(level).add(node.val);
                if(node.left != null) nodeToVisit.add(node.left);
                if(node.right != null) nodeToVisit.add(node.right);
            }
            level++;
        }
        return answer;
    }

    static Node root;
    public static void main(String[] args){
        LevelOrderTraversal l = new LevelOrderTraversal();

        //read from input!!
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        ArrayList<Node> n = new ArrayList<>();
        for (Integer integer : arr) {
            // System.out.println(arr.get(i));
            if (integer != null) {
                Node t = new Node(integer);
                n.add(t);
            } else {
                n.add(null);
            }
        }
        root = l.insertLevelOrder(n, l.root, 0);
        System.out.println(l.level_order_traversal(root));
    }

    public Node insertLevelOrder(ArrayList<Node> n, Node root, int i) {
        // Base case for recursion
        if (i < n.size()) {
            root = n.get(i);
            if(n.get(i) != null){
                // insert left child
                root.left = insertLevelOrder(n, root.left, 2 * i + 1);
                // insert right child
                root.right = insertLevelOrder(n, root.right, 2 * i + 2);
            }
            // else{ n.add(null);}
        }
        return root;
    }
}

