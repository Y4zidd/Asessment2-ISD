public class Node {
    private int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public int getData() {
        return data;
    }

}

class VirusTree {
    Node root;

    public VirusTree() {
        root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(12);
    }

    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(Node node) {
        if (node == null) {
            return;
        }

        System.out.printf("%s ", node.getData());// output node data
        preorderHelper(node.left); // traverse left subtree
        preorderHelper(node.right); // traverse right subtree
    }

    public boolean checkBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.getData() <= min || node.getData() >= max) {
            return false;
        }

        return isBST(node.left, min, node.getData()) && 
               isBST(node.right, node.getData(), max);
    }

    public void deleteBST() {
        if (checkBST()) {
            root = null;
            System.out.println("BST telah dihapus.");
        } else {
            System.out.println("Pohon ini bukan BST, penghapusan dilewati.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        VirusTree tree = new VirusTree();
        tree.preorderTraversal();// pre-order untuk mengecek bentuk pohon
        System.out.println(tree.checkBST());// hasil true atau false
        tree.deleteBST(); // Memanggil metode untuk menghapus BST jika itu adalah BST
        tree.preorderTraversal(); // Mengecek apakah pohon telah dihapus
    }
}