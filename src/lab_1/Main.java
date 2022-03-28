package lab_1;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        //task2();
        //task3();
        //task4();
        //task5();
    }





    /**
     *  Дано натуральное число n.
     *	Вычислить (2/1) + (3/2) + (4/3) + (n+1/n).
     */

    private static void task1() {
        System.out.printf("\t\tВариант 45\n\n");

        //init
        int n = 0;
        double resultValue = 0;
        n = (int) ((Math.random()*15) + 2);

        //natural number check (for input)
        if (n <= 0)
            System.out.println("Начните заново, и введите натуральное число:)");
        else {
            for( int i = 1; i <= n; i++) {
                resultValue += (((float)i)+1)/((float)i);

                System.out.print((i+1) + "/" + i);
                if(i != n)
                    System.out.print(" + ");
                else
                    System.out.print(" = ");
            }

            //result print
            System.out.println(resultValue);
        }
    }





    /*
     * В некотором году (назовём его условно первым) на участке в 100 гектаров средняя урожайность ячменя составила
     * 20 центнеров с гектара. После этого каждый год площадь участка увеличивалась на 5 %, а средняя урожайность
     * — на 2 %. Определить:
     * а) урожайность за второй, третий, …, восьмой год;
     * б) площадь участка в четвёртый, пятый, …, седьмой год;
     * в) общий урожай за первые шесть лет;
     * г) в каком году урожайность превысит 22 центнера с гектара;
     * д) в каком году площадь участка станет больше 120 гектаров;
     * е) в каком году общий урожай, собранный за все время, начиная с первого года, превысит 800 центнеров.
     */

    private static void task2() {
        //init
        float yield = 20.0f; //initial
        float area = 100.0f; //initial
        float annualAreaIncrease = 0.05f;
        float annualYieldIncrease = 0.02f;

        System.out.printf("\t\tВариант 70\n\t\t а+г) \n\n");
        consoleCheckAnnualYield(yield, annualYieldIncrease, 8, 2); //для проверки превышения урожая или площади какого-то лимита - изменять значение "крайнего года"

        System.out.printf("\n\t\t б+д) \n\n");
        consoleCheckAnnualArea(area, annualAreaIncrease, 7, 4);

        System.out.printf("\n\t\t в+е) \n\n");
        consoleCheckAllYield(area, annualAreaIncrease, yield, annualYieldIncrease, 6, 1);
    }

    private static void consoleCheckAnnualYield (float initialYield, float annualYieldIncrease, int lastYear, int firstYear) {
        short checkIncrease = 1;

        for (int i = 0; i < lastYear; i++) {
            if (i >= (firstYear - 1))
                System.out.println("Урожайность за " + (i + 2022) + " год -> " + initialYield);
            if (initialYield > 22 && checkIncrease == 1) {
                System.out.printf("\n(В " + (i + 2022) + " году урожайность превысила 22ц)\n\n");
                checkIncrease = 0;
            }
            initialYield = initialYield + (initialYield*annualYieldIncrease);
        }
    }

    private static void consoleCheckAnnualArea (float initialArea, float annualAreaIncrease, int lastYear, int firstYear) {
        short checkIncrease = 1;

        for (int i = 0; i < lastYear; i++) {
            if (i >= (firstYear - 1))
                System.out.println("Площадь за " + (i + 2022) + " год -> " + initialArea);
            if (initialArea > 120 && checkIncrease == 1) {
                System.out.printf("\n(В " + (i + 2022) + " площадь превысила 120га)\n\n");
                checkIncrease = 0;
            }
            initialArea = initialArea + (initialArea*annualAreaIncrease);
        }
    }

    private static void consoleCheckAllYield(float initialArea, float annualAreaIncrease, float initialYield, float annualYieldIncrease, int lastYear, int firstYear) {
        float allSum = 0;
        short checkSumOver = 0;

        for (int i = 0; i < lastYear; i++) {
            allSum += initialArea*initialYield;
            initialArea = initialArea + (initialArea*annualAreaIncrease);
            initialYield = initialYield + (initialYield*annualYieldIncrease);
            if(allSum > 800 && checkSumOver == 0) {
                System.out.println("В " + (i + 2022) + " году урожай превысил 800ц");
                checkSumOver = 1;
            }
        }

        System.out.println("Общий вес урожая за 6 лет -> " + allSum + "ц");
    }





    /* Даны натуральное число n и числа а1, a2, …, аn. Определить:
     * а) |а1| + |a2| + ... + |аn|;
     * б) |а1| · |а2| · ... · |an|;
     * в) a1 + a2, a2 + a3, …, an–1 + an;
     * г) a1 – a2 + a3 – ... + (–1)^(n+1)an.
     */

    private static void task3() {
        System.out.printf("\t\tВариант 95\n\n");

        //random length of the array
        int length = (int) ((Math.random()*10) + 2);

        //init
        int[] array = new int[length];
        int sumOfAbsolute = 0;
        int productOfAbsolute = 1;
        int changeableSum = 0;
        int sign = 1;

        //fill array with random values
        System.out.print("Массив -> | ");
        for(int i = 0; i < length; i++) {
            array[i] = (int) ((Math.random()*20) - 10);
            System.out.print(array[i] + " | ");
            sumOfAbsolute += (Math.abs(array[i]));
            productOfAbsolute *= (Math.abs(array[i]));
        }
        System.out.println("\nA) Сумма модулей элементов массива -> " + sumOfAbsolute);
        System.out.println("Б) Произведение модулей элементов массива -> " + productOfAbsolute);

        System.out.print("В) Массив из сумм соседних элементов исходного -> ");
        for (int i = 0; i < length - 1; i++)
            System.out.print(array[i] + array[i + 1] + " | ");

        for (int i = 0; i < length; i++) {
            changeableSum += (sign * array[i]);
            sign *= (-1);
        }

        System.out.println("\nГ) Сумма элементов массива со сменным знаком (-+...) -> " + changeableSum);
    }





    /* Показать, что для всех n = 1, 2, 3, N выполняется следующее условие:
     *
     * (1^5 + 2^5 + ... + n^5) + (1^7 + 2^7 + ... + n^7) == 2(1 + 2 + ... + n)^4
     */

    private static void task4() {
        System.out.printf("\t\tВариант 120\n\n");

        //init
        int testCasting = (int) (Math.random()*45) + 2;
        int counter = 0;
        long firstPart = 0;
        long secondPart = 0;
        long thirdPart = 0;

        //calculations
        for(int j = 1; j <= testCasting; j++) {
            for(int i = 1; i <= j; i++) {
                firstPart += (long) Math.pow(i, 5);
                secondPart += (long) Math.pow(i, 7);
                thirdPart += i;
            }
            if((firstPart + secondPart) == (2*((long) Math.pow(thirdPart, 4))))
                counter++;

            secondPart = firstPart = thirdPart = 0;
        }

        //check
        if (counter == testCasting)
            System.out.println("(1^5 + 2^5 + ... + n^5) + (1^7 + 2^7 + ... + n^7) == 2(1 + 2 + ... + n)^4");
        else
            System.out.println("(1^5 + 2^5 + ... + n^5) + (1^7 + 2^7 + ... + n^7) != 2(1 + 2 + ... + n)^4");
    }





    /* Один из первых академиков российской Академии наук (1725 гг.) математик Христиан Гольдбах (1690–1764 гг.)
     * выдвинул так называемую проблему Гольдбаха, которая предполагает, что всякое целое число, большее или равное 6,
     * может быть представлено в виде суммы 3 простых чисел. Проверьте утверждение Гольдбаха для чисел, не превышающих
     * число 100.
     */

    private static void task5() {
        System.out.printf("Вариант 145\n\n");

        //init
        short checkFind = 0;
        int countDividers = 0;
        int counter = 0;
        int searchedLimit = 100;
        int[] arrayOfSimple = new int[searchedLimit];

        //search natural, add to array
        for (int i = 1; i <= searchedLimit; i++) {
            for(int j = 1; j <= i; j++) {
                if (i%j == 0) {
                    countDividers++;
                }
            }
            if (countDividers == 2 || i == 1) {
                arrayOfSimple[counter] = i;
                counter++;
            }
            countDividers = 0;
        }

        //find combinations
        for (int searchedValue = 6; searchedValue <= searchedLimit; searchedValue++) {
            for (int i = 0; i < counter; i++) {
                for (int j = 0; j < counter; j++) {
                    for (int k = 0; k < counter; k++) {
                        if (searchedValue == (arrayOfSimple[i] + arrayOfSimple[j] + arrayOfSimple[k])) {
                            System.out.println(searchedValue + " = " + (arrayOfSimple[i] + " + " + arrayOfSimple[j]+ " + " + arrayOfSimple[k]));
                            checkFind = 1;
                            break;
                        }
                    }
                    if(checkFind == 1)
                        break;
                }
                if(checkFind == 1)
                    break;
            }
            checkFind = 0;
        }
    }
}



