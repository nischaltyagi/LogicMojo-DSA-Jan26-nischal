import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'first_missing_positive' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static int first_missing_positive(int n, List<Integer> arr) {
    // Write your code here
        for (int i = 0; i < arr.size(); i++) {
            int current = arr.get(i);
            
            if (current <= 0 || current > n) {
                arr.set(i, n+1);
            }
        }
        
        for (int i = 0; i < arr.size(); i++) {
            int current = Math.abs(arr.get(i));
            
            if (current == (n + 1)) {
                continue;
            }
            
            int markedIndex = current - 1;
            int markedValue = -1 * arr.get(markedIndex);
            
            if (markedValue > 0) {
                continue;
            }
            
            arr.set(markedIndex, markedValue);
        }
        
        
        for (int i = 0; i < arr.size(); i++) {
            int current = arr.get(i);
            
            if (current > 0) {
                return i + 1;
            }
        }
        
        return arr.size() + 1;
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

        int result = Result.first_missing_positive(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
