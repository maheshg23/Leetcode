// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
// 406. Queue Reconstruction by Height

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[list.size()][]);

    }
}

// Lengthy Solution 

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, new Comparator<int[]>() {
            // @Override
            public int compare(int[] x, int[] y) {
                return x[0] == y[0] ? x[1] - y[1] : x[0] - y[0];
            }
        });
        
        int[][] res = new int[people.length][2];
        for(int i = 0; i < res.length; i++){
            res[i][0] = -1;
        }
        
        for(int i = 0; i < people.length; i++){
            int count = people[i][1];
            for(int j = 0; j < res.length; j++){       
                if(res[j][0] == -1 && count == 0){
                    res[j][0] = people[i][0];
                    res[j][1] = people[i][1];
                    break;
                }
                else if(res[j][0] == -1 || res[j][0] >= people[i][0]){
                 count--;   
                }
            }
        }
        return res; 
    }
}