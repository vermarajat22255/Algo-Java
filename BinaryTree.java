import java.util.* ;
class Node{
    int key;
    Node left;
    Node right;
    Node parent;
    

    public Node(){}

    public Node(int key){
        this.key =key;
        right = null;
        left = null;
        parent = null;
    }

    // @Override
    // public String toString() {
    //     return "Node [key=" + key + ", left=" + left + ", right=" + right + "]";
    // }

    
}
class BinaryTree{
    Node root;

    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        int a[] = { 8, 2, 1, 7, 5, 3, 4, 6, 9, 11, 10, 12, 14, 13, 15};
        for(int i: a){
            tree.add(i);
        }
        // tree.inOrder(tree.root);
        // //IS LINE PR DHYAN DENA ... tree.maximumIt().left.parent matlb 55 k left me ja k fir 55 pe aya
        // System.out.println("Maximum Recursive-> "+tree.maximumIt().left.parent);
        // System.out.println("successor -> "+tree.successor(3));
        // System.out.println("PREEE -> "+tree.preDec(4));

        //4 Cases of deletion
        // Tree delete(root, 9)
        //tree.deleteNode(9);
        // // Tree delete(root, 7)
        //tree.deleteNode(7);
        // // Tree delete(root, 11)
        //tree.deleteNode(11);
        // // Tree delete(root, 2)
        tree.deleteNode(2);        
        
        //printBST.print2D(tree.root);
        BTreePrinter.printNode(tree.root);
        //TreePrinter.print(tree.root);
    }
    public Node add(int k){
        Node n = new Node(k);
        return root = add(root,n);
    }

    // agar int value dega Node n ki jagah to parent set ni kr payga same for addIt() method
    public Node add( Node root, Node n){
        
        if(root == null) return n;
        if(n.key<root.key){
            n.parent =root;
            root.left = add(root.left,n); // har recursive call ko jhelna padega khi na khi wrna result ka kya hoga?
        }
        else{
            n.parent =root;
            root.right = add(root.right,n);
        }
        return root;          // ye result ultimately jayga upar add() jha se call hue h wha...akhri me soch tu
        // jab sare recursion khtm ho jyga to root return hoga...matlb pura Tree jana chahiye yha se..
        //pure Tree k left right me hi ungli kari h apne ne.....akhri me add() ko tree root fekega isliy usko root me update marna pa
        //padega wrna pehle wala root me to added element tha hi ni to upr wale add(int k) ko apn ye feka hua set krwayge 
    }
    public Node addIt(int n){
        return root = addIt(root,new Node(n));
    }
    public Node addIt( Node root, Node n){
        
        if(root == null) return n;

        Node nc = root;
        while(root != null){
        if(n.key < root.key){
            n.parent = root;
            root = root.left;
        }else{
            n.parent = root;
            root = root.right;
        }
        }
        if(n.parent.key>n.key) n.parent.left = n;
        else n.parent.right = n;
        return nc;
    }
    public void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }
    public Node maximumIt(){return maximumIt(root);}
    public Node maximumIt(Node root){
        Node parent=root;
        int max = root.key;
        while(root!=null){
            parent = root;
            max = parent.key;
            root = root.right;
        }
        return parent;
    }

    public Node maximum(){return maximum(root);}
    public Node maximum(Node root){
        
        if(root.right!=null){
            root = maximum(root.right);
        }
        return root;
    }

    public Node minimum(){return minimum(root);}
    public Node minimum(Node root){
        if(root.left!=null){
            root = minimum(root.left);
        }
        return root;
    }

    public Node search(int n){
        return search(root, n);
    }
    public Node search(Node root, int n){
        if(root == null || root.key == n) return root;
        if(root.key > n){
            root  = search(root.left, n);
        }else{
            root = search(root.right, n); 
        }
        return root;
    }
    public Node successor(int n){
        return successor(search(n));
    }
    public Node successor(Node root){
        if(root.right!=null) return minimum(root.right);
        Node up = root.parent;
        while(up != null && up.right == root){
            root = up;
            up = up.parent;
        }
        return up;   
    }
    public Node preDec(int n){
        return PreDec(search(n));
    }
    public Node PreDec(Node root){
        if(root.left!=null) return maximum(root.left);
        Node up = root.parent;
        while(up != null && up.left == root){
            root = up;
            up = up.parent;
        }
        return up;   
    }

    //Replace the subtree rooted at U by V

    public void transPlant(Node root, Node u, Node v){
        if(u.parent == null) root=v;
        else if(u == u.parent.left) u.parent.left = v;
        else u.parent.right =v;
        if(v.parent != null) v.parent = u.parent;
    }
    public Node deleteNode(int key){
        if(search(key) == null) return null;

        return deleteNode(root, search(key));
    }
    public Node deleteNode(Node root, Node z){
        //we will have 4 different Cases to handle
        //1. Node is the only element to left or right to delete
        if(z.left == null){
            transPlant(root, z, z.right);
        }else if(z.right == null){
            transPlant(root, z, z.left);
        }
        // Z has 2 child
        // we find successor of z --Y and replace z by Y
        else{
            Node y = minimum(z.right);
            // y is in the subtree of Z but not at the root subtree
            if(y.parent != z){
                transPlant(root, y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            //Replace z by y
            transPlant(root, z, y);
            y.left = z.left;
            y.left.parent = y;
        } 
        return z;
    }
}

class printBST{
// Function to print binary tree in 2D  
// It does reverse inorder traversal  

static final int COUNT = 10;
static void print2DUtil(Node root, int space)  
{  
    // Base case  
    if (root == null)  
        return;  
  
    // Increase distance between levels  
    space += COUNT;  
  
    // Process right child first  
    print2DUtil(root.right, space);  
  
    // Print current node after space  
    // count  
    System.out.print("\n");  
    for (int i = COUNT; i < space; i++)  
        System.out.print(" ");  
    System.out.print(root.key + "\n");  
  
    // Process left child  
    print2DUtil(root.left, space);  
}  
  
// Wrapper over print2DUtil()  
static void print2D(Node root)  
{  
    // Pass initial space count as 0  
    print2DUtil(root, 0);  
}  
  
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
class TreePrinter
{
    /** Node that can be printed */
    public interface PrintableNode
    {
        /** Get left child */
        PrintableNode getLeft();


        /** Get right child */
        PrintableNode getRight();


        /** Get text to be printed */
        String getText();
    }


    /**
     * Print a tree
     * 
     * @param root
     *            tree root node
     */
    public static void print(PrintableNode root)
    {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<PrintableNode> level = new ArrayList<PrintableNode>();
        List<PrintableNode> next = new ArrayList<PrintableNode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (PrintableNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getText();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<PrintableNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}
