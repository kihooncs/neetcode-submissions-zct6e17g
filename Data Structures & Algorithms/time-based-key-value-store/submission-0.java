class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map; 

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        } else {
            List<Pair<Integer, String>> lst = map.get(key);
            int l = 0;
            int r = lst.size() - 1;
            String result = "";
            while (l <= r) {
                int mid = l + (r - l) / 2;
                Pair<Integer, String> pair = lst.get(mid);
                if (pair.getKey() <= timestamp) {
                    result = pair.getValue();
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return result;
        }
        
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
