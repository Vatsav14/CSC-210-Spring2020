/*
 * This file will hold all of your testcases. Remember, to run all
 * of your tests, right-click on 'RunTests.java' and select 'Run As' ->
 * JUnit Test.
 */
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class RecursionTestClass {
	/*
	 * Here I have provided an example of one of the tests that I
	 * would write. For each of your tests, leave a brief comment
	 * above the test specifying its purpose. For example, for this
	 * test, I might write, "indexOf_test1 tests when s2 is not a 
	 * substring of s1. This should return -1."
	 */
	
    @Test
    public void test_indexOf_test1() {
        int result = Recursion.indexOf("Hello", "World");
        System.out.println("indexOf(Hello, World), got " + result);
        assertEquals(result, -1);
    }
    
    @Test
    /*
     * This tests the code is s2 is a substring of s1
     */
    public void test_indexOf_test2() {
        int result = Recursion.indexOf("Computer", "put");
        System.out.println("indexOf(Computer, put), got " + result);
        assertEquals(result, 3);
    }
    
    @Test
    /*
     * This test makes sure that the occurrence returned is the first occurence
     * of s2 in s1. Here there are two occurrences of 'ss' in the 'Assassin' so
     * the first occurrence at index 1 is what is returned
     */
    public void test_indexOf_test3() {
        int result = Recursion.indexOf("Assassin", "ss");
        System.out.println("indexOf(Assassin, ss), got " + result);
        assertEquals(result, 1);
    }
    
    @Test
    /*
     * This tests the functionality of the code where it is supposed to handle
     * the capitalization of the letters. Therefore, for s2 which is 'as', 'As'
     * is not a valid substring
     */
    public void test_indexOf_test4() {
        int result = Recursion.indexOf("Assassin", "as");
        System.out.println("indexOf(Assassin, as), got " + result);
        assertEquals(result, 3);
    }
    
    @Test
    /*
     * This tests the functionality of the code where it is supposed to handle
     * the capitalization of the letters. Therefore, for s2 which is 'AS', 'As'
     * is not a valid substring so -1 is returned
     */
    public void test_indexOf_test5() {
        int result = Recursion.indexOf("Assassin", "AS");
        System.out.println("indexOf(Assassin, AS), got " + result);
        assertEquals(result, -1);
    }
	
	@Test
	/*
	 * This test checks the basic functionality of the code and makes sure that
	 * only the required number of even numbers are removed
	 */
	public void test_removeEvenDigits_test1() {
		Stack<Integer> tester = new Stack<Integer>();
    	Stack<Integer> resultChecker = new Stack<Integer>();
    	tester.push(2); tester.push(3); tester.push(4); tester.push(55); 
    	tester.push(6); tester.push(17); tester.push(8);
    	int result = Recursion.removeEvenNumbers(tester, 2);
    	System.out.println("removeEvenDigits([2,3,4,55,6,17,8], 2), got " + result);
    	System.out.println("The resulting stack is " + tester);
    	assertEquals(result, 2);
	}
	
	@Test
	/*
	 * This test checks the basic functionality of the code and makes sure that
	 * only the required number of even numbers are removed.
	 */
	public void test_removeEvenDigits_test2() {
		Stack<Integer> tester = new Stack<Integer>();
    	Stack<Integer> resultChecker = new Stack<Integer>();
    	tester.push(2); tester.push(3); tester.push(4); tester.push(55); 
    	tester.push(6); tester.push(17); tester.push(8);
    	int result = Recursion.removeEvenNumbers(tester, 4);
    	System.out.println("removeEvenDigits([2,3,4,55,6,17,8], 4), got " + result);
    	System.out.println("The resulting stack is " + tester);
    	assertEquals(result, 4);
	}
	
	@Test
	/*
	 * This test checks the code if the number passed is more than the number of
	 * even numbers present in the stack
	 */
	public void test_removeEvenDigits_test3() {
		Stack<Integer> tester = new Stack<Integer>();
    	Stack<Integer> resultChecker = new Stack<Integer>();
    	tester.push(2); tester.push(3); tester.push(4); tester.push(55); 
    	tester.push(6); tester.push(17); tester.push(8);
    	int result = Recursion.removeEvenNumbers(tester, 6);
    	System.out.println("removeEvenDigits([2,3,4,55,6,17,8], 6), got " + result);
    	System.out.println("The resulting stack is " + tester);
    	assertEquals(result, 4);
	}
	
	@Test
	/*
	 * This test checks the code if there are no even numbers present in the given
	 * stack. That is, the number of even numbers are less tham the amount to be removed
	 */
	public void test_removeEvenDigits_test4() {
		Stack<Integer> tester = new Stack<Integer>();
    	Stack<Integer> resultChecker = new Stack<Integer>();
    	tester.push(1); tester.push(3); tester.push(41); tester.push(55); 
    	tester.push(39); tester.push(17); tester.push(67);
    	int result = Recursion.removeEvenNumbers(tester, 4);
    	System.out.println("removeEvenDigits([1,3,41,55,39,17,67], 4), got " + result);
    	System.out.println("The resulting stack is " + tester);
    	assertEquals(result, 0);
	}
	
	@Test
	/*
	 * This case tests what happens if all the elements in the stack are even and
	 * all of them are removed
	 */
	public void test_removeEvenDigits_test5() {
		Stack<Integer> tester = new Stack<Integer>();
    	Stack<Integer> resultChecker = new Stack<Integer>();
    	tester.push(2); tester.push(20); tester.push(4); tester.push(54);
    	int result = Recursion.removeEvenNumbers(tester, 5);
    	System.out.println("removeEvenDigits([2,20,4,54], 5), got " + result);
    	System.out.println("The resulting stack is " + tester);
    	assertEquals(result, 4);
	}
	
	
	
    @Test
    /*
     * This code tests the basic functionality of the code and makes sure that it works
     * as intended.
     */
    public void test_evenDigits_test1() {
    	int result = Recursion.evenDigits(1364025);
    	System.out.println("evenDigits(1364025), got " + result);
    	assertEquals(result, 6402);
    }
    
    @Test
    /*
     * This tests the code to see what it returns when there are no even numbers in the
     * given input number
     */
    public void test_evenDigits_test2() {
    	int result = Recursion.evenDigits(13579);
    	System.out.println("evenDigits(13579), got " + result);
    	assertEquals(result, 0);
    }
    
    @Test
    /*
     * This test the base case to see what happens if the function is passed 0 as the input
     */
    public void test_evenDigits_test3() {
    	int result = Recursion.evenDigits(0);
    	System.out.println("evenDigits(0), got " + result);
    	assertEquals(result, 0);
    }
    
    @Test
    /*
     * This case tests the code to see what it returns when all of the digits in the input
     * are even numbered digits
     */
    public void test_evenDigits_test4() {
    	int result = Recursion.evenDigits(22222);
    	System.out.println("evenDigits(22222), got " + result);
    	assertEquals(result, 22222);
    }
    
    @Test
    /*
     * This tests to see if the code can handle negative numbers
     */
    public void test_evenDigits_test5() {
    	int result = Recursion.evenDigits(-1364025);
    	System.out.println("evenDigits(-1364025), got " + result);
    	assertEquals(result, 6402);
    }
    
    
    
    @Test
    /*
     * This tests the basic functionality of the code to see if it works
     * as intended
     */
    public void test_repeatStack_test1() {
    	Stack<Integer> tester = new Stack<Integer>();
    	Stack<Integer> resultChecker = new Stack<Integer>();
    	tester.push(1); tester.push(2);	tester.push(3);
    	resultChecker.push(1); resultChecker.push(1);
    	resultChecker.push(2); resultChecker.push(2);
    	resultChecker.push(3); resultChecker.push(3);
    	Recursion.repeatStack(tester);
    	System.out.println("repeatStack([1,2,3]), got " + tester);
    	assertEquals(tester, resultChecker);
    }
    
    @Test
    /*
     * This checks the base case to see what is returned if the funtiona is passed
     * an empty stack
     */
    public void test_repeatStack_test2() {
    	Stack<Integer> tester = new Stack<Integer>();
    	Stack<Integer> resultChecker = new Stack<Integer>();
    	Recursion.repeatStack(tester);
    	System.out.println("repeatStack([]), got " + tester);
    	assertEquals(tester, resultChecker);
    }
    
    @Test
    /*
     * This case tests the function if it works for just one element in the stack
     */
    public void test_repeatStack_test3() {
    	Stack<Integer> tester = new Stack<Integer>();
    	Stack<Integer> resultChecker = new Stack<Integer>();
    	tester.push(1);
    	resultChecker.push(1); resultChecker.push(1);
    	Recursion.repeatStack(tester);
    	System.out.println("repeatStack([1]), got " + tester);
    	assertEquals(tester, resultChecker);
    }
    
    @Test
    /*
     * This test handles a normal case when the function is passed a normal
     * input, that is, it tests the basic functionality of the code
     */
    public void test_doubleElements_test1() {
    	Queue<Integer> q = new LinkedList<Integer>(); 
    	Queue<Integer> result = new LinkedList<Integer>(); 
    	q.add(34); q.add(15); q.add(0);
    	result.add(68); result.add(30); result.add(0);
    	Recursion.doubleElements(q);
    	System.out.println("doubleElements([34,15,0]), got " + q);
    	assertEquals(q, result);
    }
    
    @Test
    /*
     * This test checks the result when the function is given a queue with
     * only the element 0
     */
    public void test_doubleElements_test2() {
    	Queue<Integer> q = new LinkedList<Integer>(); 
    	Queue<Integer> result = new LinkedList<Integer>();
    	q.add(0); result.add(0);
    	Recursion.doubleElements(q);
    	System.out.println("doubleElements([0]), got " + q);
    	assertEquals(q, result);
    }
    
    @Test
    /*
     * This test checks for the proper base case, that is, it evaluates the
     * result when the queue passed in as input is empty
     */
    public void test_doubleElements_test3() {
    	Queue<Integer> q = new LinkedList<Integer>(); 
    	Queue<Integer> result = new LinkedList<Integer>();
    	Recursion.doubleElements(q);
    	System.out.println("doubleElements([]), got " + q);
    	assertEquals(q, result);
    }
    
    @Test
    /*
     * This test checks the result when there are negative elements in the
     * given queue
     */
    public void test_doubleElements_test4() {
    	Queue<Integer> q = new LinkedList<Integer>(); 
    	Queue<Integer> result = new LinkedList<Integer>(); 
    	q.add(-5); q.add(15); q.add(10); q.add(-55);
    	result.add(-10); result.add(30); result.add(20); result.add(-110);
    	Recursion.doubleElements(q);
    	System.out.println("doubleElements([-5, 15, 10, -55]), got " + q);
    	assertEquals(q, result);
    }
	
	
	@Test
	/*
	 * This test checks for the basic functionality of the code using (1+1)
	 */
	public void test_evaluate_test1() {
		String exp = "(1+1)";
		Queue<Character> q = new LinkedList<Character>();
		for (char ch: exp.toCharArray()) { 
			q.add(ch); 
		}
		int result = Recursion.evaluate(q);
		System.out.println("evaluate(['1','+','1']), got " + result);
		assertEquals(result, 2);
	}
	
	@Test
	/*
	 * This test checks if the code can take the product of two numbers using (2*2)
	 */
	public void test_evaluate_test2() {
		String exp = "(2*2)";
		Queue<Character> q = new LinkedList<Character>();
		for (char ch: exp.toCharArray()) { 
			q.add(ch); 
		}
		int result = Recursion.evaluate(q);
		System.out.println("evaluate(['2','*','2']), got " + result);
		assertEquals(result, 4);
	}
	
	@Test
	/*
	 * This test checks whether the code can handle double digit results
	 */
	public void test_evaluate_test3() {
		String exp = "(3*9)";
		Queue<Character> q = new LinkedList<Character>();
		for (char ch: exp.toCharArray()) { 
			q.add(ch); 
		}
		System.out.print("evaluate("+q+"), got ");
		int result = Recursion.evaluate(q);
		System.out.println(result);
		assertEquals(result, 27);
	}
	
	@Test
	/*
	 * This test checks whether the code can handle left handed parentheses equations
	 */
	public void test_evaluate_test4() {
		String exp = "(2*(3+(5+1)))";
		Queue<Character> q = new LinkedList<Character>();
		for (char ch: exp.toCharArray()) { 
			q.add(ch); 
		}
		System.out.print("evaluate("+q+"), got ");
		int result = Recursion.evaluate(q);
		System.out.println(result);
		assertEquals(result, 18);
	}
	
	@Test
	/*
	 * This test checks whether the code can handle right handed parentheses equations
	 */
	public void test_evaluate_test5() {
		String exp = "(((3*2)+4)*2)";
		Queue<Character> q = new LinkedList<Character>();
		for (char ch: exp.toCharArray()) { 
			q.add(ch); 
		}
		System.out.print("evaluate("+q+"), got ");
		int result = Recursion.evaluate(q);
		System.out.println(result);
		assertEquals(result, 20);
	}
	
	@Test
	/*
	 * This test checks whether the code can handle a complex equation with multiple branched equations
	 */
	public void test_evaluate_test6() {
		String exp = "(((1+2)*(3+1))+(1*(2+2)))";
		Queue<Character> q = new LinkedList<Character>();
		for (char ch: exp.toCharArray()) { 
			q.add(ch); 
		}
		System.out.print("evaluate("+q+"), got ");
		int result = Recursion.evaluate(q);
		System.out.println(result);
		assertEquals(result, 16);
	}
	
	@Test
	/*
	 * This test handles the base case or the result when the function is handed an
	 * empty queue
	 */
	public void test_evaluate_test7() {
		String exp = "";
		Queue<Character> q = new LinkedList<Character>();
		for (char ch: exp.toCharArray()) { 
			q.add(ch); 
		}
		System.out.print("evaluate("+q+"), got ");
		int result = Recursion.evaluate(q);
		System.out.println(result);
		assertEquals(result, 0);
	}
}