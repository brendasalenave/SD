import java.util.LinkedList;
import java.util.List;

public class Pilha {

	  private List<Integer> stack = new LinkedList<Integer>();

	  public synchronized void push(Integer n) {
	    this.stack.add(n);
	  }

	  public synchronized Integer pop() {
	    return this.stack.remove(this.stack.size() - 1);
	  }

	  public synchronized boolean vazia() {
	    return this.stack.size() == 0;
	  }
	}