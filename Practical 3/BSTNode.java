/**
 * Name: Francois Smith
 * Student Number: u19314486
 */

public class BSTNode<T extends Comparable<T>> {
    private T value;
    public BSTNode<T> right;
    public BSTNode<T> left;

    public boolean recInsert(T val){
        if(val.compareTo(value) == 0)
            return false;

        if(val.compareTo(value) < 0)
        {
            if(left == null)
            {
                left = new BSTNode<>(val);
                return true;
            } else {
                return left.recInsert(val);
            }
        } else {
            if(right == null)
            {
                right = new BSTNode<>(val);
                return true;
            } else {
                return right.recInsert(val);
            }
        }
    }

    //Implement the following

    public BSTNode(T val){
        this.value = val;
    }

    public T getVal(){
        return this.value;
    }

    public String toString(){
        String output = "";
        if (left == null)   // if !left return L[]
            output += "L[]";
        else 
            output += "L["+left.value+"]"; // else return L[left]

        output += "V["+value+"]"; // return V[value]

        if (right == null) 
            output += "R[]"; // if !right return R[]
        else    
            output += "R["+right.value+"]"; // else return R[right]

        return output;
    }

    //ADD HELPER FUNCTIONS HERE
}
