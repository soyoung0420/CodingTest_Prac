import java.util.*;
import java.io.*;

public class Main{
    int[] row = {1,1,1};
    int[] col = {-1, 0, 1};
    /**
     * 진우의 달 여행(Small)
     *
     * 입력 : 첫줄 - 행렬 N x M (2<=N, M <= 6)
     *        N줄 동안 각 행렬의 원소값, 100이하 자연수
     *
     * 로직 : 1. 3가지 방향으로 이동 가능 (1, -1), (1, 0), (1,1)
     *        2. 같은 방향 연속 2번 불가
     *         -행은 무조건 +1, 열은 -1, 0, 1 중 이동
     *
     *     인덱스값 확인 쉽게 행렬은 arr[n+1][m+1]로 하자
     *   - 첫번째 시작점을 기준값으로 둠,
     *   - 첫번째 열과 마지막 열은 경로 선택이 1개 뿐이다.(시작점 제외, 시작점은 2개)
     *     첫번째는 0, 1만 가능, 마지막은 -1, 0 만 가능
     *   - 두번째 열과 세번째 열은 경로 선택은 2가지이다(시작점 3개)
     *   (루프를 통해서 시작점 변동)
     *     1, m 열이면 경로 1개, 2~m-1열이면 경로 2개
     *   - dp[1] = arr[1][1]
     *      int minFuel = Max.min(arr[2][0],arr[2][1])
     *      그리고 인료의 col값을 저장하여 다음 단계에서 해당 col값에 해당되지 않는 위치로 이동하게함
     *   - dp[2] = dp[1] + Max.min(arr[2][0],arr[2][1])
     *
     *   - dp[1] = arr[1][2]
     *     dp[2] = dp[1] + Max.min(arr[2][1],arr[2][2], arr[2],[3])
     *
     *   - dp[3] = dp[2] + Max.min(
     * 출력 : 최쇠 연료의 값
     *
     * */
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] route = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <m; j++){
                route[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3가지 방향
        int[][][] dp = new int[n][m][3];
        // 범위 밖 가장 큰 숫자로 미리 채워넣기.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], 1000001);
            }
        }

        //dp에 route배열 값 담기
        for(int i = 0; i < m; i++){
            // 방향은 3가지
            for(int d = 0; d <3; d++){
                dp[0][i][d] = route[0][i];
            }
        }
        // 0 : 5시방향, 1 : 6시방향, 2: 7시방향
        for(int i =1; i<n ; i++){
            for(int j = 0; j < m ; j++){

              if(j==0){
                  dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + route[i][j];
                  dp[i][j][1] = dp[i-1][j][0] + route[i][j];
              }else if(j == m-1){
                  dp[i][j][1] = dp[i-1][j][2]+ route[i][j];
                  dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + route[i][j];
              }else{
                  dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + route[i][j];
                  dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + route[i][j];
                  dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + route[i][j];

              }
            }
        }
        int fuel = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j =0; j <3; j++){
                fuel = Math.min(fuel, dp[n-1][i][j]);
            }
        }

        bw.write(String.valueOf(fuel));
        bw.flush();
        bw.close();
    }
}
