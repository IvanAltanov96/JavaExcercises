import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    private static final BufferedReader READER;

    static {
        READER=new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {

        findClosestNumber();
    }

    public static void findClosestNumber() throws IOException {
        int[] numbers = Arrays.stream(READER.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int closestNumber = Integer.MAX_VALUE;
        int closestIndex = 0;

        for (int i = 0; i < numbers.length; i++) {
            int absCurrentNumber = Math.abs(numbers[i]);

            if (absCurrentNumber < closestNumber) {
                closestIndex = i;
                closestNumber = absCurrentNumber;
            } else if (absCurrentNumber
                    == closestNumber && numbers[i] > 0
                    && numbers[closestIndex] < 0) {

                closestIndex = i;
            }
        }

        System.out.println(closestNumber);
    }
}
