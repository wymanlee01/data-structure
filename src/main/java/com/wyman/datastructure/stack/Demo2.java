package com.wyman.datastructure.stack;

import java.util.EmptyStackException;

public class Demo2 {
	public static void main(String[] args) {
		String formula = "12+3*15+3/3";
		//索引，用来读取字符串中的元素
		int index = 0;
		//保存读取到的数字和符号
		int number1 = 0;
		int number2 = 0;
		int thisChar = ' ';
		//用于拼接数字
		StringBuilder spliceNumber = new StringBuilder();
		//数栈和符号栈
		ArrayStack2 numberStack = new ArrayStack2(10);
		ArrayStack2 operationStack = new ArrayStack2(10);
		//保存运算结果
		int result;

		//开始读取字符串中的元素
		for (index = 0; index < formula.length(); index++) {
			thisChar = formula.charAt(index);
			System.out.println("当前字符：" + (char) thisChar);
			if (operationStack.isOperation(thisChar)) {
				if(operationStack.comparePriority(thisChar)) {
					operationStack.push(thisChar);
				} else {
					int popChar = operationStack.pop();
					number2 = numberStack.pop();
					number1 = numberStack.pop();
					//获得运算结果
					result = operationStack.calculation(number1, number2, popChar);
					operationStack.push(thisChar);
					numberStack.push(result);
				}
			} else {
				//如果是数字，就一直读取
				while(thisChar>='0' && thisChar<='9') {
					//可能该数字为多位数，所以不能只存入一位数字
					spliceNumber.append(thisChar - '0');
					System.out.println("拼接字符换 " + spliceNumber);
					index++;
					//如果已经读了最后一个数字了，就停下来
					if(index >= formula.length()) {
						break;
					}
					thisChar = formula.charAt(index);
				}
				int number = Integer.parseInt(spliceNumber.toString());
				numberStack.push(number);
				//初始化spliceNumber
				spliceNumber = new StringBuilder();
				index--;
			}
		}

		while(!operationStack.isEmpty()) {
			int popChar = operationStack.pop();
			number2 = numberStack.pop();
			number1 = numberStack.pop();
			//获得运算结果
			result = operationStack.calculation(number1, number2, popChar);
			numberStack.push(result);
		}

		System.out.println(numberStack.pop());
	}
}

class ArrayStack2 {
	private final int maxSize;
	int[] stack;
	private int top;

	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	 public boolean isFull() {
		return top == maxSize - 1;
	}

	public void push(int i) {
		if (isFull()) {
			throw new StackOverflowError("栈满");
		}
		//压栈
		top++;
		stack[top] = i;
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int retNum = stack[top];
		top--;
		return retNum;
	}

	public void  traverse() {
		for(int thiChar : stack) {
			System.out.println(thiChar);
		}
	}

	/**
	 * 判断符号的优先级
	 *
	 * @param operation 传入运算符
	 * @return 返回优先级
	 */
	public int getPriority(int operation) {
		if (operation == '*' || operation == '/') {
			return 2;
		} else if (operation == '+' || operation == '-') {
			return 1;
		} else if (operation >= '0' && operation <= '9') {
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * 比较栈顶元素和传入字符的优先级大小
	 *
	 * @param operation 传入字符
	 * @return true则是传入字符优先级大于栈顶字符，false反之
	 */
	public boolean comparePriority(int operation) {
		if (isEmpty()) {
			return true;
		} else {
  			int priority1 = getPriority(operation);
  			int priority2 = getPriority(stack[top]);
			return priority1 > priority2;
		}
	}

	/**
	 * 判断该位置是不是一个符号
	 *
	 * @param operation 该位置的符号
	 * @return 判断结果
	 */
	public boolean isOperation(int operation) {
		return operation == '*' || operation == '/' || operation == '-' || operation == '+';
	}

	/**
	 * @param number1   第一个运算的数字
	 * @param number2   第二个运算的数字
	 * @param operation 运算符
	 * @return
	 */
	public int calculation(int number1, int number2, int operation) {
		switch (operation) {
			case '+':
				return number1+number2;
			case '-':
				return number1-number2;
			case '*':
				return number1*number2;
			case '/':
				return number1/number2;
			default:
				System.out.println(operation);
				throw new RuntimeException("符号读取错误！");
		}
	}
}
