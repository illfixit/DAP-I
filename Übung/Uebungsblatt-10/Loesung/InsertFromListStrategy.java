public class InsertFromListStrategy
extends DoublyLinkedList.InsertionStrategy<Integer>
{
    private DoublyLinkedList<Integer> second;

    public InsertFromListStrategy( DoublyLinkedList<Integer> d )
    {
        second = d;
    }

    public boolean select( Integer ref )
    {
        return true;
    }

    public Integer toInsert( Integer ref )
    {
        if ( !second.isEmpty() )
        {
            Integer newContent = second.getFirst();
            second.removeFirst();
            return newContent;
        } else {
            throw new RuntimeException();
        }
    }
}