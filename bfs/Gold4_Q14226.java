package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Gold4_Q14226 {

    static class State {
        int monitor;
        int clip;
        int time;

        public State(int monitor, int clip, int time) {
            this.monitor = monitor;
            this.clip = clip;
            this.time = time;
        }
    }

    static boolean[][] visited;
    static int S = 0;
    static int MAX_SIZE = 2001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        // 1. 복사하기 (기존 클립보드 없어짐)
        // 2. 붙여넣기 (기존 화면에 있는 이모티콘에 추가됨)
        // 3. 이모티콘 하나 삭제 -1

        visited = new boolean[MAX_SIZE][MAX_SIZE];

        System.out.println(bfs());
    }

    static int bfs(){
        visited[1][0] = true;

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(1, 0, 0));

        while (!queue.isEmpty()){
            State poll = queue.poll();

            // 목표 달성
            if (poll.monitor == S) {
                return poll.time;
            }

            // 복사
            if (poll.monitor > 0 && poll.monitor < MAX_SIZE && !visited[poll.monitor][poll.monitor]){
                visited[poll.monitor][poll.monitor] = true;
                queue.add(new State(poll.monitor, poll.monitor, poll.time+1));
            }

            // 붙여넣기
            int newMonitor = poll.monitor + poll.clip;
            if (poll.clip > 0 && newMonitor < MAX_SIZE && !visited[newMonitor][poll.clip]) {
                visited[newMonitor][poll.clip] = true;
                queue.add(new State(newMonitor, poll.clip, poll.time+1));
            }

            // 빼기
            int minusMonitor = poll.monitor - 1;
            if (minusMonitor > 0 && minusMonitor < MAX_SIZE && !visited[minusMonitor][poll.clip]){
                visited[minusMonitor][poll.clip] = true;
                queue.add(new State(minusMonitor, poll.clip, poll.time+1));
            }
        }

        return -1;
    }
}
