import java.util.Scanner;

public class TokenRing {
    public static void main(String[] args) {
        int n, choice = 0, token = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes in Ring");
        n = sc.nextInt();
        if (n > 9) {
            n = 9;
        }

        while (choice == 0) {
            int sender = 10, receiver = 10;
            while (sender > n) {
                System.out.println("Enter Sender node number from 0-" + n);
                sender = sc.nextInt();
            }

            while (receiver > n) {
                System.out.println("Enter Receiver node number from 0-" + n);
                receiver = sc.nextInt();
            }
            System.out.println("Enter Data to be transmitted");
            String data = sc.next();

            System.out.println("Token Passing: ");
            System.out.print(token);
            while (token != sender) {
                token = (token + 1) % (n + 1);
                System.out.print("-->" + token);
            }

            System.out.println();
            System.out.println();
            System.out.println("----------ENTERING CRITICAL SECTION for Sender Node " + sender + "----------");
            System.out.println();

            while (token != receiver) {
                token = (token + 1) % (n + 1);
                System.out.println("Data passed to " + token);
            }

            System.out.println("Receiver " + receiver + " got message: " + data);
            System.out.println();
            System.out.println("-------------EXITING CRITICAL SECTION--------------");
            System.out.println();
            System.out.println();

            token = (token + 1) % (n + 1);

            System.out.println("To continue press 0 else enter any other number");
            choice = sc.nextInt();
        }
    }
}
