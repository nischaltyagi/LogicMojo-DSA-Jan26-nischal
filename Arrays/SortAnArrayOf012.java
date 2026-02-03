import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'sort_an_array' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> sort_an_array(int n, List<Integer> arr) {
    // Write your code here
        int zeroPointer = 0;
        int onePointer = 0;
        int twoPointer = n - 1;
        
        while (onePointer <= twoPointer) {
            if (arr.get(onePointer) == 1) {
                onePointer += 1;
            } else if (arr.get(onePointer) == 0){
                swap(arr, onePointer, zeroPointer);
                zeroPointer += 1;
                onePointer += 1;
            } else {
                swap(arr, onePointer, twoPointer);
                twoPointer -= 1;
            }
        }
        
        return arr;
    }
    
    private static void swap(List<Integer> arr, int firstIndex, int secondIndex) {
        int temp = arr.get(firstIndex);
        arr.set(firstIndex, arr.get(secondIndex));
        arr.set(secondIndex, temp);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.sort_an_array(n, arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
