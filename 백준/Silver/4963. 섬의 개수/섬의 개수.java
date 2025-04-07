import java.io.*;
import java.util.*;
public class Main {
    // 섬의 개수
    /**
     * 입력 : 여러개이 테스트 케이스, 첫 째줄 지도의 너비 w, h. <= 50
     *        둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다
     *        입력 마지막 줄에는 0이 두개 주어진다.
     *
     *출력 : 각 테스트 케이스에 대해 섬의 개수 출력
     *
     * 로직 : 섬은 육지가 대각선으로 연결되어 있다면 1개의 섬으롭 본다. 상, 하, 좌, 우, 대각선까지 8방향 이동 가능
     *        각각의 방문 기록에 담고 섬이 연결되어 있다면 하나의 섬으로 개수를 세어 이를 출력하면 되는 문제이다.
     * */

    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    static int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(h==0 && w==0){ break; }

            map = new int[h][w];
            visited = new boolean[h][w];

            for(int i =0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j< w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0; // 섬의 개수
            for(int i = 0; i < h; i++){
                for(int j = 0; j <w; j++){
                    if(!visited[i][j] && map[i][j] ==1){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            bw.write(cnt+"\n");



        }
        bw.flush();
        bw.close();
    }

    static void dfs(int row, int col){
        // 맨 처음 재귀함수 실행할때의 좌표를 true로 하여 시작
        visited[row][col] = true;
        // 8방향으로 이동하므로 8미만까지 반복
        for(int i = 0; i < 8; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            
            if(newRow >= 0 && newRow < h && newCol >= 0 && newCol < w
                    && map[newRow][newCol]==1 && !visited[newRow][newCol]){
                dfs(newRow,newCol);
            }
        }


    }
}
