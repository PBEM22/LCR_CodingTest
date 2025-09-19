package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 등산가 김강산은 가족들과 함께 캠핑을 떠났다. 하지만, 캠핑장에는 다음과 같은 경고문이 쓰여 있었다.
 *
 * 캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.
 *
 * 강산이는 이제 막 28일 휴가를 시작했다. 이번 휴가 기간 동안 강산이는 캠핑장을 며칠동안 사용할 수 있을까?
 *
 * 강산이는 조금 더 일반화해서 문제를 풀려고 한다.
 *
 * 캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다. 강산이는 이제 막 V일짜리 휴가를 시작했다. 강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)
 *
 */


public class Bronze1_Q4796 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L; // P일 중 사용 가능한 일수
        int P; // 연속하는 일수
        int V; // 총 휴가 일수

        int caseNumber = 1;

        while (true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            // 입력 종료 조건 (0 0 0 입력 시)
            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            // 1. V일 동안 P일짜리 기간이 몇 번 반복되는지 계산
            int fullPeriods = V / P;

            // 2. 반복되는 기간 동안 사용할 수 있는 총 일수
            int totalDays = fullPeriods * L;

            // 3. 남은 휴가 일수 계산
            int remainingDays = V % P;

            // 4. 남은 기간 동안 사용할 수 있는 일수
            // 남은 일수(remainingDays)와 최대 사용 가능 일수(L) 중 작은 값 더하기
            if (remainingDays > L) {
                totalDays += L;
            } else {
                totalDays += remainingDays;
            }

            System.out.println("Case " + caseNumber + ": " + totalDays);

            caseNumber++;
        }
    }
}
