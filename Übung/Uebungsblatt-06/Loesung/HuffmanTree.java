public class HuffmanTree {
    private HuffmanTriple content;
    private HuffmanTree leftChild, rightChild;

    // empty tree
    public HuffmanTree() 
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    // single node tree 
    public HuffmanTree( HuffmanTriple t ) 
    {
        content = t;
        leftChild = new HuffmanTree();
        rightChild = new HuffmanTree();
    }

    // new root for multiple nodes tree 
    public HuffmanTree( HuffmanTree lc, HuffmanTree rc ) 
    {
        content = new HuffmanTriple ( ' ', lc.getContent().getQuantity() + rc.getContent().getQuantity() );
        leftChild = lc;
        rightChild = rc;
    }

    public boolean isEmpty()
    {
        return content == null;
    }

    public boolean isLeaf()
    {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public HuffmanTriple getContent() 
    {
        if ( !isEmpty() )
        {
            return content;
        } else {
            throw new IllegalStateException();
        }
    }

    public int compareTo ( HuffmanTree other ) 
    {
        if ( !isEmpty() && !other.isEmpty() )
        {
            return content.compareTo( other.content );
        } else {
            throw new IllegalStateException();
        }
    }
    
    public void generateCodes()
    {

        if ( !isEmpty() && !isLeaf() ) 
        {
            leftChild.content.setCode( content.getCode() + "0" );
            leftChild.generateCodes();
            rightChild.content.setCode( content.getCode() + "1" );
            rightChild.generateCodes();
        }

    }

    public void showCodes()
    {
        if ( !isEmpty() )
        {
            if ( isLeaf() )
            {
                System.out.println( content.toString() );
            }
            else
            {
                leftChild.showCodes();
                rightChild.showCodes();
            }
        }
    }
    
    // Loesung Aufgabe 6-3
    
    public String decode( String encoded ) 
    {
        String result = "";
        HuffmanTree current = this;
        int pos = 0;
        while ( pos < encoded.length() ) {
            current = current.leftOrRightchild( encoded.charAt(pos) );
            if ( current.isLeaf() ) 
            {
                result += current.content.getToken();
                current = this;
            }
            pos++;
        }
        if ( current != this ) 
        {
            throw new RuntimeException( "No valid coding. Expected more bits" );
        }
        return result;
    }

    private HuffmanTree leftOrRightchild( char c ) 
    {
        HuffmanTree next;
        if ( c == '0' ) 
        {
            next = leftChild;
        } 
        else 
        {
            if ( c == '1' ) 
            {
                next = rightChild;
            } 
            else 
            {
                throw new RuntimeException( "No valid bitstring" );
            }
        }
        if ( next == null ) 
        {
            throw new RuntimeException( "No valid coding" );
        }
        return next;
    }

}
