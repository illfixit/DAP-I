public class SimpleHashtable<T>
{
    Object[] table;
    int capacity;
    int size;

    public SimpleHashtable( int c )
    {
        if ( c > 0 ) 
        {
            capacity = c;
        } else {
            throw new IllegalArgumentException();
        }
        table = new Object[capacity];
        size = 0;
    }

    public void put( T o )
    {
        if ( !contains( o ) )
        {
            if ( (double)(size + 1) / capacity > 0.75 )
            {
                rehash();
            }
            int p = position( o );
            for ( int i = 0; i < table.length; i++ )
            {
                if ( table[ (i + p) % capacity ] == null ) 
                {
                    table[ (i + p) % capacity ] = o;
                    size++;
                    return;
                }     
            }
        }
    }

    public boolean contains( T o )
    {
        int p = position( o );
        for ( int i = 0; i < table.length; i++ )
        {
            Object c = table[ (i + p) % capacity ];
            if ( c != null )
            {
                if ( c.equals( o ) )
                {
                    return true;
                }
            } else {
                // ohne Loeschen
                // return false;
            }     
        }
        return false;
    }

    public void remove( T o )
    {
        int p = position( o );
        for ( int i = 0; i < table.length; i++ )
        {
            int checkP = (i + p) % capacity;
            Object c = table[ checkP ];
            if ( c != null && c.equals( o ) ) 
            {
                table[ checkP ] = null;
            }
        }
    }

    private int position( T o )
    {
        return Math.abs( o.hashCode() % capacity );
    }

    public int size()
    {
        return size;
    }

    // Erzeugung des Feldes ist nicht typsicher möglich
    // immer auftretende Warnung wird unterdrueckt,
    // Methode put erlaubt nur das Eintragen von Objekten des Typs T 
    @SuppressWarnings({"unchecked"})
    protected void rehash()
    {
        capacity = 2 * capacity;
        Object[] oldTable = table;
        table = new Object[capacity];
        size = 0;
        for ( Object c : oldTable )
        {
            if ( c != null )
            {
                put( (T)c );
            }
        }
    }

    public void showAll() 
    {
        for ( int i = 0; i < capacity; i++ )
        {
            if ( table[i] != null )
            {
                System.out.print( "index: " + i + " object: " + table[i].toString() + " hashcode: " + table[i].hashCode());
                System.out.println();
            }
        }
    }
}
