import java.util.Random;
import java.util.Scanner;

public class Task07 {

    public static int[] lottoMaker () {
        Random random = new Random();
        int[] numList = new int[6];

        for (int i = 0; i < 6; i++) {
            numList[i] = random.nextInt(45)+1;
            for (int j = 0; j < i; j++) {
                if (numList[i] == numList[j]) {
                    i--;
                    break;
                }
            }
        }
        return numList;
    }

    public static void main(String[] args) {
        System.out.println("[로또 당첨 프로그램]");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");

        // 로또 구매 수량 입력
        Scanner sc = new Scanner(System.in);
        int numOfLotto = sc.nextInt();

        // 로또 수량만큼의 크기를 가진 이중 배열 선언
        int[][] lotto = new int[numOfLotto][6];

        // 입력한 개수만큼의 로또 개수 생성
        for (int i = 0; i < numOfLotto; i++) {
            int[] newLotto = lottoMaker();
            for (int j = 0; j < 6; j++) {
                lotto[i][j] = newLotto[j];
            }
        }

        // 로또 번호 출력
        for (int i = 0; i < numOfLotto; i++) {
            System.out.printf("%c\t", (char) (i + 65));
            for (int j = 0; j < 6; j++) {
                if (j == 5) {
                    System.out.printf("%02d", lotto[i][j]);
                } else {
                    System.out.printf("%02d,", lotto[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();

        // 로또 당첨 번호
        int[] winningNum = lottoMaker();

        // 당첨 번호 출력
        System.out.println("[로또 발표]");
        System.out.printf("\t");
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                System.out.printf("%02d", winningNum[i]);
            } else {
                System.out.printf("%02d,", winningNum[i]);
            }
        }
        System.out.println();
        System.out.println();

        // 당첨 번호와 구매 로또 비교하여 숫자 일치 여부 판단
        int[] equalCnt = new int[numOfLotto];

        for (int i = 0; i < numOfLotto; i++) {
            int temp = 0;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (lotto[i][j] == winningNum[k]) {
                        temp++;
                    }
                }
            equalCnt[i] = temp;
            }
        }

        // 출력
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < numOfLotto; i++) {
            System.out.printf("%c\t", (char) (i + 65));
            for (int j = 0; j < 6; j++) {
                if (j == 5) {
                    System.out.printf("%02d", lotto[i][j]);
                } else {
                    System.out.printf("%02d,", lotto[i][j]);
                }
            }
            System.out.printf(" => %d개 일치", equalCnt[i]);
            System.out.println();
        }
    }
}