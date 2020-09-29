// 118. Pascal's Triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> rowlist = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (i == j || j == 0)
                    list.add(1);
                else {
                    list.add(rowlist.get(j - 1) + rowlist.get(j));
                }
            }
            rowlist = list;
            res.add(list);
        }
        return res;
    }
}
