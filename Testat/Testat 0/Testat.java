import java.util.Arrays;

public class Testat {
    public static int[] apply(int[] arr, int x) {
        int[] newArr = new int[arr.length];
        int currentIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x) {
                newArr[currentIdx] = arr[i];
                currentIdx++;
            }
        }

        newArr = Arrays.copyOfRange(newArr, 0, currentIdx);

        return newArr;

    }
}
