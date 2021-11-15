package com.wyman.datastructor.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree {
   public static void main(String[] args) {
      String str = "helloworld";
      //哈夫曼编码
      HuffmanCode huffmanCode = new HuffmanCode();
      ArrayList<Code> list = huffmanCode.getList(str);
      //构建哈弗曼树
      Code root = huffmanCode.createHuffmanTree(list);
      System.out.println("前序遍历哈弗曼树");
      root.preTraverse();
      //进行哈弗曼编码
      Map<Byte, String> codeMap = root.getCodeMap();
      System.out.println("哈弗曼编码");
      System.out.println(codeMap);
   }
}

class HuffmanCode {
   public ArrayList<Code> getList(String codes) {
      //得到字符串对应的字节数组
      byte[] byteCodes = codes.getBytes();

      //创建哈希表，用于存放数据及其权值（出现次数）
      Map<Byte, Integer> dataAndWight = new HashMap<>();
      for(byte b : byteCodes) {
         Integer wight = dataAndWight.get(b);
         //如果还没有该数据，就创建并让其权值为1
         if(dataAndWight.get(b) == null) {
            dataAndWight.put(b, 1);
         }else {
            //如果已经有了该数据，就让其权值加一
            dataAndWight.put(b, wight+1);
         }
      }

      //创建List，用于返回
      ArrayList<Code> list = new ArrayList<>();
      //遍历哈希表，放入List集合中
      for(Map.Entry<Byte, Integer> entry : dataAndWight.entrySet()) {
         list.add(new Code(entry.getKey(), entry.getValue()));
      }
      return list;
   }

   public Code createHuffmanTree(ArrayList<Code> lists) {
      int leftIndex = 0;
      int rightIndex = 1;
      //根据权值进行排序
      Collections.sort(lists);

      while (lists.size() > 1) {
         Code leftCode = lists.get(leftIndex);
         Code rightCode = lists.get(rightIndex);
         Code parent = new Code(null,leftCode.weight + rightCode.weight);
         parent.left = leftCode;
         parent.right = rightCode;
         lists.add(parent);
         lists.remove(leftCode);
         lists.remove(rightCode);
         //再次排序
         Collections.sort(lists);
      }
      return lists.get(0);
   }
}

class Code implements Comparable<Code> {
   Byte data;
   int weight;
   Code left;
   Code right;
   private Map<Byte, String> codeMap = new HashMap<>();



   public Code(Byte data, int weight) {
      this.data = data;
      this.weight = weight;
   }

   @Override
   public String toString() {
      return "Code{" +
            "data=" + data +
            ", weight=" + weight +
            '}';
   }

   public void preTraverse() {
      System.out.println(this);
      if(left != null) {
         left.preTraverse();
      }
      if(right != null) {
         right.preTraverse();
      }
   }

   public Map<Byte, String> getCodeMap() {
      return getCode(this, "", new StringBuilder());
   }

   /**
    * 对哈弗曼树中的叶子节点进行编码
    * @param node 根节点
    * @param code 左子树为0，右子树为1
    * @param stringBuilder 用于拼接的字符串
    * @return
    */
   private Map<Byte, String> getCode(Code node, String code, StringBuilder stringBuilder) {
      //新建拼接路径
      StringBuilder appendCode = new StringBuilder(stringBuilder);
      appendCode.append(code);
      if(node != null) {
         //如果是非叶子结点，就继续向下遍历
         if(node.data == null) {
            getCode(node.left, "0", appendCode);
            getCode(node.right, "1", appendCode);
         }else {
            //如果是叶子节点，就将哈弗曼编码放入哈希表中
            codeMap.put(node.data, appendCode.toString());
         }
      }
      return codeMap;
   }

   @Override
   public int compareTo(Code o) {
      return weight - o.weight;
   }
}
