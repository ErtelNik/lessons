import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        printThreeWords();//1
        checkSumSign();//2
        printColor();//3
        compareNumbers();//4

        boolean result = sumTest(2, 6);//5
        System.out.println(result);

        numberSingTest(2);//6


        boolean method7 = numberSingTestBoolean(-2);//7
        System.out.println(method7);

        stringRepeater("asd", 2);//8

        System.out.println(leapYear(404));//9

        int[] array = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0};//10
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
        printArray(array);


        int[] array2 = new int[100];//11
        for (int i = 0; i < 100; i++) {
            array2[i] = i + 1;
        }
        printArray(array2);


        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};//12
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;

            }
        }
        printArray(array3);

        int c = 4;                                       //13
        int[][] array4 = new int[c][c];
        for (int i = 0; i < c; i++) {
            array4[i][i] = 1;
            array4[i][c - 1 - i] = 1;
        }
        printSquareArray(array4);


        printArray(arrayInitialValue(10,5)); //14


    }


    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 2;
        int b = -6;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Суммa отрицательна");
        }
    }

    public static void printColor() {
        int value = -80;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 2;
        int b = 7;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean sumTest(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;

    }

    public static void numberSingTest(int a) {
        String result;
        if (a >= 0) {
            result = "Число положительное";
        } else {
            result = "Число отрицательное";
        }
        System.out.println(result);
    }

    public static boolean numberSingTestBoolean(int a) {
        Boolean result;
        if (a >= 0) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }

    public static void stringRepeater(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    public static boolean leapYear(int a) {
        if (a % 400 == 0) {
            return true;
        } else if (a % 100 == 0) {
            return false;
        } else if (a % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printSquareArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] arrayInitialValue(int  len, int initialValue){
        int [] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

}













