package prog;

/*
*   문제 설명
주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때,
*  차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.
*
* 요금표
* 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
* 180	5000	10	600
*
* 입/출차 기록
* 시각(시:분)	차량 번호	내역
* 05:34	5961	입차
* 06:00	0000	입차
* 06:34	0000	출차
* 07:59	5961	출차
* 07:59	0148	입차
* 18:59	0000	입차
* 19:09	0148	출차
* 22:59	5961	입차
* 23:00	5961	출차
* */

import java.util.*;
public class ParkingCar {

        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};

            // 기본시간
            int time1 = fees[0];
            // 기본요금
            int fee1 = fees[1];
            // 단위시간
            int time2 = fees[2];
            // 단위요금
            int fee2 = fees[3];

            HashMap<String, Integer> fMap = new HashMap<String, Integer>();
            HashMap<String, Integer> sMap = new HashMap<String, Integer>();

            for(String line : records){
                String[] temp = line.split(" ");
                int reTime = getTime(temp[0]);
                String car = temp[1];
                String io = temp[2];

                if(io.equals("IN")){
                    fMap.put(car, reTime);
                } else {
                    int carTime1 = fMap.get(car);
                    fMap.remove(car);
                    if(sMap.containsKey(car)){
                        int carTime2 = sMap.get(car);
                        sMap.replace(car, carTime2 + reTime - carTime1);
                    } else {
                        sMap.put(car, reTime - carTime1);
                    }
                }
            }
            int lastTime = 1439;
            for (String car : fMap.keySet()){
                int carTime1 = fMap.get(car);
                if (sMap.containsKey(car)){
                    int carTime2 = sMap.get(car);
                    sMap.replace(car, carTime2 + lastTime - carTime1);
                } else {
                    sMap.put(car, lastTime - carTime1);
                }
            }
            Object[] sortKey = sMap.keySet().toArray(); //차 번호 순서대로 정렬
            Arrays.sort(sortKey);
            answer = new int[sortKey.length];

            for (int i = 0; i<answer.length; i++) {
                int result = fee1;
                String car = String.valueOf(sortKey[i]);

                int val = sMap.get(car);
                if (val > time1) {
                    result = (int) (fee1 + Math.ceil((double)(val-time1)/time2) * fee2);
                }
                answer[i] = result;
            }
            return answer;
        }

        static int getTime(String strTime){
            String[] times = strTime.split(":");
            int tempTime;
            tempTime = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

            return tempTime;
        }
}
