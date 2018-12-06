package chap19.Compression.HuffmanNRLE;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;





public class HuffmanNNRLECompressApplication {

	public static void main(String args[]) throws IOException {
		
		/*RandomAccessFile fin = new RandomAccessFile("", "r");
		HuffmanCode.collectRuns(fin);
		fin.close();*/
		
		Heap<Run> heap = new Heap();
		Run run = new Run('A', 3, 1);
		Run run1 = new Run('C', 2, 1);
		Run run2 = new Run('A', 1, 1);
		Run run3 = new Run('B', 1, 2);
		Run run4 = new Run('A', 2, 2);
		heap.insert(run1);
		heap.insert(run);
		heap.insert(run2);
		heap.insert(run3);
		heap.insert(run4);
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		System.out.println(heap.extractMin());
		
		
	}
	
}
class HuffmanCode{
	
	private static ArrayList<Run> runs=new ArrayList<Run>();
	
	private Heap<Run> heap;
	private Run theRoot = null;
	
	private void createHuffmanTree() {
		heap= new Heap();
	}
	
	static void collectRuns(RandomAccessFile fin) throws IOException{
		
	}
	
}

class Run {
	char symbol;
	int run_length;
	int freq;
	
	
	public Run(char symbol, int run_length, int freq) {
		super();
		this.symbol = symbol;
		this.run_length = run_length;
		this.freq = freq;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public int getRun_length() {
		return run_length;
	}
	public void setRun_length(int run_length) {
		this.run_length = run_length;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	@Override
	public String toString() {
		return "Run [symbol=" + symbol + ", run_length=" + run_length + ", freq=" + freq + "]";
	}
	
	
}

//ref :::: https://gist.github.com/flexelem/70b120ac9bf2965f419f
class Heap<T extends Run>{
	private ArrayList<T> list;

    public Heap() {

        this.list = new ArrayList<T>();
    }

    public Heap(ArrayList<T> items) {

        this.list = items;
        buildHeap();
    }

    public void insert(T item) {

        list.add(item);
        int i = list.size() - 1;
        int parent = parent(i);

        while ( (parent != i && list.get(i).getFreq() < list.get(parent).getFreq())
        		|| (parent != i && (list.get(i).getFreq() == list.get(parent).getFreq() && list.get(i).getRun_length() > list.get(parent).getRun_length()  ))
        		) {

            swap(i, parent);
            i = parent;
            parent = parent(i);
        }
    }

    public void buildHeap() {

        for (int i = list.size() / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public T extractMin() {

        if (list.size() == 0) {

            throw new IllegalStateException("MinHeap is EMPTY");
        } else if (list.size() == 1) {

            T min = list.remove(0);
            return min;
        }

        // remove the last item ,and set it as new root
        T min = list.get(0);
        T lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);

        // bubble-down until heap property is maintained
        minHeapify(0);

        // return min key
        return min;
    }

    public void decreaseKey(int i, T key) {

        if (list.get(i).getFreq() < key.getFreq()) {

            throw new IllegalArgumentException("Key is larger than the original key");
        }

        list.set(i, key);
        int parent = parent(i);

        // bubble-up until heap property is maintained
        while (i > 0 && list.get(parent).getFreq() > list.get(i).getFreq()) {

            swap(i, parent);
            i = parent;
            parent = parent(parent);
        }
    }

    private void minHeapify(int i) {

        int left = left(i);
        int right = right(i);
        int smallest = -1;

        // find the smallest key between current node and its children.
        if (left <= list.size() - 1 && list.get(left).getFreq() < list.get(i).getFreq()) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= list.size() - 1 && list.get(right).getFreq() < list.get(smallest).getFreq()) {
            smallest = right;
        }

        // if the smallest key is not the current key then bubble-down it.
        if (smallest != i) {

            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public T getMin() {

        return list.get(0);
    }

    public boolean isEmpty() {

        return list.size() == 0;
    }

    private int right(int i) {

        return 2 * i + 2;
    }

    private int left(int i) {

        return 2 * i + 1;
    }

    private int parent(int i) {

        if (i % 2 == 1) {
            return i / 2;
        }

        return (i - 1) / 2;
    }

    private void swap(int i, int parent) {

        T temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }
}