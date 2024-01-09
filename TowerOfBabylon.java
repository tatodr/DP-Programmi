
import java.util.*;

class Block {
    int x, y, h;

    Block(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

public class TowerOfBabylon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            Block[] blocks = new Block[n * 3];
            for (int i = 0; i < n; i++) {
                int[] dim = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
                Arrays.sort(dim);
                blocks[i * 3] = new Block(dim[0], dim[1], dim[2]);
                blocks[i * 3 + 1] = new Block(dim[0], dim[2], dim[1]);
                blocks[i * 3 + 2] = new Block(dim[1], dim[2], dim[0]);
            }
            Arrays.sort(blocks, (a, b) -> a.x != b.x ? a.x - b.x : a.y - b.y);
            int[] dp = new int[n * 3];
            int max = 0;
            for (int i = 0; i < n * 3; i++) {
                dp[i] = blocks[i].h;
                for (int j = 0; j < i; j++) {
                    if (blocks[j].x < blocks[i].x && blocks[j].y < blocks[i].y) {
                        dp[i] = Math.max(dp[i], dp[j] + blocks[i].h);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println("Case " + (t++) + ": maximum height = " + max);
        }
    }
}