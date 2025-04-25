import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j].charAt(0);
            }
        }

        // 시작점: (0, 0), 숫자, 연산자는 아직 없음
        dfs(0, 0, map[0][0] - '0', ' ');
        System.out.println(max + " " + min);
    }

    static void dfs(int x, int y, int value, char op) {
        if (x == N - 1 && y == N - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            char next = map[nx][ny];

            if (Character.isDigit(next)) {
                int num = next - '0';
                int newVal = value;
                if (op == '+') newVal = value + num;
                else if (op == '-') newVal = value - num;
                else if (op == '*') newVal = value * num;
                dfs(nx, ny, newVal, ' ');
            } else {
                dfs(nx, ny, value, next);  // 연산자는 op로 저장
            }
        }
    }
}
