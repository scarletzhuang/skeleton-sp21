class IntroToJava {
    public static int mystery(int[] inputArray, int k) {
        int x = inputArray[k];
        int answer = k;
        int index = k + 1;
        while (index < inputArray.length) {
            if (inputArray[index] < x) {
                x = inputArray[index];
                answer = index;
            }
            index += 1;
        }
        return answer;
    }

    /* Use mystery to sort a given array of ints in ascending order. */
    public static void sortMystery(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            int minIndex = mystery(inputArray, i);
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;
        }
    }

    /* Implement mystery recursively */
    public static int recurMystery(int[] inputArray, int k) {
        return recurMysteryHelper(inputArray, k, inputArray.length - 1);
    }
    private static int recurMysteryHelper(int[] inputArray, int i, int j) {
        if (i == j) {
            return i;
        }
        int index = recurMysteryHelper(inputArray, i + 1, j);
        if (inputArray[i] < inputArray[index]) {
            return i;
        }
        return index;
    }

    public static int recurMystery2(int[] inputArray, int k) {
        if (k == inputArray.length) {
            return k;
        }
        index = recurMystery2(inputArray, k + 1);
        if (inputArray[k] < inputArray[index]) {
            return k;
        }
        return index;
    }
}
