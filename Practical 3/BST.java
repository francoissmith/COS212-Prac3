/**
 * Name: Francois Smith
 * Student Number: u19314486
 */

@SuppressWarnings("unchecked")

public class BST<T extends Comparable<T>> {
protected BSTNode<T> root;
    private Object[] arr;
    private int count;
    private String result;
    
    public BST(){};

    public boolean insert(T val){
        if(root == null){
            root = new BSTNode<>(val);
            return true;
        } else {
            return root.recInsert(val);
        }
    }

    //Place code below
// *************************************************************************** numNodes()
    public int numNodes(){
        if (root == null) 
            return 0;
        else 
            return countNodes(root);
    }
// *************************************************************************** toArray()
    public Object[] toArray(){
        if (root == null)
            return null;
        else {
            arr = new Object[numNodes()];
            count = 0;
            inorderArr(root);

            return arr;
        }
    }
// *************************************************************************** contains()
    public boolean contains(T val){
        BSTNode<T> node = root;
        while (node != null) {
            if (val.equals(node.getVal())) {
                return true;
            }
            else if (val.compareTo(node.getVal()) < 0)
                node = node.left;
            else node = node.right;
        }

        return false;
    }
// *************************************************************************** isEmpty()
    public boolean isEmpty(){
        if (root == null)
            return true;

            return false;
    }
// *************************************************************************** find(val)
    public BSTNode<T> find(T val){
        BSTNode<T> node = root;

        while (node != null) {
            if (val.equals(node.getVal())) {
                return node;
            }
            else if (val.compareTo(node.getVal()) < 0) {
                node = node.left;
            }
            else node = node.right;
        }

        return null;
    }
// *************************************************************************** height()
    public int height(){
        if (root == null) {
            return -1;
        }
        else return getHeight(root)-1;
    }
// *************************************************************************** nodesOnHeight(h)
    public Object[] nodesOnHeight(int h){
        if (h < 0 || root == null || h > height()) {
            return null;
        }
        else {
            arr = new Object[numNodes()];
            count = 0;
            goToLevel(root, h, 0);

            return arr;
        }
    }
// *************************************************************************** DFT()
    public String DFT(){
        result = "";
        if (root == null) {
            return "";
        }
        else {
            inorderStr(root);
        }

        return result.substring(0, result.length()-1);
    }
// *************************************************************************** BFT()
    public String BFT(){
        result = "";      
        arr = new Object[numNodes()];
        count = 0;
        int head = 0;
        BSTNode<T> p = root;
        if (root == null)  return "";
        else{
            toArray(p);
            while (head != numNodes()) {
                p = (BSTNode<T>)arr[head++];
                result += p.toString()+";";
                if (p.left != null) 
                    toArray(p.left);
                if (p.right != null) {
                    toArray(p.right);
                }
            }
        }

        return result.substring(0, result.length()-1);
    }
// *************************************************************************** maxVal()
    public T maxVal(){
        if (root == null) {
            return null;
        }
        else {
            int n = numNodes();
            Object[] nodeList = new Object[n];
            nodeList = toArray();
            BSTNode<T> node = (BSTNode<T>)nodeList[n-1];
            return node.getVal();
        }
    }
// *************************************************************************** minVal()
    public T minVal(){
        if (root == null) {
            return null;
        }
        else {
            Object[] nodeList = new Object[numNodes()];
            nodeList = toArray();
            BSTNode<T> node = (BSTNode<T>)nodeList[0];
            return node.getVal();
        }
    }
// ********************************************************************************************************* HELPER FUNCTIONS
    //ADD HELPER FUNCTIONS HERE
// *************************************************************************** countNodes()
    private int countNodes(BSTNode<T> node) {
        int left = 0, right = 0;

        if (node.left != null)
            left += countNodes(node.left);
        
        if (node.right != null)
            right += countNodes(node.right);

        if (node.left == null && node.right == null) 
            return 1;

        return left + right + 1;
    }
// *************************************************************************** toArray(node)
    private void toArray(BSTNode<T> node) {
        if (count == numNodes()) {
            return;
        }
        else{
            arr[count++] = node;
        }
    }
// *************************************************************************** inorderArr(node)
    protected void inorderArr(BSTNode<T> node) {
        if (node != null) {
            inorderArr(node.left);
            toArray(node);
            inorderArr(node.right);
        }
    }
// *************************************************************************** inorderStr(node)
    protected void inorderStr(BSTNode<T> node) {
        if (node != null) {
            inorderStr(node.left);
            result += node.toString()+";";
            inorderStr(node.right);
        }
    }
// *************************************************************************** getHeight(node)
    private int getHeight(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }
        else {
            int left = getHeight(node.left);
            int right = getHeight(node.right);
            if (left > right)
                return left+1;
            else return right +1;
        }
    }
// *************************************************************************** goToLevel(node, h, lvl)
    private void goToLevel(BSTNode<T>node, int h, int level) {

       if (h == 0) {
           toArray(root);
       }
       else{
           if (level == h-1) {
               if (node.left != null)
                   toArray(node.left);
   
               if (node.right != null)
                   toArray(node.right);
           }
           else{
               if (node.left != null) 
                   goToLevel(node.left, h, level+1);
               
               if (node.right != null)
                   goToLevel(node.right, h, level+1);
           }
       }
    }
}
