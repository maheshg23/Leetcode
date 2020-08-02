// 1041. Robot Bounded In Circle

// Faster  0ms
class Solution {
    public boolean isRobotBounded(String instructions) {

        // 0-North 1-East 2-South 3-West
        int[] dir = { 0, 1, 2, 3 };
        int x = 0, y = 0, idx = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                if (idx == dir[0])
                    y++;
                if (idx == dir[1])
                    x++;
                if (idx == dir[2])
                    y--;
                if (idx == dir[3])
                    x--;
            }
            if (ch == 'L') {
                // System.out.println(" Index before " + idx);
                if (idx == dir[0])
                    idx = dir[3];
                else if (idx == dir[1])
                    idx = dir[0];
                else if (idx == dir[2])
                    idx = dir[1];
                else if (idx == dir[3])
                    idx = dir[2];
                // System.out.println(" Index " + idx);
            }
            if (ch == 'R') {
                if (idx == dir[0])
                    idx = dir[1];
                else if (idx == dir[1])
                    idx = dir[2];
                else if (idx == dir[2])
                    idx = dir[3];
                else if (idx == dir[3])
                    idx = dir[0];
            }
            // System.out.println("x "+ x +" y "+y+" idx "+idx);
        }

        // System.out.println("x "+ x +" y "+y+" idx "+idx);
        // if (x == 0 && y == 0 ) return true;
        // if (idx != 0) return true;
        // return false;
        return (x == 0 && y == 0) || (idx != 0);
    }
}

// 1ms
class Solution {
    public boolean isRobotBounded(String instructions) {

        // 0-North 1-East 2-South 3-West
        int dir = 0;
        int x = 0, y = 0, idx = 0;
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                if (idx == 0)
                    y++;
                if (idx == 1)
                    x++;
                if (idx == 2)
                    y--;
                if (idx == 3)
                    x--;
            }
            if (ch == 'L') {
                idx = dir == 0 ? 3 : dir - 1;
            }
            if (ch == 'R') {
                idx = dir == 3 ? 0 : dir + 1;
            }
        }
        return (x == 0 && y == 0) || (idx != 0);
    }
}