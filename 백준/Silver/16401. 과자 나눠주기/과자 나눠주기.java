import java.util.*;
import java.io.*;
public class Main {

    /***
     * 입력 : 첫째 줄 - 조카의 수 M, 과자의 수 N
     *        둘째 줄 - 과자 N개의 길이, 길이는 1 ≤ L1, L2, ..., LN ≤ 1,000,000,000
     *
     * 로직 : 모든 조카에게 같은 길이 제공, 여러 조각 나눌 수 있음, 과자를 하나로 합칠 순 없다.
     *        1. 모든 조각을 합쳐서 나눈 몫이 가장 큰 값 찾기.
     *        2. 그 값이 가장 큰 조각 순서로 나열 후, 큰 수부터 차례로 나누어 몫의 합이 인원수가 되는지.
     *        3. 만약 그게 안된다면, 0을 출력할것
     *
     *
     *
     * 출력 : 조카 1명에게 줄 수 있는 막대과자 최대 길이, 단, 같은 길이가 불가하다면 0
     */
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cookies = new int[n];
        for(int i = 0; i < n; i++){
            cookies[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cookies);

        // 막대 과자의 최대 길이를 구하기 위한 이분탐색
        long left = 1; // 왼쪽 끝
        long right = cookies[n-1]; // 오른쪽 끝
        long result = 0;
        while(left <=right){
            int cnt = 0;
            long mid = (right+left)/2; // 중간지점 찾기

            // 특정 쿠키 사이즈 mid로 나누었을 때 몇명에게 가능한지 확인
            for(int i = 0; i < n; i++){
                cnt += cookies[i]/mid;
            }
            // 조카의 수보다 막대과자가 많으면 해당 길이만큼 나누는 것이 가능
            // 반복을 통해 범위를 좁히고, 최대 과자 길이를 찾을 수 있다.
            if(cnt >= m){
                if(result < mid){
                    result = mid;
                    left = mid+1;
                }
            }else{
                right = mid -1;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }
}
