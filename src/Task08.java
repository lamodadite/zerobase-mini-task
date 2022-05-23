import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");

        int[] taxRateSection = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000, };
        int[] taxRate = {6, 15, 24, 35, 38, 40, 42, 45};

        Scanner sc = new Scanner(System.in);
        int income = sc.nextInt(); // 소득 입력
        int sum = 0; // 총 세금

        for (int i = 0; i < taxRate.length-1; i++) {
            if (i == 0) {
                if (income > taxRateSection[0]) {
                    income -= taxRateSection[0];
                    sum += (taxRateSection[0] * taxRate[0]) / 100;
                    System.out.printf("%10d * %2d%% = %10d\n", taxRateSection[0], taxRate[0], taxRateSection[0] * taxRate[0] / 100);
                    continue;
                } else {
                    sum += income * taxRate[0] / 100;
                    System.out.printf("%10d * %2d%% = %10d\n", income, taxRate[0], income * taxRate[0] / 100);
                    break;
                }
            }

            if (income > taxRateSection[i] - taxRateSection[i - 1]) {
                income -= (taxRateSection[i] - taxRateSection[i - 1]);
                sum += (taxRateSection[i] - taxRateSection[i - 1]) * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n", taxRateSection[i] - taxRateSection[i - 1], taxRate[i], (taxRateSection[i] - taxRateSection[i - 1]) * taxRate[i] / 100);
            } else {
                sum += income * taxRate[i] / 100;
                System.out.printf("%10d * %2d%% = %10d\n", income, taxRate[i], income * taxRate[i] / 100);
                income = 0;
                break;
            }
        }
        if (income > 0) {
            sum += (income * taxRate[taxRate.length-1]) / 100;
            System.out.printf("%10d * %2d%% = %10d\n", income, taxRate[taxRate.length-1], income * taxRate[taxRate.length-1] / 100);
        }

        System.out.println(sum);
    }
}
