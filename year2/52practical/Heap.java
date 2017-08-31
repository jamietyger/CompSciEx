


public class Heap {
        private Node[] heap;
        private int size = 0;
        
        public int getSize() {
                return size;
        }

        public Heap(int i){
                 heap = new Node[i];
        }
                
        public void insert(Node k) {
                size++;
                int i = size;
                while(i > 1 && heap[parent(i)].getFreq() > k.getFreq()) {
                        heap[i] = heap[parent(i)];
                        i = parent(i);
                }
                heap[i] = k;
        }

        public Node getMin(){
                if(size != 0)
                        return heap[1];
                return null;
        }
        
        public Node delMin() {
                if(size != 0) {
                        Node min = heap[1];
                        heap[1] = heap[size];
                        size--;
                        heapify(1);
                        return min;
                }
                return null;
        }
        
        /**
         * Maintains the Minimum Heap Property A[PARENT (i)] <= A[i]
         * @param i root of tree
         */
        public void heapify(int i) {
        	 int l = left(i);
             int r = right(i);
             int smallest;
             
             if(l<=getSize() && heap[l].getFreq()<heap[i].getFreq()){
             	smallest = l;
             }
             else{
             	smallest = i;
             }
             
             if(r<=getSize() && heap[r].getFreq()<heap[smallest].getFreq()){
             	smallest = r;
             }
             
             if(smallest!=i){
             	swap(i,smallest);
             	heapify(smallest);
             }            
        }

        private void swap(int i, int l) {
                Node tmp = heap[i];
                heap[i] = heap[l];
                heap[l] = tmp;
        }
        
        public int parent(int i) {
                return i/2;
        }
        
        public int left(int i) {
                return 2*i;
        }
        
        public int right(int i) {
                return 2*i+1;
        }
}
