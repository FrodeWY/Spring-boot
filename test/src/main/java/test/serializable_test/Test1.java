package test.serializable_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

public class Test1 {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 11; i++) {
      list.add(i);
    }
    TreeSet treeSet=new TreeSet();
    LinkedList linkedList=new LinkedList();
    for (int i = 0; i < linkedList.size(); i++) {
      
    }
    Collections.sort(list, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1<o2?1:o1.equals(o2)?0:-1;
      }
    });
    System.out.println("sort:"+list);
    Vector vector=new Vector();
    vector.add(1);
    Enumeration elements = vector.elements();
    while (elements.hasMoreElements()) {
      elements.nextElement();
    }

    ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(new File("temp.txt")));
    outputStream.writeObject(list);
    outputStream.close();

    ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(new File("temp.txt")));
    ArrayList<Integer> list1 = (ArrayList<Integer>) inputStream.readObject();
    System.out.println(list1);
    System.out.println(list==list1);

  }

}
