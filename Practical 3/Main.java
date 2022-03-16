public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        tree.insert(73);
        tree.insert(11);
        tree.insert(95);
        tree.insert(7);
        tree.insert(32);
        tree.insert(60);
        tree.insert(72);
        tree.insert(82);
        tree.insert(87);


        // Object[] arr = new Object[tree.numNodes()];
        // arr = tree.nodesOnHeight(2);
        
        // if (arr != null) {
        //     for (int i = 0; i < arr.length; i++) {
        //         if (arr[i] != null) {
        //             System.out.println(((BSTNode<Integer>) arr[i]).getVal());
        //         }
        //     }
        // }
        

        System.out.println(tree.minVal());
    }
}
