import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main obj = new Main();

        System.out.println("Введите номер задания (1-4):");
        int zadanie = sc.nextInt();

        System.out.println("Введите номер задачи (6-10):");
        int zadacha = sc.nextInt();

        boolean valid = true;

        if (zadanie == 1) {
            if (zadacha == 6) {
                System.out.println("Введите символ:");
                char x = readChar(sc);

                boolean result = obj.isUpperCase(x);

                System.out.println("Результат: " + result);
            } else if (zadacha == 7) {
                System.out.println("Введите a:");
                int a = readInt(sc);
                System.out.println("Введите b:");
                int b = readInt(sc);
                System.out.println("Введите num:");
                int num = readInt(sc);

                boolean result = obj.isInRange(a, b, num);

                System.out.println("Результат: " + result);
            } else if (zadacha == 8) {
                System.out.println("Введите a:");
                int a = readInt(sc);
                System.out.println("Введите b:");
                int b = readInt(sc);

                boolean result = obj.isDivisor(a, b);

                System.out.println("Результат: " + result);
            } else if (zadacha == 9) {
                System.out.println("Введите a:");
                int a = readInt(sc);
                System.out.println("Введите b:");
                int b = readInt(sc);
                System.out.println("Введите c:");
                int c = readInt(sc);

                boolean result = obj.isEqual(a, b, c);

                System.out.println("Результат: " + result);
            } else if (zadacha == 10) {
                System.out.println("Введите a:");
                int a = readInt(sc);
                System.out.println("Введите b:");
                int b = readInt(sc);

                int result = obj.lastNumSum(a, b);

                System.out.println("Результат: " + result);
            } else {
                valid = false;
            }
        } else if (zadanie == 2) {
            if (zadacha == 6) {
                System.out.println("Введите x:");
                int x = readInt(sc);
                System.out.println("Введите y:");
                int y = readInt(sc);
                System.out.println("Введите z:");
                int z = readInt(sc);

                boolean result = obj.sum3(x, y, z);

                System.out.println("Результат: " + result);
            } else if (zadacha == 7) {
                System.out.println("Введите x:");
                int x = readInt(sc);
                System.out.println("Введите y:");
                int y = readInt(sc);

                int result = obj.sum2(x, y);

                System.out.println("Результат: " + result);
            } else if (zadacha == 8) {
                System.out.println("Введите x:");
                int x = readInt(sc);

                String result = obj.age(x);

                System.out.println("Результат: " + result);
            } else if (zadacha == 9) {
                System.out.println("Введите x (1-7):");
                int x = readInt(sc);

                String result = obj.day(x);

                System.out.println("Результат: " + result);
            } else if (zadacha == 10) {
                System.out.println("Введите день недели:");
                String x = sc.next();

                obj.printDays(x);
            } else {
                valid = false;
            }
        } else if (zadanie == 3) {
            if (zadacha == 6) {
                System.out.println("Введите x:");
                int x = readInt(sc);

                boolean result = obj.equalNum(x);

                System.out.println("Результат: " + result);
            } else if (zadacha == 7) {
                System.out.println("Введите x:");
                int x = readInt(sc);

                obj.square(x);
            } else if (zadacha == 8) {
                System.out.println("Введите x:");
                int x = readInt(sc);

                obj.leftTriangle(x);
            } else if (zadacha == 9) {
                System.out.println("Введите x:");
                int x = readInt(sc);

                obj.rightTriangle(x);
            } else if (zadacha == 10) {
                obj.guessGame();
            } else {
                valid = false;
            }
        } else if (zadanie == 4) {
            if (zadacha == 6) {
                System.out.println("Введите размер массива:");
                int n = readInt(sc);

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    System.out.println("Элемент " + i + ":");
                    arr[i] = readInt(sc);
                }

                System.out.println("Массив до: " + Arrays.toString(arr));
                obj.reverse(arr);
                System.out.println("Массив после: " + Arrays.toString(arr));
            } else if (zadacha == 7) {
                System.out.println("Введите размер массива:");
                int n = readInt(sc);

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    System.out.println("Элемент " + i + ":");
                    arr[i] = readInt(sc);
                }

                int[] result = obj.reverseBack(arr);
                System.out.println("Результат: " + Arrays.toString(result));
            } else if (zadacha == 8) {
                System.out.println("Введите размер первого массива:");
                int n1 = readInt(sc);

                int[] arr1 = new int[n1];

                for (int i = 0; i < n1; i++) {
                    System.out.println("Элемент первого " + i + ":");
                    arr1[i] = readInt(sc);
                }

                System.out.println("Введите размер второго массива:");
                int n2 = readInt(sc);

                int[] arr2 = new int[n2];

                for (int i = 0; i < n2; i++) {
                    System.out.println("Элемент второго " + i + ":");
                    arr2[i] = readInt(sc);
                }

                int[] result = obj.concat(arr1, arr2);
                System.out.println("Результат: " + Arrays.toString(result));
            } else if (zadacha == 9) {
                System.out.println("Введите размер массива:");
                int n = readInt(sc);

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    System.out.println("Элемент " + i + ":");
                    arr[i] = readInt(sc);
                }

                System.out.println("Введите x:");
                int x = readInt(sc);

                int[] result = obj.findAll(arr, x);
                System.out.println("Результат: " + Arrays.toString(result));
            } else if (zadacha == 10) {
                System.out.println("Введите размер массива:");
                int n = readInt(sc);

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    System.out.println("Элемент " + i + ":");
                    arr[i] = readInt(sc);
                }

                int[] result = obj.deleteNegative(arr);
                System.out.println("Результат: " + Arrays.toString(result));
            } else {
                valid = false;
            }
        } else {
            valid = false;
        }

        if (!valid) {
            System.out.println("Нет такой задачи");
        }

        sc.close();
    }


    private static int readInt(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
                System.out.println("Неверный ввод. Пожалуйста, введите число");
            }
        }
    }

    private static char readChar(Scanner sc) {
        while (true) {
            String input = sc.next();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите один символ");
            }
        }
    }


    // Задание 1
    // №6
    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    // №7
    public boolean isInRange(int a, int b, int num) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return num >= min && num <= max;
    }

    // №8
    public boolean isDivisor(int a, int b) {
        return (a != 0 && b % a == 0) || (b != 0 && a % b == 0);
    }

    // №9
    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    // №10
    public int lastNumSum(int a, int b) {
        return (a % 10) + (b % 10);
    }


    // Задание 2
    // №6
    public boolean sum3(int x, int y, int z) {
        return (x + y == z) || (x + z == y) || (y + z == x);
    }

    // №7
    public int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20;
        }
        return sum;
    }

    // №8
    public String age(int x) {
        int lastDigit = x % 10;
        int lastTwoDigits = x % 100;

        if (lastDigit == 1 && lastTwoDigits != 11) {
            return x + " год";
        } else if ((lastDigit == 2 || lastDigit == 3 || lastDigit == 4) && (lastTwoDigits != 12 && lastTwoDigits != 13 && lastTwoDigits != 14)) {
            return x + " года";
        } else {
            return x + " лет";
        }
    }

    // №9
    public String day(int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }

    // №10
    public void printDays(String x) {
        switch (x.toLowerCase()) {
            case "понедельник":
                System.out.println("понедельник");
            case "вторник":
                System.out.println("вторник");
            case "среда":
                System.out.println("среда");
            case "четверг":
                System.out.println("четверг");
            case "пятница":
                System.out.println("пятница");
            case "суббота":
                System.out.println("суббота");
            case "воскресенье":
                System.out.println("воскресенье");
                break;
            default:
                System.out.println("это не день недели");
        }
    }


    // Задание 3
    // №6
    public boolean equalNum(int x) {
        if (x < 0) x = -x;
        if (x == 0) return true;
        int first = x % 10;
        x /= 10;
        while (x > 0) {
            if (x % 10 != first) {
                return false;
            }
            x /= 10;
        }
        return true;
    }

    // №7
    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // №8
    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // №9
    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // №10
    public void guessGame() {
        Random random = new Random();
        int secret = random.nextInt(10);
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int guess;
        do {
            System.out.println("Введите число от 0 до 9:");
            guess = scanner.nextInt();
            attempts++;
            if (guess != secret) {
                System.out.println("Вы не угадали, ");
            }
        } while (guess != secret);
        System.out.println("Вы угадали!");
        System.out.println("Вы отгадали число за " + attempts + " попытки");
    }


    // Задание 4
    // №6
    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    // №7
    public int[] reverseBack(int[] arr) {
        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }

        return reversed;
    }

    // №8
    public int[] concat(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);

        return result;
    }

    // №9
    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int num : arr) {
            if (num == x) {
                count++;
            }
        }

        int[] indices = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                indices[index++] = i;
            }
        }

        return indices;
    }

    // №10
    public int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num >= 0) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num >= 0) {
                result[index++] = num;
            }
        }

        return result;
    }
}