import java.util.Scanner;

public class Task07 {

    public static void lottoMaker (int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
        }




    }

    public static void main(String[] args) {
        System.out.println("[로또 당첨 프로그램]");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");

        // 로또 구매 수량 입력
        Scanner sc = new Scanner(System.in);
        int numOfLotto = sc.nextInt();

        // 입력한 개수만큼의 로또 개수 생성
        lottoMaker(numOfLotto);

    }
}