package boj;/*
[ 입력 ]
첫째 줄에는 테스트케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 주어진다.
 첫째 줄에 건물의 개수 N과 건물간의 건설순서 규칙의 총 개수 K이 주어진다. (건물의 번호는 1번부터 N번까지 존재한다)

둘째 줄에는 각 건물당 건설에 걸리는 시간 D1, D2, ..., DN이 공백을 사이로 주어진다.
 셋째 줄부터 K+2줄까지 건설순서 X Y가 주어진다. (이는 건물 X를 지은 다음에 건물 Y를 짓는 것이 가능하다는 의미이다)

마지막 줄에는 백준이가 승리하기 위해 건설해야 할 건물의 번호 W가 주어진다.


[ 출력 ]
건물 W를 건설완료 하는데 드는 최소 시간을 출력한다. 편의상 건물을 짓는 명령을 내리는 데는 시간이 소요되지 않는다고 가정한다.

건설순서는 모든 건물이 건설 가능하도록 주어진다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold3_Q1005 {

    // 건설 순서를 담은 리스트
    static ArrayList<Integer>[] build;

    // 건물의 건설 시간을 담은 배열
    static int[] D;
    
    // 최종 건물
    static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        // 테스트 케이스 갯수 (T)
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++){
            // 건물 갯수 N, 건설 순서 규칙 개수 K
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 건설 시간을 담을 변수 배열 (N사이즈 + 1)
            D = new int[N+1];
            st = new StringTokenizer(br.readLine());

            // D[1] ~ D[N]
            for (int j = 1; j <= N; j++){
                D[j] = Integer.parseInt(st.nextToken());
            }

            // 인접 리스트 인스턴스 할당
            build = new ArrayList[N+1];
            for (int j = 0; j <= N; j++){
                build[j] = new ArrayList<>();
            }

            // 첫번째 건설 순서를 알기 위한 카운트
            int[] buildNo = new int[N+1];

            // 건설 순서
            for (int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                build[X].add(Y);
                buildNo[Y]++;
            }

            // 최종 건물
            W = Integer.parseInt(br.readLine());

            // 메서드 호출
            Builder(buildNo);
        }


    }
    
    // 현재까지의 건물 총 소요 시간 => 이전 건설시간 + 현재 건설시간
    static void Builder(int[] buildNo){
        Queue<Integer> queue = new LinkedList<>();

        // 현재까지의 건설 소요 시간을 담기 위한 배열
        int[] result = new int[build.length];

        // 건설 소요시간
        for (int i =1; i < D.length; i++){
            // 기본 소요시간 담기
            result[i] = D[i];

            // 첫번째 건설 순서 집어 넣기
            if (buildNo[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int building = queue.poll();

            // 연결된 건물들 소요시간 저장 (큰 값으로)
            for (Integer i : build[building]){
                result[i] = Math.max(result[i], result[building] + D[i]);
                buildNo[i]--;

                // 다음 순서 짚어 넣기
                if (buildNo[i] == 0){
                    queue.offer(i);
                }
            }
        }

        System.out.println(result[W]);
    }
}
