public class CharacterSearchTree {

    // --- hier ergaenzen ---
    public int apply() {
        int res = 0;

        if (!isEmpty()) {

            if (content.getQuantity() < 3) {
                res = content.getQuantity();
            }

            if (!leftChild.isEmpty() && rightChild.isEmpty()) {
                return res + leftChild.apply();
            } else if (leftChild.isEmpty() && !rightChild.isEmpty()) {
                return res + rightChild.apply();
            } else {
                return leftChild.apply() + rightChild.apply();
            }
        } else {
            return 0;
        }

    }

    // --- Vorgaben ---

    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public HuffmanTriple getContent() {
        if (!isEmpty()) {
            return content;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty() {
        return content == null;
    }

    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void iterativeAdd(char t) {
        CharacterSearchTree current = this;
        while (!current.isEmpty() && current.content.getToken() != t) {
            if (current.content.getToken() > t) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if (current.isEmpty()) {
            current.content = new HuffmanTriple(t);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        } else {
            current.content.incrementQuantity();
        }
    }

    public void show() {
        if (!isEmpty()) {
            leftChild.show();
            System.out.println(content.toString());
            rightChild.show();
        }
    }

}
