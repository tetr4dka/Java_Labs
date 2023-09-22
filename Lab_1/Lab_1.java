import java.util.Scanner;

public class Lab_1 {
    public static int getCollatzSteps(int number) {
        int count = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = 3 * number + 1;
            }
            count++;
        }
        return count;
    }

    public static int calculateAlternatingSignSum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                sum += numbers[i];
            } else {
                sum -= numbers[i];
            }
        }
        return sum;
    }

    public static int TreasureHunt(Scanner sc) {
        int x = 0;
        int y = 0;
        int n = 0;
        boolean flag = true;
        int c_x = sc.nextInt();
        int c_y = sc.nextInt();
        String path = sc.next();
        int num = sc.nextInt();
        while (!path.equals("стоп")) {
            if (c_x == x && c_y == y) {
                flag = false;
            }
            if (flag) {
                n++;
            }
            switch (path) {
                case "север" -> y += num;
                case "запад" -> x -= num;
                case "юг" -> y -= num;
                case "восток" -> x += num;
            }
            path = sc.next();
            if (!path.equals("стоп")) {
                num = sc.nextInt();
            }
        }
        return n;
    }

    public static int[] findMaxHeight() {
        int max_height = -1;
        int max_road = 0;
        Scanner scanner = new Scanner(System.in);
        int num_roads = Integer.parseInt(scanner.nextLine());
        for (int road = 1; road <= num_roads; road++) {
            int num_heights = Integer.parseInt(scanner.nextLine());
            int min_height = Integer.MAX_VALUE;
            for (int i = 0; i < num_heights; i++) {
                int height = Integer.parseInt(scanner.nextLine());
                min_height = Math.min(min_height, height);
            }
            if (min_height > max_height) {
                max_height = min_height;
                max_road = road;
            }
        }
        return new int[] {max_road, max_height};
    }

    public static boolean isDoubleEven(int number) {
        int sum = 0;
        int product = 1;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum % 2 == 0 && product % 2 == 0;
    }
}
