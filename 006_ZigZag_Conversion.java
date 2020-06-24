class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1)
            return s;
        List<String> rows = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new String());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.set(curRow, rows.get(curRow) + c);
            if (curRow == 0 || curRow == numRows - 1)
                goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        String res = "";
        for (String row : rows)
            res = res + row;
        return res;
    }
}