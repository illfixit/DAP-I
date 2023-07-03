
public class TestMethods
{
    public static void main( String[] args )
    {
        testMethods();
    }
    
    public static void testMethods()
    {

        System.out.println("digitSum( 131175 )  -soll:  18  -ist:  " + MethodsTestat3.digitSum( 131175 ) );
        System.out.println("digitSum( 631 )  -soll:  10  -ist:  " + MethodsTestat3.digitSum( 631 ) );
        System.out.println();
        
        System.out.println("power( 3, 4 )  -soll:  81  -ist:  " + MethodsTestat3.power( 3, 4 ) );
        System.out.println("power( 7, 3 )  -soll:  343  -ist:  " + MethodsTestat3.power( 7, 3 ) );
        System.out.println();
        
        System.out.println("sumUpNegatives( {-8,7,12,0,5,4,-3,2,-11},8 )  -soll:  -22  -ist:  " + MethodsTestat3.sumUpNegatives( new int[]{-8,7,12,0,5,4,-3,2,-11},8 ) );
        System.out.println("sumUpNegatives( {8,7,-12,0,5,4,-3,2},7 )  -soll:  -15  -ist:  " + MethodsTestat3.sumUpNegatives( new int[]{8,7,-12,0,5,4,-3,2},7 ) );
        System.out.println();
        
        System.out.println("countPositives({-8,7,12,0,-5,4,-3,2,-11},8)  -soll:  4  -ist:  " + MethodsTestat3.countPositives( new int[]{-8,7,12,0,-5,4,-3,2,-11},8) );
        System.out.println("countPositives({8,7,-12,0,5,4,-3,2,11},8)  -soll:  6  -ist:  " + MethodsTestat3.countPositives( new int[]{8,7,-12,0,5,4,-3,2,11},8) );
        System.out.println();
        
        System.out.println("countPositivesLimited({8,-7,12,0,5,4,-3,2,-11},0,8)  -soll:  5  -ist:  " + MethodsTestat3.countPositivesLimited( new int[]{8,-7,12,0,5,4,-3,2,-11},0,8) );
        System.out.println("countPositivesLimited({8,-7,12,0,5,4,-3,2,-11},0,7)  -soll:  5  -ist:  " + MethodsTestat3.countPositivesLimited( new int[]{8,-7,12,0,5,4,-3,2,-11},0,7) );
        System.out.println("countPositivesLimited({8,-7,12,0,5,4,-3,2,-11},2,7)  -soll:  4  -ist:  " + MethodsTestat3.countPositivesLimited( new int[]{8,-7,12,0,5,4,-3,2,-11},2,7) );
        System.out.println("countPositivesLimited({8,-7,12,0,5,4,-3,2,-11},3,6)  -soll:  2  -ist:  " + MethodsTestat3.countPositivesLimited( new int[]{8,-7,12,0,5,4,-3,2,-11},3,6) );
        System.out.println();
        
        System.out.println("maximum({1,3,5,4,2},4)  -soll:  5  -ist:  " + MethodsTestat3.maximum( new int[]{1,3,5,4,2},4 ) );
        System.out.println("maximum({1,2,3,4,5},4)  -soll:  5  -ist:  " + MethodsTestat3.maximum( new int[]{1,2,3,4,5},4 ) );
        System.out.println("maximum({5,4,3,2,1},4)  -soll:  5  -ist:  " + MethodsTestat3.maximum( new int[]{5,4,3,2,1},4 ) );
        System.out.println();

        System.out.println("isSorted({1,2,3,4,5},4)  -soll:  true   -ist:  " + MethodsTestat3.isSorted(new int[]{1,2,3,4,5},4) );
        System.out.println("isSorted({1,2,33,41,52},4)  -soll:  true   -ist:  " + MethodsTestat3.isSorted(new int[]{1,2,33,41,52},4) );
        System.out.println("isSorted({1,2,33,4,52},4)  -soll:  false  -ist:  " + MethodsTestat3.isSorted(new int[]{1,2,33,4,52},4) );
        System.out.println();
        
        System.out.println("contains({1,2,3,4,5},4,3)  -soll:  true   -ist:  " + MethodsTestat3.contains(new int[]{1,3,5,4,2},4,3) );
        System.out.println("contains({1,2,3,4,5},4,1)  -soll:  true   -ist:  " + MethodsTestat3.contains(new int[]{1,3,5,4,2},4,1) );
        System.out.println("contains({1,2,3,4,5},4,6)  -soll:  false  -ist:  " + MethodsTestat3.contains(new int[]{1,3,5,4,2},4,6) );
        System.out.println();

        char[] carr1 = {'a','b','c','d','e','f'};
        char[] carr2 = {'a','b','c','d','e'};
        char[] carr3 = {'x','b','c','d','e','f'};
        char[] carr4 = {'a','b','c','d','e','z'};
        System.out.println("contentCheck  #1  -soll:  true   -ist:  " + MethodsTestat3.contentCheck(carr1, carr2, 0) );
        System.out.println("contentCheck  #2  -soll:  true   -ist:  " + MethodsTestat3.contentCheck(carr1, carr2, 4) );
        System.out.println("contentCheck  #3  -soll:  false  -ist:  " + MethodsTestat3.contentCheck(carr1, carr3, 0) );
        System.out.println("contentCheck  #4  -soll:  false  -ist:  " + MethodsTestat3.contentCheck(carr1, carr3, 5) );
        System.out.println("contentCheck  #5  -soll:  true   -ist:  " + MethodsTestat3.contentCheck(carr1, carr4, 4) );
        System.out.println("contentCheck  #6  -soll:  false  -ist:  " + MethodsTestat3.contentCheck(carr1, carr4, 5) );
        System.out.println();
        
        // palindromCheck
        System.out.println("palindromCheck({3,8,5,2,5,2,5,8,3}, 8) -soll: true   -ist: " + MethodsTestat3.palindromCheck(new char[]{3,8,5,2,5,2,5,8,3},8) );
        System.out.println("palindromCheck({3,8,5,2,2,5,8,3}, 7) -soll: true   -ist: " + MethodsTestat3.palindromCheck(new char[]{3,8,5,2,2,5,8,3},7) );
        System.out.println("palindromCheck({3,8,5,2,5,2,5,8,4}, 8) -soll: false   -ist: " + MethodsTestat3.palindromCheck(new char[]{3,8,5,2,5,2,5,8,4},8) );
        System.out.println("palindromCheck({3,8,5,1,2,5,8,3}, 7) -soll: false   -ist: " + MethodsTestat3.palindromCheck(new char[]{3,8,5,1,2,5,8,3},7) );
        System.out.println("palindromCheck({8,2,8}, 2) -soll: true   -ist: " + MethodsTestat3.palindromCheck(new char[]{8,2,8}, 2) );
        System.out.println("palindromCheck({8,8}, 1) -soll: true   -ist: " + MethodsTestat3.palindromCheck(new char[]{8,8}, 1) );
        System.out.println("palindromCheck({3,8}, 1) -soll: false   -ist: " + MethodsTestat3.palindromCheck(new char[]{3,8}, 1) );
        System.out.println("palindromCheck({8}, 0) -soll: true   -ist: " + MethodsTestat3.palindromCheck(new char[]{8}, 0) );        
        System.out.println();
        
        int[] arr7 = {3, 8, 5, 2, 5, 2, 8, 3, 3, 9};
        System.out.println("getIndex({3,8,5,2,5,2,8,3,3,9}, arr7.length-1, 3) -soll: 0   -ist: " + MethodsTestat3.getIndex(arr7, arr7.length-1, 3) );
        System.out.println("getIndex({3,8,5,2,5,2,8,3,3,9}, arr7.length-1, 8) -soll: 1   -ist: " + MethodsTestat3.getIndex(arr7, arr7.length-1, 8) );
        System.out.println("getIndex({3,8,5,2,5,2,8,3,3,9}, arr7.length-1, 5) -soll: 2   -ist: " + MethodsTestat3.getIndex(arr7, arr7.length-1, 5) );
        System.out.println("getIndex({3,8,5,2,5,2,8,3,3,9}, arr7.length-1, 2) -soll: 3   -ist: " + MethodsTestat3.getIndex(arr7, arr7.length-1, 2) );
        System.out.println("getIndex({3,8,5,2,5,2,8,3,3,9}, arr7.length-1, 9) -soll: 9   -ist: " + MethodsTestat3.getIndex(arr7, arr7.length-1, 9) );
        System.out.println("getIndex({3,8,5,2,5,2,8,3,3,9}, arr7.length-1, 7) -soll: -1  -ist: " + MethodsTestat3.getIndex(arr7, arr7.length-1, 7) );
        System.out.println();
    
        System.out.println("toString({1},0)  -soll:  1   -ist:  " + MethodsTestat3.toString(new int[]{1},0) );
        System.out.println("toString({1,2,3,4,5},4)  -soll:  1,2,3,4,5   -ist:  " + MethodsTestat3.toString(new int[]{1,2,3,4,5},4) );
    }

}
