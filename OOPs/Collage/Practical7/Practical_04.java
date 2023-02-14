package OOPs.Collage.Practical7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

    public class Practical_04 {

        public static void main(String[] args) {
            // Creation
            ArrayList<Integer> array = new ArrayList<>();
            LinkedList<Integer> list = new LinkedList<>();

            // Basic Operations.
            for (int i = 0; i < 10; i++) {
                array.add(i);
                list.add(i);
            }
            System.out.println("After insertion Arraylist and LinkedList is : ");
            System.out.println("ArrayList : " + array);
            System.out.println("LinkedList : " + list);

            array.remove(4);
            list.remove(4);
            System.out.println("After removal element at array index " + array.remove(3) + " And linked index " + list.remove(4));
            System.out.println("ArrayList : " + array);
            System.out.println("LinkedList : " + list);

            array.set(3, 4);
            list.set(3, 5);
            System.out.println("After updation Arraylist and LinkedList is : ");
            System.out.println("ArrayList : " + array);
            System.out.println("LinkedList : " + list);

            // Iterating over list
            System.out.println("Iteration of ArrayList : ");
            for (Integer iterable_element : array) {
                System.out.print(iterable_element + " ");
            }
            System.out.println();
            System.out.println("Iteration of LinkedList : ");
            for (Integer iterable_element : list) {
                System.out.print(iterable_element + " ");
            }
            System.out.println();

            // Searching For element.
            System.out.println("Search for 3 in Arraylist : " + array.contains(3));
            System.out.println("Search for 3 in LinkedList : " + list.contains(3));
            System.out.println("Search for 5 in Arraylist : " + array.contains(5));
            System.out.println("Search for 5 in LinkedList : " + list.contains(5));

            // shuffling elements of list
            Collections.shuffle(array);
            Collections.shuffle(list);
            System.out.println("After shuffling Arraylist and LinkedList is : ");
            System.out.println("ArrayList : " + array);
            System.out.println("LinkedList : " + list);

            // sorting elements of list
            Collections.sort(array);
            Collections.sort(list);
            System.out.println("After shuffling Arraylist and LinkedList is : ");
            System.out.println("ArrayList : " + array);
            System.out.println("LinkedList : " + list);

            // Copying one list to another.
            ArrayList<Integer> arr1 = new ArrayList<>(array);
            LinkedList<Integer> list1 = new LinkedList<>(list);
            System.out.println("Coppied Arraylist and LinkedList is : ");
            System.out.println("ArrayList : " + arr1);
            System.out.println("LinkedList : " + list1);

            // reversing elements of list
            Collections.reverse(array);
            Collections.reverse(list);
            System.out.println("After shuffling Arraylist and LinkedList is : ");
            System.out.println("ArrayList : " + array);
            System.out.println("LinkedList : " + list);

            // Extracting a portion of a list
            System.out.println("After shuffling Arraylist and LinkedList is : ");
            System.out.println("ArrayList : " + array.subList(3, 7));
            System.out.println("LinkedList : " + list.subList(3, 7));

            // Converting between Lists and arrays
            Integer strs[] = new Integer[array.size()];
            array.toArray(strs);
            System.out.println("ArrayList to array");
            for(int i=0; i<strs.length; i++){
                System.out.print(strs[i] + " ");
            }
            System.out.println();
            strs = new Integer[list.size()];
            list.toArray(strs);
            System.out.println("LinkedList to array");
            for(int i=0; i<strs.length; i++){
                System.out.print(strs[i] + " ");
            }
            System.out.println();

            // Converting List to String
            System.out.println("ArrayList to string " + array.toString());
            System.out.print("LinkedList to string " + list.toString());
        }
    }

