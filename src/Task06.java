import java.util.*;

public class Task06 {

    public static int getMaxIdx(int[] arr) {
        int max = arr[0];
        int maxIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    public static void main(String[] args) {
        Random rd = new Random();
        int voteAll = 0; // 총 투표수
        String[] candidate = {"이재명", "윤석열", "심상정", "안철수"};
        int[] voteCnt = {0, 0, 0, 0}; // 각 후보 투표수
        String curVoted = ""; // 현재 투표받은 후보

        // 난수 발생
        for (int i = 0; i < 10000; i++) {
            int vote = rd.nextInt(4) + 1;
            voteAll++; // 총 투표수에 ++

            // 각 후보의 투표에 ++
            switch (vote) {
                case 1 :
                    voteCnt[0]++;
                    curVoted = "이재명";
                    break;
                case 2 :
                    voteCnt[1]++;
                    curVoted = "윤석열";
                    break;
                case 3 :
                    voteCnt[2]++;
                    curVoted = "심상정";
                    break;
                case 4 :
                    voteCnt[3]++;
                    curVoted = "안철수";
                    break;
            }

            System.out.printf("[투표진행율]: %.2f%%, %d명 투표 => %s\n", (float)voteAll/100, voteAll, curVoted);
            System.out.printf("[기호:1] 이재명: %.2f%%, (투표수: %d)\n", (float)voteCnt[0]/100, voteCnt[0]);
            System.out.printf("[기호:2] 윤석열: %.2f%%, (투표수: %d)\n", (float)voteCnt[1]/100, voteCnt[1]);
            System.out.printf("[기호:3] 심상정: %.2f%%, (투표수: %d)\n", (float)voteCnt[2]/100, voteCnt[2]);
            System.out.printf("[기호:4] 안철수: %.2f%%, (투표수: %d)\n", (float)voteCnt[3]/100, voteCnt[3]);
        }
        //동률 예외처리
        List<Integer> numList = Arrays.asList(voteCnt[0], voteCnt[1], voteCnt[2], voteCnt[3]);
        Set<Integer> numSet = new HashSet<>(numList);

        if(numSet.size() != numList.size()){
            System.out.println("동률 발생!");
        }

        int maxIdx = getMaxIdx(voteCnt);
        String elected = candidate[maxIdx];

        System.out.printf("[투표결과] 당선인: %s", elected);
    }
}