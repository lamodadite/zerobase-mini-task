import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요. (금액):");
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int cashback = money/10;

        if (cashback > 300) {
            cashback = 300;
        } else {
            if (cashback >= 200) {
                cashback = 200;
            } else if (cashback >= 100 && cashback < 200) {
                cashback = 100;
            } else {
                cashback = 0;
            }
        }

        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", money, cashback);
    }
}