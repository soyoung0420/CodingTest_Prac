import java.util.*;
import java.io.*;

// 한국이 그리울 땐 서버에 접속하지
/**
 *[입력]
 * 1. 첫째 줄 : 파일의 개수 N
 * 2. 둘째 줄 : 파일 패턴, 문자열의 길이는 백을 넘지 않는다. * 코드의 길이는 첫번재, 마지막 제외하고 최대 98글자까지
 * 3. 그 다음 N개의 줄 : 파일의 이름, 길이는 100을 넘지 않는다.
 *
 * [출력]
 * 파일 이름이 패턴과 일치 : DA
 * 패턴과 불일치 : NE 를 출력
 *
 * [로직]
 * 1. 입력받을 파일 패턴과 다음 N개의 파일명을 비교
 * 2. 맨 앞과 마지막 글자가 일치, 글자의 길이가 100을 넘지 않아야 함.
 * 3. 비교 후 일치/ 불일치 확인
 * */
public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] parts = pattern.split("\\*");
        
        String first = parts[0];
        String last = parts[1];

        for(int i = 0; i < N; i++){
            String file = br.readLine();
            if(file.length() < first.length() + last.length() || file.length() > 100){
                bw.write("NE\n");
            }else {
                if(file.startsWith(first) && file.endsWith(last)) {
                    bw.write("DA\n");
                }else {
                    bw.write("NE\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
