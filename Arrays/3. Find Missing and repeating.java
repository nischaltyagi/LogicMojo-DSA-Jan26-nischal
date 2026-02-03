import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'find_missing' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> find_missing(List<Integer> arr) {
    // Write your code here
        int duplicate = -1;
        int missing = -1;
        for (int index = 0; index < arr.size(); index++) {
            int current = Math.abs(arr.get(index));
            int markingIndex = current - 1;
            int markingValue = arr.get(markingIndex);
            
            if (markingValue < 0) {
                duplicate = current;
            } else {
                arr.set(markingIndex, markingValue*-1);
            }
        }
        for (int index = 0; index < arr.size(); index++) {
            int current = arr.get(index);
            
            if (current > 0) {
                missing = index + 1;
                break;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(duplicate);
        result.add(missing);
        return result;
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

        List<Integer> result = Result.find_missing(arr);

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
