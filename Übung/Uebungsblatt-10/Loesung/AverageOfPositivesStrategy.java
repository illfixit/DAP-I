public class AverageOfPositivesStrategy 
extends DoublyLinkedList.InspectionStrategy<Integer>
{
    private int sum;
    private int quantity;

    public AverageOfPositivesStrategy()
    {
        sum = 0;
        quantity = 0;
    }

    public void inspect( Integer ref )
    {
        if ( ref > 0 )
        {
            sum += ref;
            quantity++;
        }
    }

    public double getAverage()
    {
        return (double)sum / quantity;
    }
    
}