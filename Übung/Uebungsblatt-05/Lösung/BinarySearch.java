public class BinarySearch {
	 public static void main(String [] args)
    {
        int[] sorted = {1,3,4,5,8,12,15,20,22,29,32,44,199,1023};
        
        System.out.println("Iterative binary search for " + 3 + ": " + binarySearchIterative(sorted, 3));
        System.out.println("Iterative binary search for " + 3 + ": " + binarySearchRecursive(sorted, 3));
        
        System.out.println("Iterative binary search for " + 9 + ": " + binarySearchIterative(sorted, 9));
        System.out.println("Iterative binary search for " + 9 + ": " + binarySearchRecursive(sorted, 9));
    }
    
    static boolean binarySearchIterative(int[] sorted, int candidate) 
    {
		int left = 0; // linker Rand
		int right = sorted.length - 1; // rechter Rand
        
		while (left <= right) 
        {
			int middle = (left + right) / 2; // Mitte des zu betrachtenden Bereichs
            
			if (sorted[middle] == candidate) 
            { // candidate gefunden?
				return true;
			} 
            else if (sorted[middle] < candidate) 
            { // im rechten Abschnitt weitersuchen
				left = middle + 1;
			} 
            else 
            { // im linken Abschnitt weitersuchen
				right = middle - 1;
			}
		}
		return false;
	}
    
    
    static boolean binarySearchRecursive(int[] sorted, int candidate)
    {
        return binarySearchRecursive(sorted, candidate, 0, sorted.length - 1);
    }
    
    
    static boolean binarySearchRecursive(int[] sorted, int candidate, int left, int right)
    {
        if (left > right)
        {
            return false;
        }
        
        int middle = (right + left) / 2;
            
        if (candidate == sorted[middle])
        {
            return true;
        }
        else if (candidate < sorted[middle])
        {
            return binarySearchRecursive(sorted, candidate, left, middle - 1);
        }
        else
        {
            return binarySearchRecursive(sorted, candidate, middle + 1, right);
        }
	}
    
}

