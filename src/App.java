import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int flag = 1;
        do {
            System.out.println("Welcome to Calculator!\n");
            System.out.println("Enter type of mathematical operation\n");
            System.out.println("1.Addition\n");
            System.out.println("2.Subtraction\n");
            System.out.println("3.Division\n");
            System.out.println("4.Multiplication\n");
            System.out.println("5.Exit\n");

            int choice, number_1 = 0, number_2 = 0, result = 0;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            if(choice >0 && choice < 5) {
                System.out.println("Enter first number\n");
                number_1 = scanner.nextInt();
                System.out.println("Enter second number\n");
                number_2 = scanner.nextInt();
            }

            switch (choice) {
                case 1:
                    result = number_1 + number_2;
                    break;
                case 2:
                    result = number_1 - number_2;
                    break;
                case 3:
                    result = number_1 / number_2;
                    break;
                case 4:
                    result = number_1 * number_2;
                    break;
                case 5:
                    flag = 0;
                    break;
                default:
                    System.out.println("Try again\n");
                    break;
            }
            if(flag == 1)
            System.out.println("Result is " + result);
        }while(flag == 1);
    }
}
