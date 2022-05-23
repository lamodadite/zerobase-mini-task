import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");

        int[] taxRateSection = {12000000, 34000000, 42000000, 62000000, 150000000, 200000000, 500000000, 1000000000};
        int[] taxRate = {6, 15, 24, 35, 38, 40, 42, 45};

        Scanner sc = new Scanner(System.in);
        int income = sc.nextInt(); // 소득 입력
        int sum = 0; // 총 세금

        // 세금 계산 시작
        for (int i = 0; i < taxRate.length; i++) {
            if (income > taxRateSection[i]) {
                income -= taxRateSection[i];
                sum += (taxRateSection[i] / 100) * taxRate[i];
                System.out.printf("%10d * %2d%% = %10d\n", taxRateSection[i], taxRate[i], (taxRateSection[i] / 100) * taxRate[i]);
            } else {
                sum += income / 100 * taxRate[i] ;
                System.out.printf("%10d * %2d%% = %10d\n", income, taxRate[i], income / 100 * taxRate[i] );
                income = 0;
                break;
            }
        }

        // 소득이 1,000,000,000원을 넘어갈 경우
        if (income > 0) {
            sum += (income / 100) * taxRate[taxRate.length-1];
            System.out.printf("%10d * %2d%% = %10d\n", income, taxRate[taxRate.length-1], income / 100 * taxRate[taxRate.length-1]);
        }

        System.out.println();
        System.out.printf("[세율에 의한 세금]:\t\t%12d\n",sum);
        System.out.printf("[누진공제 계산에 의한 세금]:%13d",sum);
    }
}
