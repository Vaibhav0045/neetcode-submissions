class Solution {
    class Node{
        int k;
        int p;

        Node(int k, int p){
            this.k = k;
            this.p = p;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(b.p,a.p));
        int[] ans = new int[k];

        for(int x: nums){
            freq.put(x, freq.getOrDefault(x,0)+1);
        }

        for(int key: freq.keySet()){
            pq.offer(new Node(key, freq.get(key)));
        }

        for(int i=0; i<k; i++){
            Node temp = pq.poll();
            ans[i] = temp.k;
        }

        return ans;
    }
}
