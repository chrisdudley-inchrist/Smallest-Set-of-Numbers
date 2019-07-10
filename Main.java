import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[][] sets = new int[][]{
                {0, 3}, {2, 6}, {3, 4}, {6, 9}
        };

        System.out.print("The common number of sets: ");
        for (int i : getSets(sets)) {
            System.out.print(i + " ");
        }
        System.out.print("}");


    }

    /**
     * Good morning! Here's your coding interview problem for today.
     *
     * This problem was asked by Google.
     *
     * Given a set of closed intervals, find the smallest set of numbers
     * that covers all the intervals. If there are multiple smallest sets, return any of them.
     *
     * For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9],
     * one set of numbers that covers all these intervals is {3, 6}.
     * @param sets the intervals
     * @return the result
     */
    private static int[] getSets(int[][] sets) {
        List<Integer> uniqueNums = new LinkedList<>();
        LinkedHashSet commonNums = new LinkedHashSet();

        for (int[] arr : sets) {
            for (int i = 0; i < arr.length; i++) {

                if (!uniqueNums.contains(arr[i])) {
                    uniqueNums.add(arr[i]);
                } else if (uniqueNums.contains(arr[i])) {
                    commonNums.add(arr[i]);
                    if (commonNums.size() == arr.length) {
                        int[] commonNumsArray = new int[commonNums.size()];
                        int j = 0;
                        for (Object k : commonNums) {
                            commonNumsArray[j++] = (int) k;
                        }
                        return commonNumsArray;
                    }
                }
            }
        }
        return new int[0];
    }
}