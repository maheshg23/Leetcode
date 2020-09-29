// 937. Reorder Data in Log Files

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            int idx = logs[i].indexOf(" ");
            if (Character.isDigit(logs[i].charAt(idx + 1))) {
                digitLogs.add(logs[i]);
            } else {
                letterLogs.add(logs[i].substring(idx + 1) + " " + logs[i].substring(0, idx));
            }
        }
        Collections.sort(letterLogs);
        for (int i = 0; i < logs.length; i++) {
            if (i < letterLogs.size()) {
                int idx = letterLogs.get(i).lastIndexOf(" ");
                logs[i] = letterLogs.get(i).substring(idx + 1) + " " + letterLogs.get(i).substring(0, idx);
            } else {
                logs[i] = digitLogs.get(i - letterLogs.size());
            }
        }
        return logs;
    }
}