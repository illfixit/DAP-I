public class OneFollowsZeroStrategy
extends DoublyLinkedList.InsertionStrategy<Integer>
{
    public boolean select( Integer ref )
    {
        return (int)ref == 0;
    }
    
    public Integer toInsert( Integer ref )
    {
        return 1;
    }
}