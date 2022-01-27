import java.util.Arrays;
import java.util.BitSet;

public class Main {
    public static void main(String[] args) {
        int[] num = {1, 2, 4, 5, 6};
        int[] numTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        int[] numThree = {};
      /* Почему-это метод getMis работает как-то неправильно. В каких-то массивах найденное число верное, а в каких-то нет.
        System.out.println(getMis(num, num.length + 1));
        System.out.println(getMis(numTwo, numTwo.length + 1));
        System.out.println(getMis(numThree, numThree.length + 1));
        */
        //Поэтому я посмотрел в интернете, как это можно было сделать и нашел способ с запоминанием битов.
        //Проверяем с помощью набора битов числа, где установленно ноль бит - пропущенное число.
        printMis(num, num.length + 1);
        printMis(numTwo, numTwo.length + 1);
        printMis(numThree, numThree.length + 1);
    }

    private static int getMis(int[] numbers, int count) {
        int sum = count * ((count + 1) / 2);
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }

        return sum - actualSum;
    }

    private static void printMis(int[] numbers, int count) {
        int missingCount = count - numbers.length;

        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }

    }


}