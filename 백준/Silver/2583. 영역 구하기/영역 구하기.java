import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static boolean[][] square;
    static boolean[][] checked;

    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static List<Integer> areas = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 배열 초기화
        square = new boolean[m][n];
        checked = new boolean[m][n];


        // 사각형의 면적을 채우기
        int x1, y1, x2, y2;
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine()," ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            fillSquare(x1, y1, x2, y2);
        }

        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!square[i][j] && !checked[i][j]){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        bw.write(Integer.toString(cnt)+"\n");
        Collections.sort(areas);
        for(int area : areas){
            bw.write(area +" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static void fillSquare(int x1, int y1, int x2, int y2){
        for(int i =m-y2; i < m-y1; i++){
            for(int j = x1; j < x2; j++){
                square[i][j] = true;
            }
        }
    }

    static void bfs(int startRow, int startCol){
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{startRow, startCol});
        checked[startRow][startCol] = true;

        while(!queue.isEmpty()){
            // 현재의 위치를 queue에서 꺼내고 정보를 담기
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for(int i = 0; i <4; i++){
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if(newRow >= 0 && newRow <m  && newCol >= 0 && newCol < n
                        && !square[newRow][newCol] && !checked[newRow][newCol]){
                    checked[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                    area++;
                }
            }

        }
        areas.add(area);
    }
}
