import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean[] people, party;
    static int[][] partyPeople;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        people = new boolean[N];
        party = new boolean[M];
        partyPeople = new int[M][N];

        st = new StringTokenizer(br.readLine());

        // 진실 아는 사람 체크
        int len = Integer.parseInt(st.nextToken());
        for(int i = 0; i < len; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            people[num - 1] = true;
        }

        // 진실 아는 사람으로 파티에서 거짓말 할 수 있는지 여부 작성
        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            len = Integer.parseInt(st.nextToken());
            // 진실 아는 사람으로 파티 참거짓 확인
            for(int j = 0; j < len; j++)
            {
                int num = Integer.parseInt(st.nextToken());
                if (people[num - 1] == true)
                    partyPeople[i][num - 1] = 1;
                else if (people[num - 1] == false)
                    partyPeople[i][num - 1] = -1;
            }
        }

        // 진실 파티 구하기
        Queue<Integer> peopleIdx = new LinkedList<>();
        while(true)
        {
            for (int i = 0; i < M; i++)
            {
                boolean flag = false;
                for (int j = 0; j < N; j++)
                {
                    // 사람 전체 돌아
                    // 진실 아는 사람 나옴 -> 진실 파티
                    if (partyPeople[i][j] == 1)
                    {
                        flag = true;
                        break;
                    }
                }
                if (flag == true)
                {
                    // 진실파티
                        // 원래 진실 파티 -> 넘어감
                        // 아님 -> 해당 파티에 있는 사람 전부 돌면서 기존에 진실 몰랐으면 큐에 넣음
                    if (party[i] == false)
                    {
                        for (int j = 0; j < N; j++)
                        {
                            if (partyPeople[i][j] == -1)
                            {
                                partyPeople[i][j] = 1;
                                peopleIdx.add(j);
                            }
                        }
                        party[i] = true;
                    }
                }
            }
            // 큐에 사람 없다 -> 종료
            if (peopleIdx.isEmpty())
                break;
            // 큐에 사람 있다 -> 사람인덱스 하나씩 꺼내서 파티사람 돌면서 모두 체크, 사람도 체크
            int size = peopleIdx.size();
            for(int i = 0; i < size; i++)
            {
                int idx = peopleIdx.poll();
                people[idx] = true;
                for(int j = 0; j < M; j++)
                {
                    if (partyPeople[j][idx] != 0)
                        partyPeople[j][idx] = 1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < M; i++)
        {
            if (party[i] == false)
                ans++;
        }

        bw.write(ans + "");
        bw.close();
    }
}