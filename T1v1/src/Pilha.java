import java.util.*;

public class Pilha {

	  private List<Integer> stack = new LinkedList<Integer>();

	  public synchronized void push(Integer n) {
	    this.stack.add(n);
	  }

	  public synchronized Integer pop() {
	    return this.stack.remove(this.stack.size() - 1);
	  }

	  public boolean vazia() {
	    return this.stack.size() == 0;
	  }
	}