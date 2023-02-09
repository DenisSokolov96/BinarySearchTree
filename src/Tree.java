import static java.lang.Math.max;

public class Tree {
    private Node rootNode;
    public Tree() {
        this.rootNode = null;
    }

    //Вставка нового узла в дерево
    public void insertNode(int value){
        this.rootNode = pushNode(this.rootNode, value);
    }

    private Node pushNode(Node node, int value){
        if (node == null){
            return new Node(value);
        }

        if (value > node.getValue()) {
            node.setRightList(pushNode(node.getRightList(), value));
        } else  if (value < node.getValue())  {
            node.setLeftList(pushNode(node.getLeftList(), value));
        } else {
            return node;
        }

        return node;
    }

    //Вывод данных по узлам
    public void printTreeByNodes(){
        print(this.rootNode);
    }
    private void print(Node node){
        if ( node == null) return;
        print(node.getLeftList());
        System.out.println(node.info());
        print(node.getRightList());
    }

    //Вывод дерева
    public void printTree(){
        printTreeValues(this.rootNode, 0);
    }
    private void printTreeValues(Node node, int u){
        if ( node == null) {
            for (int i=0; i< u; ++i) System.out.print("\t");
            System.out.println("*");
            return;
        }
        u++;
        printTreeValues(node.getRightList(), u);
        for (int i=0; i< u-1; ++i) System.out.print("\t");
        System.out.println(node.getValue());
        printTreeValues(node.getLeftList(), u);
    }

    //Высота дерева
    public int getHeightTree(){
        return heightTree(this.rootNode);
    }

    private int heightTree(Node node) {
        if (node == null) return 0;
        else {
            int h1 = heightTree(node.getLeftList());
            int h2 = heightTree(node.getRightList());
            return max(h1, h2) + 1;
        }
    }

    //Подсчет кол-ва узлов
    public int getCountNodes(){
        return countNodes(this.rootNode, 0);
    }
    private int countNodes(Node node,int count) {
        if ( node == null) return count;
        count++;
        count = countNodes(node.getLeftList(), count);
        count = countNodes(node.getRightList(), count);
        return count;
    }

    //Удаление элемента
    public boolean deleteItemByValue(int value){
        if (this.rootNode == null) return false;
        int countValOld = this.getCountNodes();
        this.rootNode = this.deleteNode(this.rootNode, value);

        return countValOld > this.getCountNodes();
    }

    private Node deleteNode(Node findNode, int value){
        if (findNode == null) return null;
        if (findNode.getValue() == value) {
            if (findNode.getLeftList() == null && findNode.getRightList() == null) return null;
            if (findNode.getLeftList() == null) return findNode.getRightList();
            if (findNode.getRightList() == null) return findNode.getLeftList();

            // если у ноды есть оба потомка
            Node minNodeInRightSubtree = this.findMinElement(findNode.getRightList());
            // заменили текущий элемент минимальным из правого поддерева
            findNode.setValue( minNodeInRightSubtree.getValue());
            // ищем в правом поддереве минимальный элемент,
            // значение которого уже вставлено на место текущего
            findNode.setRightList( this.deleteNode(findNode.getRightList(), minNodeInRightSubtree.getValue()) );
            return findNode;
        }

        // если элемент не будет найден, то просто будет возвращать существующую ссылку на поддерево,
        // которая присвоится в ту же позицию
        if (value < findNode.getValue()) {
            if (findNode.getLeftList() == null) {
                //System.out.println("Элемент не найден.");
                return findNode;
            }

            findNode.setLeftList(this.deleteNode(findNode.getLeftList(), value));
            return findNode;
        }

        if (value > findNode.getValue()) {
            if (findNode.getRightList() == null) {
                //System.out.println("Элемент не найден.");
                return findNode;
            }

            findNode.setRightList(this.deleteNode(findNode.getRightList(), value));
            return findNode;
        }
        return findNode;
    }

    //Поиск элемента
    public Node findElemByValue(int value){
        return this.findNodeByValue(this.rootNode, value);
    }

    private Node findNodeByValue(Node node, int value){ // поиск узла с минимальным ключом в дереве p
        if (node == null) return null;
        if (value > node.getValue())
            return node.getRightList()!=null ? findNodeByValue(node.getRightList(), value) : null;
        if (value < node.getValue())
            return node.getLeftList()!=null ? findNodeByValue(node.getLeftList(), value) : null;

        return node;
    }

    public Node getFindMinElement(){
        return this.findMinElement(this.rootNode);
    }
    private Node findMinElement(Node node) {
        if (node == null) return null;
        if (node.getLeftList() == null) return node;
        return this.findMinElement(node.getLeftList());
    }


/*
    //Повороты дерева
    private Node rotateRight(Node node){ // правый поворот вокруг p
        Node nodeTemp = node.getLeftList();
        node.setLeftList(nodeTemp.getRightList());
        nodeTemp.setRightList(node);
        fixHeight(node);
        fixHeight(nodeTemp);
        return nodeTemp;
    }

    private Node rotateLeft(Node node){ // левый поворот вокруг q
        Node nodeTemp = node.getRightList();
        node.setRightList(nodeTemp.getLeftList());
        nodeTemp.setLeftList(node);
        fixHeight(node);
        fixHeight(nodeTemp);
        return node;
    }

    //выполнение балансировки
    public Node balance(Node node){ // балансировка узла p
        fixHeight(node);
        if( bfactor(node)==2 )
        {
            if( bfactor(node.getRightList()) < 0 )
                node.setRightList( rotateRight(node.getRightList()) );
            return rotateLeft(node);
        }
        if( bfactor(node)==-2 )
        {
            if( bfactor(node.getLeftList()) > 0  )
                node.setLeftList(rotateLeft(node.getLeftList()));
            return rotateRight(node);
        }
        return node; // балансировка не нужна
    }

     //Работа с узлами
    private int height(Node node){
        return node!=null ? node.getHeight():0;
    }

    private int bfactor(Node node){
        return height(node.getRightList())-height(node.getLeftList());
    }

    private void fixHeight(Node node){
        int hl = height(node.getLeftList());
        int hr = height(node.getRightList());
        node.setHeight( hl>hr ? hl + 1 : hr + 1 );
    }
*/

}
