package task2;

/*
Задача №2:
Отсортировать массив [5,6,3,2,5,1,4,9] (использую алгоритм быстрой сортировки)
Доп.задание:
1)Написать тесты
2)Учесть дбликаты
3)Добавил алгоритм сортировки двумерного массива с помощью пузырьковой сортировки
 */
public class Task2 {
    //реализация быстрой сортировки
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//Завершаем выполнение, если длина массива равна 0
        if (low >= high)
            return;//Завершаем выполнение, если уже нечего делить
        //Выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        //Разделяем массив на подмассивы, короторые больше или меньше опорного элемента
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < opora)
                i++;
            while (array[j] > opora)
                j--;
            //меняем местами элементы
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }

    //реализация пузырьковой сортировки двумерного массива
    public static void matrixBubbleSort(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int m = 0; m < height; m++) {
            for (int n = 0; n < width; n++) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (i + 1 == height && j + 1 == width) {
                            continue;
                        }else {
                        if (j + 1 == width && matrix[i][j] > matrix[i + 1][0]) {
                            int temp = matrix[i][j];
                            matrix[i][j] = matrix[i + 1][0];
                            matrix[i + 1][0] = temp;
                        } else if (j + 1 == width) {
                            continue;
                        } else if (matrix[i][j] > matrix[i][j + 1]) {
                            int temp = matrix[i][j];
                            matrix[i][j] = matrix[i][j + 1];
                            matrix[i][j + 1] = temp;
                        }
                    }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        //Заполним матрицу случайными числами с помощью Math.random()
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }
        System.out.println("Матрица до сортировки:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Матрица после сортировки:");
        matrixBubbleSort(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("///////////");
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        System.out.println("Массив до сортировки:");
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Массив после сортировки:");
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}
