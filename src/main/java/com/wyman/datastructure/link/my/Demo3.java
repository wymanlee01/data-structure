package com.wyman.datastructure.link.my;

public class Demo3 {
    public static void main(String[] args) {
        CircularList circularList = new CircularList();
		for (int i = 1; i <= 7; i++) {
			AttenderNode node = new AttenderNode(i);
			circularList.addNode(node);
		}
        System.out.println("约瑟夫环");
        AttenderNode[] arr = circularList.killAttender(3, 1);
        for (AttenderNode node : arr) {
            System.out.println(node);
        }


    }
}

class CircularList {
    private final AttenderNode head = new AttenderNode(-1);

    AttenderNode temp;

    public void addNode(AttenderNode node) {
    	// 还没有节点
		if (head.next == null) {
			head.next = node;
			return;
		}
		// temp:第一个元素,有一个节点情况下，新增第二个节点
		temp = head.next;
		if (temp.next == null) {
			temp.next = node;
			// 第二节点的next指向第一个节点
			node.next = head.next;
			return;
		}
		while (temp.next != head.next) {
			temp = temp.next;
		}
		// temp 现在是尾节点了
		temp.next = node;
		// node 现在是尾节点
		node.next = head.next;
	}

    public int getListLength() {
		if (head.next == null) {
			return 0;
		}
		if (head.next.next == null) {
			return 1;
		}
		int length = 2;
		AttenderNode first = head.next;
		AttenderNode temp = first.next;
		while (true) {
			if (temp.next.id == first.id) {
				return 2;
			}
			temp = temp.next;
			length++;
		}
	}

    /**
     * 删除指定位置节点
     *
     * @param time  次数
     * @param start 开始节点
     * @return
     */
    public AttenderNode[] killAttender(int time, int start) {
		if (head.next == null) {
			System.out.println("链表为空");
			return null;
		}
		temp = head.next;
		int length = getListLength();
		// 存放被kill的节点
		AttenderNode[] arr = new AttenderNode[length];
		if (start > length) {
			System.out.println("超出链表范围");
			return null;
		}
		AttenderNode startNode = this.temp;
		int count;
		// 只有一个节点
		if (temp.next == null) {
			arr[0] = temp;
			return arr;
		}
		// 开始节点位置
		for (count = 1; count < start; count++) {
			startNode = startNode.next;
		}
		// 开始节点的下一个节点
		AttenderNode next = startNode.next;
		while (next.next != startNode) {
			next = next.next;
		}
		temp = startNode;
		//记录循环次数
		int loopTime = 1;
		int index = 0;
		for (count = 1; count <= time; count++) {
			if (loopTime == length) {
				arr[index] = temp;
				return arr;
			}
			if (count == time) {
				arr[index] = temp;
				next.next = temp.next;
				index++;
				loopTime++;
				count=0;
			}
			temp = next.next;
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
