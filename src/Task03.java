import java.util.ArrayList;
import java.util.Scanner;
public class Task03 {

    public static void result (int age, int entranceTime, char nationalMerit, char welfareCard) {
        int entranceFee = 10000;

        // 나이
        if (age < 4) {
            entranceFee = 0;
        } else if (age > 3 && age < 13) {
            entranceFee = 4000;
        }
        // 입장시간
        if (entranceTime > 17) {
            entranceFee = Math.min(entranceFee, 4000);
        }
        // 국가유공자
        if (nationalMerit == 'y') {
            entranceFee = Math.min(entranceFee, 8000);
        }

        // 복지카드
        if (welfareCard == 'y') {
            entranceFee = Math.min(entranceFee, 8000);
        }

        System.out.println(entranceFee);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력해 주세요. (숫자):");
        int age = sc.nextInt();

        System.out.print("입장시간을 입력해 주세요. (숫자입력):");
        int entranceTime = sc.nextInt();

        System.out.print("국가유공자 여부를 입력해 주세요. (y/n):");
        Character nationalMerit = sc.next().charAt(0);

        System.out.print("복지카드 여부를 입력해 주세요. (y/n):");
        Character welfareCard = sc.next().charAt(0);

        System.out.print("입장료: ");

        result(age, entranceTime, nationalMerit, welfareCard);
    }
}
