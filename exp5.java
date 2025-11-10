import java.util.Scanner;
public class exp5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int count=0;
        if (n <= 1){
            count=count+1;
        }
        else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    count=count+1;
                }
            }
        }
        if (count<=1)
            System.out.println("Prime.");
        else
            System.out.println("not Prime.");
            sc.close();
    }
}
