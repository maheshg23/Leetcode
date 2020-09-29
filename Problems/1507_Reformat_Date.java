// 1507. Reformat Date

class Solution {
    public String reformatDate(String date) {
        List<String> list = Arrays.asList("", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
                "Nov", "Dec");
        String res = date.substring(date.length() - 4);
        res += "-";
        String month1 = date.substring(date.length() - 8, date.length() - 5);
        res += String.format("%02d", list.indexOf(month1));
        res += "-";
        String date1;
        if (Character.isDigit(date.charAt(1)))
            date1 = date.substring(0, 2);
        else
            date1 = date.substring(0, 1);
        res += String.format("%02d", Integer.parseInt(date1));
        return res;
    }
}

class Solution {
    public String reformatDate(String date) {
        List<String> list = new ArrayList<String>();
        String[] month = { "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        for (int i = 0; i < month.length; i++) {
            list.add(month[i]);
        }
        String[] s = date.split(" ");
        s[1] = String.format("%02d", list.indexOf(s[1]));
        if (Character.isDigit(s[0].charAt(1)))
            s[0] = String.format("%02d", Integer.parseInt(s[0].substring(0, 2)));
        else
            s[0] = String.format("%02d", Integer.parseInt(s[0].substring(0, 1)));
        return s[2] + "" + s[1] + "-" + s[0];
    }
}
