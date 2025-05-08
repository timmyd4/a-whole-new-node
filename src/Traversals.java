import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class Traversals {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(88);


    Node<Integer> child1 = new Node<>(17);
    Node<Integer> child2 = new Node<>(58);
    Node<Integer> child3 = new Node<>(33);

    root.children = new ArrayList<>();
    root.children.add(child1);
    root.children.add(child2);
    root.children.add(child3);

    Node<Integer> child1_1 = new Node<>(5);
    Node<Integer> child1_2 = new Node<>(99);
    child1.children = new ArrayList<>();
    child1.children.add(child1_1);
    child1.children.add(child1_2);


    Node<Integer> child2_1 = new Node<>(73);
    child2.children = new ArrayList<>();
    child2.children.add(child2_1);

    Node<Integer> child3_1 = new Node<>(24);
    Node<Integer> child3_2 = new Node<>(61);
    Node<Integer> child3_3 = new Node<>(12);
    child3.children = new ArrayList<>();
    child3.children.add(child3_1);
    child3.children.add(child3_2);
    child3.children.add(child3_3);


    Node<Integer> child3_1_1 = new Node<>(83);
    Node<Integer> child3_1_2 = new Node<>(6);
    child3_1.children = new ArrayList<>();
    child3_1.children.add(child3_1_1);
    child3_1.children.add(child3_1_2);



    Map<Integer, List<Integer>> tree = new HashMap<>();

    tree.put(33, List.of(24, 61, 12));
    tree.put(58, List.of(73));
    tree.put(73, List.of());
    tree.put(24, List.of(83,6));
    tree.put(61, List.of());
    tree.put(12, List.of());
    tree.put(17, List.of(5, 99));
    tree.put(5, List.of());
    tree.put(99, List.of());
    tree.put(83, List.of());
    tree.put(6, List.of());
    tree.put(88, List.of(17, 58, 33));

    //printPreOrder(root);
    preOrderMap(tree, 88);
  }

  public static <T> void printPreOrder(Node<T> current)
  {
    if(current == null) return;
    System.out.println(current.value);

    if(current.children != null)
    {
      for(Node<?> child: current.children)
      {
        printPreOrder(child);
      }
    } 
  }

  public static <T> void preOrderMap(Map<T, List<T>> tree, T current)
  {
    if(current == null || !tree.containsKey(current)) return;

    System.out.println(current);

    List<T> children = tree.get(current);
    if(children != null)
    {
      for(T child: children)
      {
        preOrderMap(tree, child);
      }
    }
  }


}
