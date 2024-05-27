import java.io.*;
import java.util.*;


class Main {
	static int N, M, K;
	static int[][] dir = new int[][] {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static Object[][][] map;
	
	static class fireball {
		int mass, speed, dir;
		public fireball(int mass, int speed, int dir) {
			this.mass = mass;
			this.speed = speed;
			this.dir = dir;
		}
	}
	static class mixed {
		int mass, speed, count, dir;
		boolean isSameDir;
		public mixed(int mass, int speed, int dir, boolean isSameDir) {
			this.mass = mass;
			this.speed = speed;
			this.isSameDir = isSameDir;
			this.dir = dir;
			this.count = 2;
		}
	}
	static void insertFireball(fireball fb, int nx, int ny, int t) {
		if (map[nx][ny][t+1] == null) {
			map[nx][ny][t+1] = fb;
		}
		else if (map[nx][ny][t+1] instanceof fireball){
			fireball fb2 = (fireball) map[nx][ny][t+1];
			boolean isSameDir = fb.dir % 2 == fb2.dir % 2;
			map[nx][ny][t+1] = new mixed(fb.mass + fb2.mass, fb.speed + fb2.speed, fb.dir, isSameDir);
		}
		else { // map[nx][ny][t+1] instanceof mixed
			mixed mx = (mixed) map[nx][ny][t+1];
			mx.mass += fb.mass;
			mx.speed += fb.speed;
			mx.count++;
			if (mx.isSameDir) {
				mx.isSameDir = mx.dir % 2 == fb.dir % 2;
			}
		} 
	}

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Object[N][N][K+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int mass = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			map[--row][--col][0]= new fireball(mass, speed, dir);
		}
		
		for (int t = 0; t < K; t++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][t] == null) continue;
					
					if (map[i][j][t] instanceof fireball) {
						fireball fb = (fireball) map[i][j][t];
//						System.out.println(i + " " + j);
						int nx = i + (fb.speed % N) * dir[fb.dir][0];
						int ny = j + (fb.speed % N) * dir[fb.dir][1];
						nx += N;
						ny += N;
						nx %= N;
						ny %= N;
//						System.out.println(nx + " " + ny);
						insertFireball(fb, nx, ny, t);
//						if (map[nx][ny][t+1] == null) {
//							map[nx][ny][t+1] = map[i][j][t];
//						}
//						else if (map[nx][ny][t+1] instanceof fireball){
//							fireball fb2 = (fireball) map[nx][ny][t+1];
//							boolean isSameDir = fb.dir % 2 == fb.dir % 2;
//							map[nx][ny][t+1] = new mixed(fb.mass + fb2.mass, fb.speed + fb2.speed, fb.dir, isSameDir);
//						}
//						else { // map[nx][ny][t+1] instanceof mixed
//							mixed mx = (mixed) map[nx][ny][t+1];
//							mx.mass += fb.mass;
//							mx.speed += fb.speed;
//							if (mx.isSameDir) {
//								mx.isSameDir = mx.dir % 2 == fb.dir % 2;
//							}
//						}
					}
					else { // map[i][j][t] instanceof mixed
						mixed mx = (mixed) map[i][j][t];
						if (mx.isSameDir) {
							for (int k = 0; k < 4; k++) {
								int nx = i + (mx.speed/mx.count % N) * dir[2*k][0];
								int ny = j + (mx.speed/mx.count % N) * dir[2*k][1];
								nx += N;
								ny += N;
								nx %= N;
								ny %= N;
								if (mx.mass/5 > 0) {
									fireball fb = new fireball(mx.mass/5, mx.speed/mx.count, 2*k);
									insertFireball(fb, nx, ny, t);
								}
							}
						}
						else {
							for (int k = 0; k < 4; k++) {
								int nx = i + (mx.speed/mx.count % N) * dir[2*k+1][0];
								int ny = j + (mx.speed/mx.count % N) * dir[2*k+1][1];
								nx += N;
								ny += N;
								nx %= N;
								ny %= N;
								if (mx.mass/5 > 0) {
									fireball fb = new fireball(mx.mass/5, mx.speed/mx.count, 2*k+1);
									insertFireball(fb, nx, ny, t);
								}
							}
						}
					}
				}
				
				
			}
//			System.out.println("--------------------- turn : " + t);
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (map[i][j][t+1] instanceof fireball) {
//						fireball fb = (fireball) map[i][j][t+1];
//						System.out.print(fb.mass + " ");
//					} else if(map[i][j][t+1] instanceof mixed) {
//						mixed mx = (mixed) map[i][j][t+1];
//						System.out.print(mx.mass + " ");
//					} else {
//						System.out.print("0 ");
//					}
//				}
//				System.out.println();
//			}
			
			
			
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j][K] instanceof fireball) {
					fireball fb = (fireball) map[i][j][K];
//					System.out.println("i : "  + i +"/ j : " + j +" mass : "  + fb.mass);
					ans += fb.mass;
				} else if (map[i][j][K] instanceof mixed) {
					mixed mx = (mixed) map[i][j][K];
//					System.out.println(mx.mass/5 * 4);
					ans += mx.mass/5 * 4;
				}
			}
		}

		
		System.out.println(ans);
		
		
	}
}