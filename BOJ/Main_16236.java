import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
	
	static class Node {
		int x, y, time;
		
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int N, size, time;
	static int map[][];
	static ArrayList<Node> fish;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
	
		int sharkx = 0;
		int sharky = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sharkx = i;
					sharky = j;
					map[i][j] = 0;
				}
			}
		}
		
		size = 2;	//상어 사이즈
		int count = 0;
		
		while(true) {
			fish = new ArrayList<Node>();	//먹이 리스트
			Queue<Node> queue = new LinkedList<>();	//bfs
			boolean visited[][] = new boolean[N][N];
			queue.offer(new Node(sharkx, sharky, 0)); //상어위치
			visited[sharkx][sharky] = true;
			
			while(!queue.isEmpty()) {
				Node shark = queue.poll();
				
				for(int idx = 0; idx<4; idx++) {	//상 하 좌 우
					int nx = shark.x + dx[idx];
					int ny = shark.y + dy[idx];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(visited[nx][ny] == true) continue;
					
					if(map[nx][ny] >= 1 && map[nx][ny] < size) { //먹이 이면
						queue.offer(new Node(nx, ny, shark.time + 1));//상어위치 갱신
						fish.add(new Node(nx, ny, shark.time+1));//먹이 리스트 삽입
						visited[nx][ny] = true;
					}
					else if(map[nx][ny] == 0 || map[nx][ny] == size) {//지나갈수 있으면
						queue.offer(new Node(nx, ny, shark.time + 1));
						visited[nx][ny] = true;
					}
				}
				
			}
			if(fish.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Node eatfish = fish.get(0);	//물고기 먹기
			for(int i = 1; i< fish.size(); i++) {
				if(fish.get(i).time < eatfish.time) {	//가까운 물고기 
					eatfish = fish.get(i);
				}
				if(eatfish.time == fish.get(i).time) { //거리가 같은 물고기는 위쪽 우선
					if(eatfish.x > fish.get(i).x) {
						eatfish = fish.get(i);
					}
				}
			}
			
			time += eatfish.time;	
			count++;
			map[eatfish.x][eatfish.y] = 0;
			
			if(count == size) {	
				size++;
				count = 0;
			}
			
			sharkx = eatfish.x;	
			sharky = eatfish.y;
			
			
		}
			
			
		
		
	}


}
