class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> hm = new HashMap<String, Integer>();
        String maxKey = new String("");
        int maxValue = 0;

        List<String> bannedList = Arrays.asList(banned);
        String[] words = paragraph.split("[ ,]+");

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[!?',;.]+", "");
            if (!bannedList.contains(word)) {
                if (hm.containsKey(word)) {
                    hm.replace(word, hm.get(word) + 1);
                } else {
                    hm.put(word, 1);
                }
                int value = hm.get(word);
                if (value > maxValue) {
                    maxValue = value;
                    maxKey = word;
                }
            }
        }
        return maxKey;
    }
}