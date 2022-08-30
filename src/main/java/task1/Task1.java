package task1;

/*
Задача №1:
Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
Доп. задания:
1)Написать генератор случайных чисел
2)Добавить флаги, раскрасить матрицу
 */
public class Task1 {
    //Матрица и переменные min, max, avg
    public static long[][] matrix = new long[10][10];
    public static long min;
    public static long max;
    public static double avg;
    //Переменные для реализации псевдослучайных чисел (ГПСЧ) вариант 1
    private static final long A = 1664525;
    private static final long C = 1013904223;
    private static final long MODULE = (long) Math.pow(2, 32);
    private static long seed = System.currentTimeMillis();
    //Переменные для реализации псевдослучайных чисел (ГПСЧ) вариант 2
    public static long num1 = System.currentTimeMillis() % 10;
    public static long num2 = (System.currentTimeMillis() >> 9) % 10;
    //Переменные для установки флагов и расскраски матрицы
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK_BOLD = "\033[1;30m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\033[0;107m";

    //Метод для генерации псевдослучайных чисел (ГПСЧ) вариант 1;
    public static long getRandomNumber1() {
        seed = (seed * A + C) % MODULE;
        return seed % 200;
    }

    //Метод для генерации псевдослучайных чисел (ГПСЧ) вариант 2;
    public static long getRandomNumber2() {
        num1 = 18030 * (num1 & 0xffff) + (num1 >> 16);
        num2 = 30903 * (num2 & 0xffff) + (num2 >> 16);
        return ((num1 << 16) + (num2 & 0xffff)) % 200;
    }

    public static void main(String[] args) {
        //Заполнение матрицы 10х10 случайными числами (использую 1 вариант), а также одновременный поиск min, max, avg
        long randNumb = getRandomNumber1();
        min = randNumb;
        max = randNumb;
        avg = randNumb;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = randNumb;//добавляем найденное число
                randNumb = getRandomNumber2();//находим следующее случайное число
                //Сравниваем с min и max
                if (min > randNumb) min = randNumb;
                if (max < randNumb) max = randNumb;
                avg += randNumb;
            }
        }
        //находим среднее арифметическое
        avg = avg / (matrix.length + matrix[1].length);
        //Вывод матрицы в консоль
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = (int) matrix[i][j];
                //Если это мин. значение, то ставим флаг - окрашиваем ячейку в красный
                if (temp == min) {
                    System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK_BOLD + temp + "\t" + ANSI_RESET);
                    continue; //переходим к следующему значению
                }
                //Если это макс. значение, то ставим флаг - окрашиваем ячейку в зеленый
                if (temp == max) {
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLACK_BOLD + temp + "\t" + ANSI_RESET);
                    continue; //переходим к следующему значению
                }
                System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK_BOLD + temp + "\t" + ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK_BOLD + " MAX " + ANSI_RESET + "= " + max);
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK_BOLD + " MIN " + ANSI_RESET + "= " + min);
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK_BOLD + " AVG " + ANSI_RESET + "= " + avg);
    }
}
