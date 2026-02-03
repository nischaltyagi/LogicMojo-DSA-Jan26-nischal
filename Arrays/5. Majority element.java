import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'majorityElement' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static int majorityElement(int n, List<Integer> arr) {
    // Write your code here
        int ans = arr.get(0); // basically this is starting and we assume this to be majority occurring
        int count = 1;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) == ans) {
                count += 1;
            } else {
                count -= 1;
            }
            
            if (count == 0) {
                ans = arr.get(i);
                count = 1;
            }
        }
        
        count = 0;
       for (int current: arr) {
           if (current == ans) {
               count += 1;
           }
       } 
       
        return count > n/2 ? ans : -1;
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

        int result = Result.majorityElement(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
