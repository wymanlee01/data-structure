package com.wyman.datastructure.link;

public class Demo4 {
	public static void main(String[] args) {
		CircularList circularList = new CircularList();
		for (int i = 1; i <= 7; i++) {
			AttenderNode node = new AttenderNode(i);
			circularList.addNode(node);
		}
		System.out.println("约瑟夫环");
		AttenderNode[] arr = circularList.killAttender(3, 1);
		for(AttenderNode node : arr) {
			System.out.println(node);
		}


	}
}

class CircularList {
	private final AttenderNode head = new AttenderNode(-1);

	AttenderNode temp;

	public void addNode(AttenderNode node) {
		if(head.next == null) {
			head.next = node;
			return;
		}
		temp = head.next;
		//只有一个节点，还没成环
		if(temp.next == null) {
			temp.next = node;
			node.next = head.next;
			return;
		}
		while (temp.next != head.next) {
			temp = temp.next;
		}
		//temp现在为尾节点
		temp.next = node;
		//node现在为尾节点，将其next指向首节点
		node.next = head.next;
	}

		public int getListLength() {
			if(head.next == null) {
				return 0;
			}
			//判断是否只有一个节点
			if(head.next.next == null) {
				return 1;
			}
			//节点个数初始为2
			int length = 2;
			AttenderNode first = head.next;
			AttenderNode temp = first.next;
			while(true) {
				//循环了一轮
				if(temp.next.id == first.id) {
					return length;
				}
				temp = temp.next;
				length++;
			}
		}

	/**
	 * 删除指定位置节点
	 * @param time 次数
	 * @param start 开始节点
	 * @return
	 */
		public AttenderNode[] killAttender(int time, int start) {
			if(head.next == null) {
				System.out.println("链表为空");
				return null;
			}
			temp = head.next;
			int length = getListLength();
			//存放退出队列的节点
			AttenderNode[] arr = new AttenderNode[length];
			//从start开始计数
			if(start > length) {
				System.out.println("超出链表范围");
				return null;
			}
			AttenderNode startNode = temp;
			int count;
			//如果只有一个节点，直接返回
			if(temp.next == null) {
				arr[0] = temp;
				return arr;
			}
			//找到开始节点位置
			for(count = 1; count<start; count++) {
				startNode = startNode.next;
			}
			//找到start的前一个节点，方便删除操作
			AttenderNode front = startNode.next;
			while(front.next != startNode) {
				front = front.next;
			}
			//开始选出节点出链表
			temp = startNode;
			//记录循环次数
			int loopTime = 1;
			int index = 0;
			for(count=1; count<=time; count++) {
				if(loopTime == length) {
					//放入最后一个节点
					arr[index] = temp;
					return arr;
				}
				if(count == time) {
					arr[index] = temp;
					front.next = temp.next;
					index++;
					loopTime++;
					//初始化，因为在循环开始时还会+1，所以这里初始化为0
					count = 0;
				}
				temp =front.next;
			}
			return arr;
		}


}

class AttenderNode {
	int id;
	AttenderNode next;

	@Override
	public String toString() {
		return "KillerNode{" +
				"id=" + id +
				'}';
	}

	public AttenderNode(int id) {
		this.id = id;
	}
}
