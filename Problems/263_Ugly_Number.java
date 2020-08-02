// 263. Ugly Number

class Solution {
    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        while (num != 1) {
            if (num % 2 == 0)
                num = num / 2;
            else if (num % 3 == 0)
                num = num / 3;
            else if (num % 5 == 0)
                num = num / 5;
            else
                return false;
        }
        return true;
    }
}

class Solution {
    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        for (int i = 2; i < 6; i++) {
            while (num % i == 0)
                num = num / i;
        }
        return num == 1;
    }
}

class Solution {
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;
        while ((num % 2) == 0)
            num /= 2;
        while ((num % 3) == 0)
            num /= 3;
        while ((num % 5) == 0)
            num /= 5;
        return num == 1;
    }
}