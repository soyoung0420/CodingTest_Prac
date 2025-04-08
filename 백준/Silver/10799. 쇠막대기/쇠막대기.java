import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
// 쇠막대기
/*
* 입력 : 쇠막대기와 레이저의 배치를 나타내는 괄호 표현 공백없이. 최대 100,000
*
* 출력 : 잘려진 조각의 총 개수
*
* 로직 :
* 1. 레이저는 () 괄호의 쌍으로 표현, 모든 () 는 반드시 레이저
* 2. 쇠막대기 왼쪽 끝 : (  , 오른쪽 끝 : )
* 3. 레이저는 어떤 쇠막대기의 양 끝과 겹치지 않음
* 4. 쇠막대기 다른 쇠막대기에 완전 포함되도록 놓임, 끝점은 겹치지 않음
*
* 풀이
* 레이저로 시작한다면, 아직 쪼개지지 않음
* 막대의 개수와 위치를 알고, 막대의 내부에 몇개의 레이저가 존재하는지를 알면
* 각 막대가 어떻게 쪼개졌는지를 알 수 있지 않을까? n개의 레이저를 쏘면 n+1 개의 조각 생성
* */
public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        int lazer = 0; // 레이저 개수
        int cnt = 0; // 조각 개수

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            } else {
                if(s.charAt(i-1) == '('){
                    stack.pop(); // 레이저 이므로 빼주기
                    cnt += stack.size(); // 막대기가 시작되니까 stack의 사이즈가 바로 막대의 개수가 된다.
                    // (( 이면 막대기 2개, ((((이면 막대기가 3개
                } else if(s.charAt(i-1)!='('){
                    cnt +=1;
                    stack.pop();
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();

    }

}
