public class Node {

    private int value;
    private Node left;
    private Node right;
    private int height;

    public Node(int value){
        this.value = value;
        right = null;
        left = null;
        height = 1;
    }
    public void printNode(){
        System.out.println("int: " + this.value);
    }

    public int getValue(){
        return this.value;
    }

    public  void setValue(final int newValue){
        this.value = newValue;
    }

    public Node getLeftList() {
        return this.left;
    }

    public void setLeftList(Node newLeft) {
        this.left = newLeft;
    }

    public Node getRightList() {
        return this.right;
    }

    public void setRightList(final Node newRight) {
        this.right = newRight;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int newHeight) {
        this.height = newHeight;
    }

    public String info(){
        return String.format("Node :\n\tvalue : %s\n\theight : %s\n\tleftChild : %s\n\trightChild : %s\n",
                value,
                height,
                left != null ?  Integer.toString( left.getValue() ) : "*",
                right != null ?  Integer.toString( right.getValue() ) : "*");
    }

}
