import java.util.Scanner;
public class exp6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt(), sum = 0, temp = n;
        while (temp > 0) {
            int d = temp % 10;
            int f = 1;
            for (int i = 2; i <= d; i++) f *= i;
            sum += f;
            temp /= 10;
        }
        System.out.println(sum == n ? "Strong Number" : "Not a Strong Number");
        sc.close();
    }
}