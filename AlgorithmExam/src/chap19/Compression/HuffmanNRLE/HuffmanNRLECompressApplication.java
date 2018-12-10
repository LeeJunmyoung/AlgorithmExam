package chap19.Compression.HuffmanNRLE;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;





public class HuffmanNRLECompressApplication {

	public static void main(String args[]) throws IOException {
		
		/*RandomAccessFile fin = new RandomAccessFile("", "r");
		HuffmanCode.collectRuns(fin);
		fin.close();*/
		
		Heap<Run> heap = new Heap();
		Run run = new Run('A', 3, 5);
		Run run1 = new Run('B', 2, 4);
		Run run2 = new Run('C', 1, 3);
		Run run3 = new Run('D', 1, 2);
		Run run4 = new Run('E', 2, 5);
		Run run5 = new Run('F', 2, 1);
		Run run6 = new Run('G', 2, 1);
		
		
		heap.insert(run1);
		heap.insert(run);
		heap.insert(run2);
		heap.insert(run3);
		heap.insert(run4);
		heap.insert(run5);
		heap.insert(run6);
		
		int []arr = new int[5];
		HuffmanCode huffmanCode = new HuffmanCode();
		huffmanCode.createHuffmanTree(heap);
		huffmanCode.printEachCharacterCode(huffmanCode.theRoot, arr, 0);
		
		String str = "AAACAABBCBBCEDDEFEGEE";
		String encode = huffmanCode.encode(str);
		String decode = huffmanCode.decode(encode);
		System.out.println(str);
		System.out.println(encode);
		System.out.println(decode);
		System.out.println(str.equals(decode));
		
	}
	
}
class HuffmanCode{
	
	private static ArrayList<Run> runs=new ArrayList<Run>();
	
	public Heap<Run> heap;
	public Run theRoot;
	public HashMap<String, String> encodeWord;
	public HashMap<String, String> decodeWord;
	
	public void createHuffmanTree(Heap _heap) {
		this.heap= _heap;
		encodeWord = new HashMap<>();
		decodeWord = new HashMap<>();
		makeHuffmanTree();
	}
	
	static void collectRuns(RandomAccessFile fin) throws IOException{
		
	}
	
	void makeHuffmanTree() {
		Run newRun;
		while(true) {
			
			Run leftChild  = heap.extractMin();
			
			Run RightChild = heap.extractMin();
			
			
			
			newRun = new Run(' ', 0, leftChild.freq+RightChild.freq);
			newRun.leftRun = leftChild;
			newRun.rightRun = RightChild;
			
			
			if(heap.isEmpty()) break;
			
			heap.insert(newRun);
		}
		theRoot = newRun;
		
	}
	
	public void printEachCharacterCode(Run htRoot, int []trace, int top)
	{
		// left를 탐색할 경우 0을 출력하고, right를 탐색할 경우 1을 출력을 합니다.
		// 단말 노드를 만났을 경우, 즉, left right 모두 null일 경우 단말 노드의 character를 출력합니다.
		
		if(htRoot.leftRun != null)
		{
			trace[top] = 0;
			printEachCharacterCode(htRoot.leftRun, trace, top+1);
		}
		if(htRoot.rightRun != null)
		{
			trace[top] = 1;
			printEachCharacterCode(htRoot.rightRun, trace, top+1);
		}

		if(htRoot.leftRun == null && htRoot.rightRun == null) // 단말 노드를 만났을 경우
		{
			StringBuilder code = new StringBuilder();
			
			System.out.print(htRoot.symbol + "(빈도 수: " + htRoot.freq +"): ");
			for(int i=0;i<top;i++){
				System.out.print(trace[i]);
				code.append(trace[i]);
			}
			encodeWord.put(String.valueOf(htRoot.symbol), code.toString());
			decodeWord.put(code.toString(),String.valueOf(htRoot.symbol));
			System.out.println("");
		}
	}
	
	public String encode(String str){
		
		StringBuilder dest = new StringBuilder();
	    for (int i = 0; i < str.length(); i++) {
	    	dest.append(encodeWord.get(str.charAt(i)+""));
	    }
		return dest.toString();
	}
	
	public String decode(String str){
		
		StringBuilder dest = new StringBuilder();
		StringBuilder code = new StringBuilder();
	    for (int i = 0; i < str.length(); i++) {
	    	code.append(str.charAt(i)+"");
	    	if(decodeWord.get(code.toString())!=null){
	    		dest.append(decodeWord.get(code.toString()));
	    		code = new StringBuilder();
	    	}
	    }
		return dest.toString();
	}
	
}

class Run {
	public char symbol=' ';
	public int run_length=0;
	public int freq=0;
	public Run leftRun;
	public Run rightRun;
	
	
	public Run(char symbol, int run_length, int freq) {
		super();
		this.symbol = symbol;
		this.run_length = run_length;
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

        while ( (parent != i && list.get(i).freq < list.get(parent).freq)
        		|| (parent != i && (list.get(i).freq == list.get(parent).freq && list.get(i).run_length > list.get(parent).run_length  ))
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

            return null;
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


    private void minHeapify(int i) {

        int left = left(i);
        int right = right(i);
        int smallest = -1;

        // find the smallest key between current node and its children.
        if (left <= list.size() - 1 && list.get(left).freq < list.get(i).freq) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (right <= list.size() - 1 && list.get(right).freq < list.get(smallest).freq) {
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