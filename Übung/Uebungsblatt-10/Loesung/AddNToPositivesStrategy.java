public class AddNToPositivesStrategy
extends DoublyLinkedList.SubstitutionStrategy<Integer>
{
    private int n;

    public AddNToPositivesStrategy( int increment )
    {
        n = increment;
    }

    public Integer substitute( Integer ref )
    {
        if ( ref > 0 )
        {
            return ref + n;
        }
        else 
        {
            return ref;
        }
    }
}