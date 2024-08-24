import java.io.*;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] sheep;
    static boolean[][] checked;

    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            H = Integer.parseInt(st.nextToken()); //높이 입력
            W = Integer.parseInt(st.nextToken()); // 너비 입력
            sheep = new char[H][W];
            checked = new boolean[H][W];
            // 양 위치 저장하기
            for(int i = 0; i < H; i++){
                sheep[i] = br.readLine().toCharArray();
            }
            //그룹 숫자 세기
            int cnt = 0;

            for(int i = 0; i < H; i++){
                for(int j =0; j < W; j++){
                    if(sheep[i][j]=='#' && !checked[i][j]){
                        cnt++;
                        dfs(i,j);
                    }
                }
            }
            bw.write(cnt+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
    static void dfs(int row, int col){
        checked[row][col] = true;
        for(int i = 0; i < 4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            // 새 x좌표가 0이상 R미만이고, 새 y좌표가  0이상 C미만이고
            // 목표지의 좌표가 0이상이고 아직 방문하지 않은 목초지일 경우에 부합할때에만
            // dfs 재귀함수를 실행
            if(newRow >= 0 && newRow < H && newCol >= 0 && newCol < W
                    && sheep[newRow][newCol] == '#' && !checked[newRow][newCol]){
                dfs(newRow,newCol);
            }
        }
    }
}
