import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(str.nextToken());
        int c = Integer.parseInt(str.nextToken());
        // 인접노드를 인덱스에 해당하는 노드로 표현하기 위해서!
        List<List<Integer>> treeNode = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            treeNode.add(new ArrayList<>());
        }
        // 인접 노드 정보 저장하기
        for(int i = 0; i < c; i++){
            str = new StringTokenizer(br.readLine()," ");
            int e = Integer.parseInt(str.nextToken());
            int b1 = Integer.parseInt(str.nextToken());
            int b2 = Integer.parseInt(str.nextToken());

            treeNode.get(e).add(b1);
            treeNode.get(e).add(b2);
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distance[1] = 1;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            int currDistance = distance[curr];

            for(int nextNode : treeNode.get(curr)){
                if(distance[nextNode] == 0){
                    distance[nextNode] = currDistance +1;
                    queue.add(nextNode);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            bw.write(Integer.toString(distance[i]));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

}