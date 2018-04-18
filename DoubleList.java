package ListTest;

//定义链表接口 定义链表行为的地方
interface Link {
	void add(Object obj);
	boolean remove(int index);
	boolean contains(Object obj);
	int indexOf(Object obj);
	boolean set(int index, Object obj);
	Object get(int index);
	int length();
	void clear();
	Object[] toArray();
	void printLink();
}

//工厂模式
class Factory{
	private Factory() {}
	public static Link getLinkInstance() {
		return new LinkImpl();
	}
}

//实现接口
class LinkImpl implements Link {
	private class Node {
		Object data;
		Node prev;
		Node next;
		public Node(Node prev, Object obj, Node next) {
			this.data = obj;
			this.prev = prev;
			this.next = next;
		}
	}
	private Node first;
	private Node last;
	int size;
	public void add(Object obj) {
		if(first == null) {
			Node newNode = new Node(null, obj, null);
			this.first = this.last = newNode;
			newNode.prev = newNode.next = null;
			++this.size;
		} else{
			Node newNode = new Node(last, obj, null);
			this.last.next = newNode;
			this.last = newNode;
			++this.size;
		}
	}
	public boolean remove(int index) {
		if(!this.isEmptyIndex(index)) {
			return false;
		}
		Node rm = (Node)this.get(index);
		if(rm == this.first) {
			if(this.first == this.last) {
				this.first = this.last = null;
				this.size--;
			} else {
				this.first = rm.next;
				this.first.prev = null;
				this.size--;
			}
		} else if (rm == this.last) {
			this.last = rm.prev;
			this.last.next = null;
			this.size--;
		} else {
			rm.prev.next = rm.next;
			rm.next.prev = rm.prev;
			this.size--;
		}
		return true;
	}
	
	public boolean contains(Object obj) {
		for(Node tmp = this.first; tmp != null; tmp = tmp.next) {
			if(obj.equals(tmp.data)) {
				return true;
			}
		}
		return false;
	}
	public int indexOf(Object obj) {
		int index = 0;
		for(Node tmp = this.first; tmp != null; tmp = tmp.next) {
			++index;
			if(obj.equals(tmp.data)) {
				return index;
			}
		}
		return -1;
	}
	public boolean set(int index, Object obj) {
		if(!this.isEmptyIndex(index)) {
			return false;
		}
		Node tmp = (Node)this.get(index);
		tmp.data = obj;
		return true;
	}
	public Object get(int index) {
		if(!this.isEmptyIndex(index)) {
			return false;
		}
		Node tmp = this.first;
		while(index-- != 0) {
			tmp = tmp.next;
		}
		return tmp;
	}
	public int length() {
		return this.size;
	}
	public void clear() {
		for(Node tmp = this.first; tmp != null;) {
			Node next = tmp.next;
			tmp.next = tmp.prev = null;
			tmp = next;
		}
	}
	public Object[] toArray() {
		Object[] obj = new Object[this.size];
		int j = 0;
		for(Node i = this.first; i != null; i = i.next) {
			obj[j++] = i.data;
		}
		System.out.println("转换为数组时数组的长度：" + obj.length);
		return obj;
	}
	public void printLink() {
		for(Object data : this.toArray()) {
			System.out.println(data);
		}
	}
	public boolean isEmptyIndex(int index) {
		return index >= 0 && index <= this.size;
	}
}

public class ListTest {
	public static void main(String[] args) {
//		Link link = Factory.getLinkInstance();
//		link.add("车头");
//		link.add("一号车厢");
//		link.add("二号车厢");
//		link.add("三号车厢");
//		link.printLink();
//		System.out.println("link 的长度" + link.length());
//		link.remove(3);
//		link.printLink();
//		System.out.println("link 的长度" + link.length());	
		System.out.println("李".compareTo("张"));

	}
