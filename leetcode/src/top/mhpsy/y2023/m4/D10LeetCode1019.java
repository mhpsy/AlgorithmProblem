package top.mhpsy.y2023.m4;

import java.util.*;

public class D10LeetCode1019 {
    public static void main(String[] args) {

    }
}

class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) > temp) {
                    ans[i] = list.get(j);
                    break;
                }
            }
        }

        return ans;
    }

    public int[] nextLargerNodes2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        int index = -1;
        while (head != null) {
            index++;
            list.add(0);//先添加一个0，后面再替换

            while (!stack.isEmpty() && stack.peek()[1] < head.val) {
                //如果栈顶元素小于当前元素，那么就把栈顶元素弹出，然后把当前元素的值赋给list
                int[] pop = stack.pop();
                list.set(pop[0], head.val);
            }

            stack.push(new int[]{index, head.val});
            head = head.next;
        }

        return list.stream().mapToInt(v -> v).toArray();

    }

    /**
     * Deque<int[]> deque = new ArrayDeque<>();
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes3(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        ListNode node = head;
        int index = -1;

        while (node != null) {
            index++;
            list.add(0);//最后一个一定是0

            while (!deque.isEmpty() && deque.peek()[1] < node.val) {
                int[] pop = deque.pop();
                list.set(pop[0], node.val);
            }

            deque.push(new int[]{index, node.val});
            node = node.next;
        }

        return list.stream().mapToInt(v -> v).toArray();
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
