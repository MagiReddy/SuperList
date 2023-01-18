import java.util.EmptyStackException;

public class SuperList<E>
{
	ListNode<E> root; //The first value in the list
	ListNode<E> list;
	ListNode<E> end;
	int size = 0;
	public SuperList()
	{
		size = 0;
		root = null;
		end = null;
	}

	public void add(E newVal)
	{
		ListNode<E> newNode = new ListNode<E>(newVal);
		if(size == 0)
		{
			root = newNode;
			end = root;
		}
		else
		{
			newNode.setPrevious(end);
			end.setNext(newNode);
			end=newNode;
		}
		size++;
	}
	public void add(int index, E newVal)
	{
		ListNode<E> newNode = new ListNode<E>(newVal);
		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}

		if(size == 0) // empty
		{
			add(newVal);
		}
		else if(index == size) //end
		{
			add(newVal);
		}
		else if(index == 0) //front
		{
			newNode.setNext(root);
			root.setPrevious(newNode);
			root=newNode;
			size++;
		}
		else //middle
		{
			ListNode<E> temp = root;
			for(int x = 1; x < index; x++)
			{
				temp = temp.getNext();
			}
			ListNode<E> gNext = temp.getNext();
			temp.setNext(newNode);
			newNode.setPrevious(temp);
			newNode.setNext(gNext);
			gNext.setPrevious(newNode);
			size++;
		}
	}
	public void push(E newVal)
	{
		add(newVal);
	}
	public E pop()
	{
		E value = null;
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		if(size == 1)
		{
			value = root.getValue();
			clear();
		}
		else
		{
			value = end.getValue();
			end = end.getPrevious();
			end.setNext(null);
			size--;
		}
		return value;
	}
	public E poll()
	{
		E value = null;
		if(isEmpty())
		{
			return null;
		}
		if(size == 1)
		{
			value = root.getValue();
			clear();
		}
		else
		{
			value = root.getValue();
			root = root.getNext();
			root.setPrevious(null);
			size--;
		}
		return value;
	}
	public ListNode<E> stackPeek()
	{
		return end;
	}
	public ListNode<E> queuePeek()
	{
		return root;
	}
	public E get(int index)///////////////////////////////////////
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> temp = root;
		for(int i = 0; i < index; i++)
		{
			temp = temp.getNext();
		}
		return temp.getValue();

	}
	public int size()
	{
		return size;
	}
	public E remove(int index)
	{
		E value = null;
		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		else if(size == 1)
		{
			value = root.getValue();
			clear();
		}
		else if(index == size-1) //end
		{
			value = end.getValue();
			pop();
		}
		else if(index == 0) //front
		{
			value = root.getValue();
			poll();
		}
		else //middle
		{
			ListNode<E> temp = root;
			for(int i = 1; i <= index; i++)
			{
				temp = temp.getNext();
			}
			ListNode<E> gNext = temp.getNext();
			ListNode<E> gPrev = temp.getPrevious();
			value = temp.getValue();
			gNext.setPrevious(gPrev);
			gPrev.setNext(gNext);
			size--;
		}

		return value;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public void clear()
	{
		root = null;
		end = null;
		size = 0;
	}
	public boolean contains(E val)
	{
		for(int i = 0; i < size; i++)
		{
			if (val == get(i))
			{
				return true;
			}
		}
		return false;
	}
	public String toString()
	{
		String str = "[";
		for(int i = 0; i < size; i++)
		{
			str += get(i) + ", ";
		}

		if(str.length() != 1)
		{
			str = str.substring(0, str.length()-2);
		}

		str += "]";
		return str;
	}

	public class ListNode<E>
	{
		private E value;
		private ListNode<E> next;
		private ListNode<E> prev;

		public ListNode(E value)
		{
			this.value = value;
			next=null;
			prev=null;
		}
		public E getValue()
		{
			return value;
		}
		public void setPrevious(ListNode<E> p)
		{
			prev = p;
		}
		public void setNext(ListNode<E> n)
		{
			next = n;
		}
		public ListNode<E> getPrevious()
		{
			return prev;
		}
		public ListNode<E> getNext()
		{
			return next;
		}
		public boolean hasNext()
		{
			return next != null;
		}
		public boolean hasPrevious()
		{
			return prev != null;
		}

	}
}