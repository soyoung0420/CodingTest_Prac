import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[][] grass;
    static boolean[][] visited;

    static int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken()); // 행의 수 입력
        C = Integer.parseInt(st.nextToken()); // 열의 수 입력
        grass = new int[R][C];
        visited = new boolean[R][C];

        //목초지 정보 입력 받기
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < C; j++){
                grass[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬 개수 변수 선언
        int cnt = 0;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grass[i][j] >0 && !visited[i][j]){
                    // 재귀함수 dfs를 통해 나쁜풀들의 고도를 계속 탐색한다.
                    // 재귀함수가 종료되고 탐색이 끝나면 섬의 개수가 카운트 된다.
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        bw.write(Integer.toString(cnt));

        br.close();
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
            // 새 x좌표가 0이상 R미만이고, 새 y좌표가  0이상 C미만이고
            // 목표지의 좌표가 0이상이고 아직 방문하지 않은 목초지일 경우에 부합할때에만
            // dfs 재귀함수를 실행
            if(newRow >= 0 && newRow < R && newCol >= 0 && newCol < C
            && grass[newRow][newCol]>0 && !visited[newRow][newCol]){
                dfs(newRow,newCol);
            }
        }
    }

}
