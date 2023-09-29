import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MeanMedianModeCalculator {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6, 3, 2, 8, 8};
        
        double mean = calculateMean(numbers);
        double median = calculateMedian(numbers);
        int mode = calculateMode(numbers);
        
        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Mode: " + mode);
    }

    public static double calculateMean(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

    public static double calculateMedian(int[] numbers) {
        Arrays.sort(numbers);
        int middle = numbers.length / 2;
        if (numbers.length % 2 == 0) {
            int mid1 = numbers[middle - 1];
            int mid2 = numbers[middle];
            return (double) (mid1 + mid2) / 2;
        } else {
            return (double) numbers[middle];
        }
    }

    public static int calculateMode(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxCount = 0;
        int mode = 0;
        
        for (int num : numbers) {
            int count = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, count);
            
            if (count > maxCount) {
                maxCount = count;
                mode = num;
            }
        }
        
        return mode;
    }
}
