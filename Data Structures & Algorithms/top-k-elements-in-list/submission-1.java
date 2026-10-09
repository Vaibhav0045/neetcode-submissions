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
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.p,b.p));
        int[] ans = new int[k];

        for(int x: nums){
            freq.put(x, freq.getOrDefault(x,0)+1);
        }

        for(int key: freq.keySet()){
            if(pq.size()<k) pq.offer(new Node(key, freq.get(key)));
            else{
                Node temp = pq.peek();
                if(temp.p < freq.get(key)){
                    pq.poll();
                    pq.offer(new Node(key, freq.get(key)));
                }
            }
        }

        int i=0;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            ans[i++] = temp.k;
        }

        return ans;
    }
}
