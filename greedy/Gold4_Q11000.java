package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold4_Q11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 수업 개수
        int N = Integer.parseInt(br.readLine());

        // 수업을 담을 리스트
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // 리스트에 담기
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 수업 시작 시간 기준으로 정렬
        list.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        // 우선순위 큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 첫 번째 수업 종료시간 넣기
        queue.add(list.get(0)[1]);


        for (int i = 1; i < N; i++) {
            // 가장 빨리 끝나는 수업의 종료 시간과 현재 수업 시작 시간 비교
            if (queue.peek() <= list.get(i)[0]){
                // 가장 빨리 끝나는 수업을 큐에서 제거
                queue.poll();
            }

            // 현재 수업 종료 시간 큐에 추가
            queue.add(list.get(i)[1]);
        }

        System.out.println(queue.size());
    }
}
