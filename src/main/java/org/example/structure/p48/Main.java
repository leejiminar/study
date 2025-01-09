package org.example.structure.p48;

public class Main {
    public static void main(String[] args) {
        // 학생별 국어, 수학, 영어 점수 (3명의 학생)
        int[][] scores = {
                {90, 85, 88},  // 1번 학생: 국어 90, 수학 85, 영어 88
                {78, 92, 80},  // 2번 학생: 국어 78, 수학 92, 영어 80
                {85, 76, 95}   // 3번 학생: 국어 85, 수학 76, 영어 95
        };

        // 과목 이름
        String[] subjects = {"국어", "수학", "영어"};

        // 출력
        System.out.println("학생별 점수:");
        for (int i = 0; i < scores.length; i++) {
            System.out.print("학생 " + (i + 1) + ": ");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print(subjects[j] + " " + scores[i][j] + " ");
            }
            System.out.println();
        }
    }
}
