package org.example;

import java.util.*;

public class Memo {
    public static void main(String[] args) {
    }
}
//
//        03번 저장소 만들기
//# Git 명령을 채점하기 위한 편집창입니다.
//# 문제를 풀기 위해 필요한 명령을 아래에 입력하세요.
//# 여러 개의 명령은 한 줄에 하나씩 입력하면 됩니다.
//
//# myproject로 먼저 이동후에 git init 명령을 수행해주세요.
//                cd myproject
//        git init
//
//# main.py를 myproject디렉토리 안에 생성한 후에 print('Hello,Git')을 작성해주세요.
//        echo "print('Hello, Git')" > main.py
//
//# 저장소에 add와 commit명령을 이용하여 커밋을 완료해주세요. 커밋 메세지는 채점에 영향을 끼치지 않습니다.
//        git add "main.py"
//        git commit -m "init"
//
//
//
//
//
//        04 쇼핑 목록 관리
//package elice;
//
//import java.util.LinkedList;
//import java.util.Scanner;
//
//        public class Main {
//            public static void main(String args[]) {
//                //여기에 코드를 작성해주세요.
//                Scanner scanner = new Scanner(System.in);
//                // 첫 번째 줄에는 두 개의 정수가 공백을 사이에 두고 주어집니다.
//                int n = scanner.nextInt(); // 쇼핑 아이템 종류
//                int m = scanner.nextInt(); // 쇼핑 이벤트 수
//                scanner.nextLine();  // 줄바꿈 없애기
//
//                LinkedList<String> shoppingList = new LinkedList<>();
//
//                for (int i = 0; i < m; i++) {
//                    String command = scanner.nextLine();
//
//                    // 이벤트는    1.add [아이템 이름]    또는     2.remove    입니다.
//                    if (command.startsWith("add")) { // add [아이템 이름] 이벤트는 해당 아이템을 쇼핑 목록에 추가합니다.
//                /*
//                String[] arr = command.split(" ");
//                String f = arr[1];
//                shoppingList.add(f);
//                */
//                        shoppingList.add(command.split(" ")[1]);
//                    } else if (command.equals("remove")) { // remove 이벤트는 가장 최근에 추가된 아이템을 쇼핑 목록에서 삭제합니다.
//                        if (!shoppingList.isEmpty()) {
//                            shoppingList.removeLast();
//                        }
//                    }
//                }
//
//                // 모든 이벤트가 처리된 후에는 쇼핑 목록에 남아 있는 아이템을 출력합니다. 아이템은 추가된 순서대로 출력합니다.
//                for (String item : shoppingList) {
//                    System.out.println(item);
//                }
//            }
//        }
//
//
//
//
//
//        05 도서 리뷰 관리
//package elice;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//        public class BookAnalyzer {
//            public static double calculateAverageRating(List<Book> books) {
//                // 지시 사항을 참고하여 코드를 작성해 보세요.
//                return books.stream()
//                        .flatMap(book -> book.getReviews().stream())
//                        .mapToInt(Review::getRating)
//                        .average()
//                        .orElse(0.0);
//            }
//
//            public static List<Book> findBooksWithRatingAbove(List<Book> books, int rating) {
//                // 지시 사항을 참고하여 코드를 작성해 보세요.
//                return books.stream()
//                        .filter(book -> book.getReviews().stream()
//                                .mapToInt(Review::getRating)
//                                .average()
//                                .orElse(0.0) >= rating)
//                        .collect(Collectors.toList());
//            }
//
//    /*
//    public static double calculateAverageRating(List<Book> books) {
//        // 지시 사항을 참고하여 코드를 작성해 보세요.
//        int sum = 0;
//        int cnt = 0;
//        double avg = 0;
//
//        for(int i=0; i<books.size(); i++) {
//            Book book = books.get(i);
//            List<Review> reviews = book.getReviews();
//
//            for(int j=0; j<reviews.size(); j++) {
//                sum += reviews.get(j).getRating();
//            }
//            cnt += reviews.size();
//        }
//
//        avg = sum / cnt;
//
//        return avg;
//    }
//
//    public static List<Book> findBooksWithRatingAbove(List<Book> books, int rating) {
//        // 지시 사항을 참고하여 코드를 작성해 보세요.
//        List<Book> aboveBooks = new ArrayList<>();
//
//        for(int i=0; i<books.size(); i++) {
//            Book book = books.get(i);
//            List<Review> reviews = book.getReviews();
//            int sum = 0;
//
//            for(int j=0; j<reviews.size(); j++) {
//                sum += reviews.get(j).getRating();
//            }
//
//            if((sum / reviews.size()) >= rating) {
//                aboveBooks.add(book);
//            }
//        }
//
//        return aboveBooks;
//    }
//    */
//        }
//
//
//
//
//
//        06 수강 신청
//package elice;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//
//        public class Main {
//            public static void main(String[] args) {
//                // 이 곳에 정답 코드를 작성해 주세요.
//                Scanner sc = new Scanner(System.in);
//
//                int lectureSize = sc.nextInt(); // 첫 번째 정수는 수업을 수강할 수 있는 총 수강생의 수
//                int logLength = sc.nextInt();   // 두 번째 정수는 수강 신청 로그에 남아있는 수강생 ID의 개수
//                // 두 번째 줄에는 수강생의 ID가 공백을 기준으로 Integer 범위의 양의 정수로 주어집니다.
//                // 이는 수강 로그에 남아있는 수강생의 ID를 의미하고, 시간 순서대로 주어집니다.
//
//                Set<Integer> set = new HashSet<>();
//
//                for (int i = 0; i < logLength; i++) {
//                    if (set.size() < lectureSize) {
//                        set.add(sc.nextInt());
//                    }
//                }
//
//                List<Integer> list = new ArrayList<>(set); // 수강 신청에 성공한 수강생
//                list.sort(Comparator.naturalOrder());
//
//                System.out.println(list); // ID 목록이 List 형태로 출력됩니다.
//            }
//        }
//
//
//
//
//
//
//        07 게임 아이템 관리
//package elice;
//
//import java.util.Map;
//import java.util.Scanner;
//import java.util.TreeMap;
//
//        public class Main {
//            public static void main(String args[]) {
//                Scanner scanner = new Scanner(System.in);
//                // 1. 첫 번째 줄에는 두 개의 정수가 공백을 사이에 두고 주어집니다.
//                int itemCount = scanner.nextInt(); // 첫 번째 정수 itemCount는 아이템의 종류 수를 의미하며,
//                int logCount = scanner.nextInt();  // 두 번째 정수 logCount는 액션 로그에 기록된 행동의 개수를 의미합니다.
//                scanner.nextLine();
//
//                // 여기에 코드를 작성해주세요.
//                Map<String, Integer> itemMap = new TreeMap<>(); // String -  Key  : 아이템 이름
//                // Integer - Value: 아이템 수량
//                // TreeMap - 알파벳 순서대로 아이템을 출력
//
//                for (int i = 0; i < logCount; i++) { // 그 다음 줄부터 logCount 만큼의 줄이 주어집니다.
//                    // 각 로그를 " "으로 분리하여 아이템의 이름과 액션을 분리한다.
//                    String[] log = scanner.nextLine().split(" ");
//                    String item = log[0];
//                    String action = log[1];
//
//                    // 액션이 "acquire"인 경우, 해당 아이템의 수량을 1 증가시킨다.
//                    // getOrDefault() 메서드를 사용하여 아이템이 Map에 없는 경우 기본값 0을 반환하도록 한다.
//                    if (action.equals("acquire")) {
//                        itemMap.put(item, itemMap.getOrDefault(item, 0) + 1);
//                    }
//                    // 액션이 "use"인 경우, 해당 아이템의 수량을 1 감소시킨다.
//                    // getOrDefault() 메서드를 사용하여 아이템이 Map에 없는 경우 기본값 0을 반환하도록 한다.
//                    else if (action.equals("use")) {
//                        itemMap.put(item, itemMap.getOrDefault(item, 0) - 1);
//                    }
//                }
//
//                // 모든 액션을 처리한 후, 아이템과 각 아이템의 수량을 출력한다.
//                System.out.println(itemMap);
//            }
//        }
//
//        List<Integer> list = new ArrayList<>();
//
//        for(int i = 0; i < a; i++) {
//            list.add(set.stream().toList().get(i));
//        }
//
//        System.out.println(list);
//    }
//}
//
//
