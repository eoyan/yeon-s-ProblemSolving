import java.io.*;
import java.math.BigInteger;

// 접근 : 동쪽의 다리 M 개 중에서 서쪽에 있는 다리 개수인 N개 만큼을 순서 상관 없이 선택 하는 경우의 수
        
// '순서 상관 없이 고른다'의 의미 : A와 B를 고르는 경우와 B와 A를 고르는 경우를 동일시.
// 반례 (순서가 중요한 경우가 존재함) : A, B, C 3개 좌석 중 A와 B를 골랐지만 a가 A 또는 B에 앉을 수 있는 것 (=다른 경우로 봐야 함)
// 이항계수 공식 [ M! / N! * (M - N)! ] 을 사용하여 해결

public class Main {

    public static BigInteger factorial(int n) {
        if(n == 1 || n == 0) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }

    public static BigInteger countBridge(int N, int M) { // 연산 결과 중 int 자료형을 초과함
        BigInteger result = factorial(M).divide( factorial(N).multiply( factorial(M - N) ) );
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            BigInteger result = countBridge(N, M);
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}