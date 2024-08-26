import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        List<Integer> nums = new ArrayList<>();
        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        int number = 1;
        while(true){
            cnt=0;
            for(int i = 0; i <nums.size(); i++){
                if(number%nums.get(i)==0){
                    cnt++;
                }
            }
            if(cnt>=3){
                break;
            }
            number++;
        }
        bw.write(Integer.toString(number));
        br.close();
        bw.flush();
        bw.close();

    }
}
