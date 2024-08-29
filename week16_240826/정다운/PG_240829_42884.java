package programmers;

import java.util.*;

public class PG42884 {

        public static int solution(int[][] routes) {

            Arrays.sort(routes, (c1, c2) -> {
                return c1[1] - c2[1];
            });

            int answer = 0;
            int flag = Integer.MIN_VALUE;

            for(int i = 0; i < routes.length; i++) {
                if(flag < routes[i][0]) {
                    answer++;
                    flag = routes[i][1];
                }

            }

            return answer == 0 ? 1 : answer;
        }
    }

