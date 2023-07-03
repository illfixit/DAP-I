public class DoublyLinkedList
{
    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void addFirst( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            first.connectAsPred( e );
            first = e;
        }
        size++;
    }

    public Object getFirst() 
    {
        if ( !isEmpty() )
        {
            return first.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object get( int index ) 
    {
        if ( index >= 0 && index < size )
        {
            Element current = first;
            for ( int i = 0; i < index; i++ )
            {
                current = current.getSucc();
            }
            return current.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object removeFirst()
    {
        if ( !isEmpty() ) 
        {
            Object result = first.getContent();
            if ( first.hasSucc() )
            {
                first = first.getSucc();
                first.disconnectPred();
            }
            else
            {
                first = last = null;
            }
            size--;
            return result;
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent() );  // impliziter Aufruf von toString, falls != null
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }


    



    // Loesungen zu Praktikumsblatt 6
    
    public void clear()    
    {
        first = last = null;
        size = 0;
    }

    public Object getLast() 
    {
        if ( !isEmpty() )
        {
            return last.getContent();
        }
        else
        {
            throw new IllegalStateException();
        }
    }        

    public boolean contains( Object o )
    {
        Element current = first;
        while ( current != null )
        {
            if ( ( o == null && current.getContent() == null )              // beruecksichtigt explizit null als Inhalt
            || ( o != null && o.equals( current.getContent() ) ) 
            )
            {
                return true;
            }
            current = current.getSucc();
        }
        return false;
    }

    public int count( Object o )
    {
        int tally = 0;
        Element current = first;
        while ( current != null )
        {
            if ( ( o == null && current.getContent() == null )              // beruecksichtigt explizit null als Inhalt
            || ( o != null && o.equals( current.getContent() ) )
            )
            {
                tally++;
            } 
            current = current.getSucc();
        }
        return tally;
    }

    public boolean allEqual()
    {
        if ( !isEmpty() )
        {
            Object o = first.getContent();
            Element current = first.getSucc();
            while ( current != null )
            {
                if ( ( o == null && current.getContent() != null )              // beruecksichtigt explizit null als Inhalt
                || ( o != null && !o.equals( current.getContent() ) )
                )
                {
                    return false;
                }
                current = current.getSucc();
            }
            return true;
        }
        else
        {
            return true;              // bei leeren Listen sind alle (nicht vorhandenen) Elemente gleich - in Aufgabenstellung nicht spezifiziert
        }
    }

    // Hilfsmethode für containsDouble
    private boolean contains( Element start, Object o )
    {
        Element current = start;
        while ( current != null )
        {
            if ( ( o == null && current.getContent() == null )              // beruecksichtigt explizit null als Inhalt
            || ( o != null && o.equals( current.getContent() ) )
            )
            {
                return true;
            }
            current = current.getSucc();
        }
        return false;
    }

    public boolean containsDouble()
    {
        if ( !isEmpty() )
        {
            Element current = first;
            while ( current != null )
            {
                if ( contains( current.getSucc(), current.getContent() ) )
                {
                    return true;
                }
                else
                {
                    current = current.getSucc();
                }
            }
        }
        return false;
    }

    // Hilfsmethode fuer insert, remove, subList
    // gibt null zurueck, wenn index ungueltigen Wert besitzt
    private Element elementAt( int index ) 
    {
        Element current = first;
        for ( int i = 0; i < index; i++ )
        {
            current = current.getSucc();
        }
        return current;
    }

    public void insert( int n, Object o ) 
    {
        if ( n >= 0 && n < size )
        {
            Element pre = elementAt( n );
            Element suc = pre.getSucc();
            Element elm = new Element( o );
            pre.connectAsSucc( elm );
            if ( suc == null ) 
            {
                last = elm;
            }
            else
            {
                suc.connectAsPred( elm );  
            }
            size++;
        }
        else
        {
            throw new IndexOutOfBoundsException(); 
        }  
    }

    public void toArray( Object[] arr )
    {
        Element current = first;
        for ( int i = 0; i < arr.length; i++ )
        {
            if ( i < size() ) 
            {
                arr[i] = current.getContent();
                current = current.getSucc();
            } else {
                arr[i] = null;
            }
        }
    }

    public DoublyLinkedList flip()
    {
        DoublyLinkedList reverse = new DoublyLinkedList();
        Element current = last;
        while ( current != null )
        {
            reverse.add( current.getContent() );
            current = current.getPred();
        }
        return reverse;
    }

    public void remove( int n ) 
    {
        if ( n >= 0 && n < size )
        {
            Element toRemove = elementAt( n );
            if ( toRemove == first && toRemove == last )
            {
                first = last = null;
            } 
            else if ( toRemove == first )
            {
                first = toRemove.getSucc();
                first.disconnectPred();
            } 
            else if ( toRemove == last )
            {
                last = last.getPred();
                last.disconnectSucc();
            }
            else
            {
                toRemove.getPred().connectAsSucc( toRemove.getSucc() );
            }
            size--;
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public void remove( Object o ) 
    {
        Element candidate = first;
        Element SuccCandidate;
        while ( candidate != null )
        {
            SuccCandidate = candidate.getSucc();
            if ( ( o == null && candidate.getContent() == null )              // beruecksichtigt explizit null als Inhalt
            || ( o != null && o.equals( candidate.getContent() ) )
            )
            {
                if ( candidate == first && candidate == last )
                {
                    first = last = null;
                } 
                else if ( candidate == first )
                {
                    first = candidate.getSucc();
                    first.disconnectPred();
                } 
                else if ( candidate == last )
                {
                    last = last.getPred();
                    last.disconnectSucc();
                }
                else
                {
                    candidate.getPred().connectAsSucc( candidate.getSucc() );
                }
                size--;
            }
            candidate = SuccCandidate;
        }
    }

    public void concat( DoublyLinkedList dll )
    {
        if ( dll != null && !dll.isEmpty() ) 
        {
            if ( isEmpty() )
            {
                first = dll.first;
            }
            else
            {
                last.connectAsSucc( dll.first );
            }
            last = dll.last;
            size += dll.size;
            dll.clear();
        }
    }

    // Konstruktor
    public DoublyLinkedList( DoublyLinkedList dll )
    {
        for ( Element current = dll.first; current != null; current = current.getSucc() )
        {
            add( current.getContent() );
        }        
    }

    public DoublyLinkedList subList( int from, int to )
    {
        if ( from >= 0 && from < size && to >= 0 && to < size && from < to )
        {
            DoublyLinkedList dll = new DoublyLinkedList();
            Element current = elementAt( from );
            int position = from;
            while ( position < to )
            {
                dll.add( current.getContent() );
                position++;
                current = current.getSucc();
            }
            return dll;
        }
        else 
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeAll( DoublyLinkedList dll ) 
    {
        Element current = dll.first;
        while ( current != null )
        {
            remove( current.getContent() );
            current = current.getSucc();
        }
    }
    
    public void pack()
    {
        Element current = first;

        while ( current != last )
        {
            if ( ( current.getContent() == null && current.getSucc().getContent() == null )
                 || ( current.getContent() != null && current.getContent().equals( current.getSucc().getContent() ) ) )
            {
                current.connectAsSucc( current.getSucc().getSucc() );
                size--;
                if ( current.getSucc() == null )
                {
                    last = current;
                }
            }
            else
            {
                current = current.getSucc();
            }
        }
    }



}
