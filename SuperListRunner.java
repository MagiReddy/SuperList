import java.lang.Math;

public class SuperListRunner
{
	public SuperListRunner()
	{
		SuperList<Integer> list = new SuperList<Integer>();

		//Create a new class & fill 30 random Integers from 1-1000
		for(int i = 0; i < 30; i++)
		{
			list.add((int)(Math.random()*999)+1);
		}

		//Display "list"
		System.out.print("Print List: ");
		System.out.println(list);

		//Output the size of the SuperList
		System.out.print("Size of List: ");
		System.out.println(list.size());

		//Move "ArrayList" -> "Stack"
		SuperList<Integer> stack = new SuperList<Integer>();
		for(int i = list.size()-1; i >= 0; i--)
		{
			stack.push(list.remove(i));
		}

		//Display "stack"
		System.out.print("Print Stack: ");
		System.out.println(stack);

		//Move "Stack" -> "Queue"
		SuperList<Integer> queue = new SuperList<Integer>();
		while(!(stack.isEmpty()))
		{
			queue.add(stack.pop());
		}

		//Display "Queue"
		System.out.print("Print Queue: ");
		System.out.println(queue);

		//Move "Queue" -> "ArrayList"
		int qSize = queue.size();
		while(!(queue.isEmpty()))
		{
			int rand = (int)(Math.random()*(list.size()));
			list.add(rand, queue.pop());
		}
		//Display "List#2"
		System.out.print("Print List#2: ");
		System.out.println(list);

		//Calculate the sum of the list
		int sum = 0;
		for(int i = 0; i < list.size(); i++)
		{
			sum += list.get(i);
		}
		System.out.println("Sum: " + sum);

		//Calculate the sum of the even indexed values
		int sumEven = 0;
		for(int i = 0; i < list.size(); i++)
		{
			if(i%2 == 0)
			{
				sumEven += list.get(i);
			}
		}
		System.out.println("Sum of Even #s: " + sumEven);

		//Calculate the sum of the odd indexed values
		int sumOdd = 0;
		for(int i = 0; i < list.size(); i++)
		{
			if(i%2 != 0)
			{
				sumOdd += list.get(i);
			}
		}
		System.out.println("Sum of Odd #s: " + sumOdd);

		//Create duplicates of all even values & add each new value to the end of the SuperList
		int size=list.size();
		for(int i = 0; i < size; i++)
		{
			if(list.get(i) % 2 == 0)
			{
				list.add(list.get(i));
			}
		}
		System.out.println("Duplicating Even Values: " + list);

		//Remove all instances of values that are divisible by 3
		for(int i = 0; i < size; i++)
		{
			if(list.get(i) % 3 == 0)
			{
				list.remove(i);
			}
		}
		System.out.println("Remove all values divisible by 3: " + list);

		//Insert the value 55555 into the 4th position in the SuperList
		list.add(4, 55555);
		System.out.println("Insert 55555 into 4th position: " + list);

		//Sort the SuperList in descending order
		for(int i = 0; i < list.size(); i++)
		{
			int y=i; //bookmark
			try
			{
				while(list.get(y+1) > list.get(y))
				{
					list.add(y, list.remove(y+1));
					y--;
				}
			}catch(IndexOutOfBoundsException e){}
		}
		System.out.println("Descending Order: " + list);

		//Find "median" value
		double median = 0;
		System.out.println("SIZE: " + list.size());
		if((list.size()-1) % 2 == 0)
		{
			int indexMedian = (list.size()-1)/2;
			median = (double)(list.get(indexMedian));
			System.out.println("Median: " + median);
			System.out.print("Values Before Median: ");
			for(int i = 0; i < indexMedian; i++)
			{
				System.out.print(list.get(i) + ", ");
			}
			System.out.print("\nValues After Median: ");
			for(int i = indexMedian+1; i < list.size(); i++)
			{
				System.out.print(list.get(i) + ", ");
			}
		}
		else
		{
			int indexNumR = list.size()/2;
			int indexNumL = (list.size()/2)-1;

			int numR = list.get(indexNumR);
			int numL = list.get(indexNumL);

			median = (double)(numR + numL)/(double)2;
			System.out.println("Median: " + median);
			System.out.print("Values Before Median: ");
			for(int i = 0; i <= indexNumL; i++)
			{
				System.out.print(list.get(i) + ", "); //REMOVE LAST COMMA?????????????????
			}
			System.out.print("\nValues After Median: ");
			for(int i = indexNumR; i < list.size(); i++)
			{
				System.out.print(list.get(i) + ", "); //REMOVE LAST COMMA?????????????????
			}
			System.out.println();
		}

		//Instantiate a new SuperList of String
		SuperList<String> stringL = new SuperList<String>();
		String sentence = "Hi My Name is Meghana"; // DO WE NEED TO REMOVE ANY PUNCUATION???????
		String[] sentL = sentence.split(" ");
		for(int i = 0; i < sentL.length; i++)
		{
			stringL.add(sentL[i]);
		}
		System.out.println(stringL);

		//Remove any strings from your SuperList that have <= to 3 characters.

		for(int i = 0; i < stringL.size(); i++)
		{
			if(stringL.get(i).length() <= 3)
			{
				stringL.remove(i);
				i--;
			}
		}
		System.out.println("Remove Strings w/ <= 3 characters: " + stringL);


		//Sort the SuperList in ascending order w/ insertion sort
		for(int i = 0; i < stringL.size(); i++)
		{
			int y=i; //bookmark
			try
			{
				while(stringL.get(y).compareTo(stringL.get(y+1)) > 0)
				{
					stringL.add(y, stringL.remove(y+1));
					y--;
				}
			}catch(IndexOutOfBoundsException e){}
		}
		System.out.println("Ascending Order: " + stringL);

		//Find the average word length\
		int wordL = 0;
		for(int i = 0; i < stringL.size(); i++)
		{
			wordL += stringL.get(i).length();
		}
		double avg = (double)wordL/(stringL.size());
		System.out.println("Average Word Length: " + avg);
	}

	public static void main(String[] args)
	{
		SuperListRunner app=new SuperListRunner();
	}



}