import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'twoSum' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER target
     *  2. INTEGER n
     *  3. INTEGER_ARRAY arr
     */

    public static List<Integer> twoSum(int target, int n, List<Integer> arr) {
    // Write your code here
        int left = 0;
        int right = arr.size() - 1;
        
        while (left < right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum == target) {
                return new ArrayList<>(Arrays.asList(left+1, right+1));
            } else if (sum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        
        return new ArrayList<>(Arrays.asList(-1, -1));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int targert = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.twoSum(targert, n, arr);

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
