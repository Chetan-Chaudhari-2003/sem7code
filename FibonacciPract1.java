import java.util.Scanner;

public class FibonacciPract1 {
    // Step count for iterative calculation
    private static int iterativeSteps = 0;

    // Step count for recursive calculation
    private static int recursiveSteps = 0;

    // Iterative approach to calculate Fibonacci
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1, fib = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
            iterativeSteps++;
        }
        return fib;
    }

    // Recursive approach to calculate Fibonacci
    public static int fibonacciRecursive(int n) {
        recursiveSteps++;
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the position of the Fibonacci number to calculate: ");
        int position = scanner.nextInt();
        
        // Calculate using iterative method
        int fibIterative = fibonacciIterative(position);
        System.out.println("Fibonacci number at position " + position + " (Iterative): " + fibIterative);
        System.out.println("Number of steps (Iterative): " + iterativeSteps);

        // Reset steps for recursive calculation
        recursiveSteps = 0;

        // Calculate using recursive method
        int fibRecursive = fibonacciRecursive(position);
        System.out.println("Fibonacci number at position " + position + " (Recursive): " + fibRecursive);
        System.out.println("Number of steps (Recursive): " + recursiveSteps);

        scanner.close();
    }
}
