import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maxProfit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums
     *  2. INTEGER n
     */

    public static int maxProfit(List<Integer> nums, int n) {
    // Write your code here
        int minPrice = nums.get(0);
        int totalProfit = 0;
        int maxProfit = 0;
        
        for (int i = 1; i < nums.size(); i++) {
            int currentProfit = nums.get(i) - minPrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            } else {
                totalProfit += maxProfit;
                minPrice = nums.get(i);
                maxProfit = 0;
            }
        }
        totalProfit += maxProfit;
                
        return totalProfit;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] priceTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> price = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int priceItem = Integer.parseInt(priceTemp[i]);
            price.add(priceItem);
        }

        int profit = Result.maxProfit(price, n);

        bufferedWriter.write(String.valueOf(profit));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
