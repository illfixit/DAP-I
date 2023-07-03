public class RemoveAllNegatvesStrategy
extends DoublyLinkedList.DeletionStrategy<Integer>
{
    public boolean select( Integer ref )
    {
        return ref < 0;
    }
}