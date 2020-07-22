// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
// 1344. Angle Between Hands of a Clock

class Solution {
    public double angleClock(int hour, int minutes) {
        double hour1 = 360 / 12;
        double min1 = 360 / 60;
        double a = (hour * hour1) % 360 + minutes * (hour1 / 60);
        double b = minutes * min1;
        // System.out.println(a);
        // System.out.println(b);
        double res = 0;
        if (b - a > 180 || a - b > 180) {
            b = b > 180 ? 360 - b : b;
            a = a > 180 ? 360 - a : a;
            res = b + a;
        } else {
            // b = b > 180 ? 360 - b : b;
            res = b - a < 0 ? a - b : b - a;
        }
        return res;
    }
}

// Optimal Solution
class Solution {
    public double angleClock(int hour, int minutes) {
        // Every hour, hour hand 30 degree( 360 / 12 = 30 )
        // Every minute, minute hand 6 degree( 360 / 60 = 6 )
        // Every minute, hour hand 0.5 degree( (360 / 12) / 60 = 0.5)

        double a = (hour * 30) % 360 + (double) (minutes * 30) / 60;
        double b = minutes * 6;
        // System.out.println(a);
        // System.out.println(b);
        double res = Math.abs(b - a);
        if (res > 180) {
            res = 360 - res;
        }
        return res;
    }
}
