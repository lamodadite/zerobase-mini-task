import java.util.Random;
import java.util.Scanner;

public class Task04 {

    public static int getGenderNum (int year, char gender){
        int genderNum = 0;

        if (gender == 'm') {
            if (year < 2000) {
                genderNum = 1;
            } else {
                genderNum = 3;
            }
        } else if (gender == 'f' ){
            if (year < 2000) {
                genderNum = 2;
            } else {
                genderNum = 4;
            }
        }

        return genderNum;
    }
    public static void makeIdNumber (String year, String month, String day, char gender) {
        StringBuffer front = new StringBuffer();
        StringBuffer back = new StringBuffer();
        Random random = new Random();

        front.append(year);
        front.delete(0, 2);
        front.append(month);
        front.append(day);

        back.append(getGenderNum(Integer.parseInt(year), gender));

        for (int i = 0; i < 6; i++) {
            back.append(random.nextInt(10));
        }

        System.out.println(front + "-" + back);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[주민등록번호 계산]");

        System.out.print("출생년도를 입력해 주세요.(yyyy)");
        String year = sc.next();

        System.out.print("출생월을 입력해 주세요.(mm)");
        String month = sc.next();

        System.out.print("출생일을 입력해 주세요.(dd)");
        String day = sc.next();

        System.out.print("성별을 입력해 주세요.(m/f)");
        char gender = sc.next().charAt(0);

        makeIdNumber(year, month, day, gender);
    }
}