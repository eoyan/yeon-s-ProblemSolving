import java.io.*;

// 문제의 핵심 트릭
// 창문을 토글 할때에 홀수 번으로 토글된 창문만 최종 상태가 바뀜.
// 즉 창문들의 초기상태가 다 닫혀 (0.0.0...) 있으므로 마지막에 열려있는 창문은 
// 자신을 배수로 가지는 수(= 약수)들이 홀수 개가 존재했다는 것.
// N 이하에서 홀수개의 약수를 가지는 수는 완전제곱수 (X * X <= N) 이다. 
// 1, 4, 9, 16..
// 따라서 N 이하의 완전제곱수의 개수를 구하면 된다. 
// N이 10일때 10이하의 수 중 제곱하여 10을 넘기지 않는 수는 3이 최대이므로 3개가 정답이다
// 1*1, 2*2, 3*3.. 등으로 이루어져있으므로 n*n 이하의 수는 n개 있을것이다.
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int N = Integer.parseInt(br.readLine());
        int result = (int) Math.sqrt(N);
        // N까지의 제곱수 개수를 출력
        bw.write(result + "\n");
        

        bw.flush();
        br.close();
        bw.close();
    }
}