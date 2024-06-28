import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 방 보관하는 리스트 생성
        LinkedList<Room> roomList = new LinkedList<>();
        
        for(int i = 0; i < p; i++)
        {
            // 입력
            st = new StringTokenizer(br.readLine());
            Player noob = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            // 들어갈 수 있는 방 찾기
            boolean foundRoom = false;
            for (Room room : roomList)
            {
                if (room.addPlayer(noob) == true)
                {
                    // 방 들어갈 수 있음
                    foundRoom = true;
                    break;
                }
            }

            // 방 들어갈 수 없음
            if (foundRoom == false)
            {
                // 방 생성 + 방 들어감
                Room newRoom = new Room(noob.getLevel());
                newRoom.addPlayer(noob);
                roomList.add(newRoom);
            }
        }

        for(Room room : roomList)
        {
            bw.write(room.printStatus());
        }
        bw.close();
    }
    
    static class Room
    {
        int level;
        int cnt;
        LinkedList<Player> room;

        Room(int level)
        {
            this.level = level;
            this.cnt = 0;
            this.room = new LinkedList<>();
        }

        public int getCnt()
        {
            return (cnt);
        }

        public boolean addPlayer(Player newPlayer)
        {
            int playerLv = newPlayer.getLevel();
            if (level - 10 <= playerLv && playerLv <= level + 10)
            {
                if (cnt < m)
                {
                    room.add(newPlayer);
                    cnt++;
                    return (true);
                }
                return (false);
            }
            return (false);
        }

        public String printStatus()
        {
            String res = "";
            if (cnt == m)
            {
                res += "Started!\n";
            }
            else
            {
                res += "Waiting!\n";
            }
            Collections.sort(room, new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2)
                {
                    return (p1.getNickname().compareTo(p2.getNickname()));
                }
            });
            for(Player player : room)
            {
                res += player.getLevel() + " " + player.getNickname() + "\n";
            }
            return (res);
        }
    }

    static class Player
    {
        int level;
        String nickname;

        Player(int level, String nickname)
        {
            this.level = level;
            this.nickname = nickname;
        }

        public int getLevel()
        {
            return (level);
        }

        public String getNickname()
        {
            return (nickname);
        }
    }
}