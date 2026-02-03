import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'rain_water' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY hei as parameter.
     */

    public static int rain_water(List<Integer> hei) {
    // Write your code here
        int left = 0;
        int right = hei.size() - 1;
        
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        
        int totalWater = 0;
        while (left <= right) {
            if (hei.get(left) < hei.get(right)) {
                leftMax = Math.max(leftMax, hei.get(left));
                totalWater += leftMax - hei.get(left);
                left++;
            } else {
                rightMax = Math.max(rightMax, hei.get(right));
                totalWater += rightMax - hei.get(right);
                right--;
            }
        }
        
        return totalWater;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] heiTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> hei = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int heiItem = Integer.parseInt(heiTemp[i]);
            hei.add(heiItem);
        }

        int result = Result.rain_water(hei);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
