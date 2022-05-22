import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Task05 {
    static int[] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int getStartDay(int year, int month) {
        // 해당 월 시작요일
        LocalDate firstDay = LocalDate.of(year, month, 1);
        DayOfWeek dayOfWeek = firstDay.getDayOfWeek();
        int startDay = dayOfWeek.getValue();
        return startDay;
    }

    public static void isLeapYear(int year, int month) {
        // 윤년체크
        LocalDate ld = LocalDate.of(year, month, 1);
        boolean leapYear = ld.isLeapYear();
        if (leapYear) {
            lastDay[2] = 29;
        }
    }

    public static void makeCalendar (int startDay, int month) {
        // 달력 그리기
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n", "일", "월", "화", "수", "목", "금", "토");

        for (int i = 0; i < startDay; i++) {
            if (startDay == 7) {
                startDay = 0;
                break;
            }
            System.out.printf("\t");
        }

        int day = startDay;

        for (int i = 1; i < lastDay[month-1] + 1; i++) {
            System.out.printf("%02d\t", i);
            day++;
            if (day == 7) {
                System.out.println();
                day = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();

        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        int startDay = getStartDay(year, month);
        isLeapYear(year, month);
        makeCalendar(startDay, month);
    }
}