import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        String word1 = "wa";
        String word2 = "ht";
        String result = mergeStrings(word1, word2);
        System.out.println(result);
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        boolean[] result1 = kidsWithCandies(candies, extraCandies);



        for (boolean canHaveMaxCandies : result1) {
            System.out.println(canHaveMaxCandies);
        }
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        }
    public static String mergeStrings(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();

        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                mergedString.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                mergedString.append(word2.charAt(j));
                j++;
            }
        }

        return mergedString.toString();
    }
    public static boolean[] kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        boolean[] result = new boolean[n];

        int maxCandies = findMaxCandies(candies);

        for (int i = 0; i < n; i++) {
            result[i] = candies[i] + extraCandies >= maxCandies;
        }

        return result;
    }

    private static int findMaxCandies(int[] candies) {
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        return max;
    }
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }
    }
    }
public class MainTest {

    @Test
    public void testMergeStrings() {
        String word1 = "wa";
        String word2 = "ht";
        String result = Main.mergeStrings(word1, word2);
        assertEquals("waht", result);
    }

    @Test
    public void testKidsWithCandies() {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        boolean[] result = Main.kidsWithCandies(candies, extraCandies);
        boolean[] expected = {true, true, true, false, true};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMoveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        Main.moveZeroes(nums);
        int[] expected = {1, 3, 12, 0, 0};
        assertArrayEquals(expected, nums);
    }
}
