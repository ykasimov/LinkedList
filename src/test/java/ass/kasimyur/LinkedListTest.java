package ass.kasimyur;


import org.testng.Assert;

import java.util.*;

/**
 * Created by username on 2/26/17.
 */
public class LinkedListTest {

    @org.testng.annotations.Test
    public void testAppend() throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.append("first");
        list.append("second");
        Assert.assertEquals(list.getFirst(), "second");
    }

    @org.testng.annotations.Test
    public void testPrepend() throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.prepend("first");
        list.prepend("second");
        Assert.assertEquals(list.getFirst(), "first");
    }

    @org.testng.annotations.Test
    public void testRemoveFront() throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.append("first");
        list.append("second");
        list.removeFront();
        Assert.assertEquals(list.getFirst(), "first");
    }

    @org.testng.annotations.Test
    public void testRemoveBack() throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.append("first");
        list.append("second");
        list.removeBack();
        Assert.assertEquals(list.getFirst(), "second");
    }

    @org.testng.annotations.Test
    public void testTakeAll() throws Exception {
        Integer[] t = new Integer[]{1, 2, 3};
        List<Integer> srcList = new ArrayList<Integer>(Arrays.<Integer>asList(t));
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        myLinkedList.appendAll(srcList);
        List<Integer> dstList = new ArrayList<Integer>();
        myLinkedList.takeAll(dstList);
        Collections.reverse(dstList);
        Assert.assertEquals(dstList, srcList);
    }

    @org.testng.annotations.Test
    public void testAppendAll() throws Exception {
        Integer[] t = new Integer[]{1, 2, 3};
        List<Integer> srcList = new ArrayList<Integer>(Arrays.<Integer>asList(t));
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        myLinkedList.appendAll(srcList);
        List<Integer> dstList = new ArrayList<Integer>();
        for (Integer elem : myLinkedList) {
            dstList.add(elem);
        }
        Collections.reverse(dstList);
        Assert.assertEquals(dstList, srcList);
    }

    @org.testng.annotations.Test
    public void testCount() throws Exception {
        Integer[] t = new Integer[]{1, 2, 3};
        List<Integer> srcList = new ArrayList<Integer>(Arrays.<Integer>asList(t));
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        Assert.assertEquals(myLinkedList.count(srcList), srcList.size());
    }


    @org.testng.annotations.Test
    public void testBackwardIterator() throws Exception {
        LinkedList<String> myLinkedList = new LinkedList<String>();
        myLinkedList.append("first");
        myLinkedList.append("second");
        myLinkedList.append("third");
        String[] src = new String[]{"first", "second", "third"};
        int index = 0;
        for (Iterator<String> backward = myLinkedList.backwardIterator(); backward.hasNext(); ) {
            Assert.assertEquals(backward.next(), src[index++]);
        }
    }

    @org.testng.annotations.Test
    public void testIterator() throws Exception {
        LinkedList<String> myLinkedList = new LinkedList<String>();

        myLinkedList.append("third");
        myLinkedList.append("second");
        myLinkedList.append("first");

        String[] src = new String[]{"first", "second", "third"};
        int index = 0;
        for (String elem : myLinkedList) {
            Assert.assertEquals(elem, src[index++]);
        }
    }

    @org.testng.annotations.Test
    public void testIteratorHasNextEmptyCollection() throws Exception {
        LinkedList<String> myLinkedList = new LinkedList<String>();
        Assert.assertFalse(myLinkedList.iterator().hasNext());
    }

    @org.testng.annotations.Test
    public void testIteratorHasNextFilledCollection() throws Exception {
        LinkedList<String> myLinkedList = new LinkedList<String>();
        myLinkedList.append("some string");
        Assert.assertTrue(myLinkedList.iterator().hasNext());
        Assert.assertTrue(myLinkedList.iterator().hasNext());
    }


    @org.testng.annotations.Test(expectedExceptions = NoSuchElementException.class)
    public void testIteratorNextEmptyCollection() throws Exception {
        LinkedList<String> myLinkedList = new LinkedList<String>();
        myLinkedList.iterator().next();

    }

    @org.testng.annotations.Test
    public void testIteratorNextNotEmptyCollection() throws Exception {
        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        myLinkedList.append(1);
        myLinkedList.append(2);

        Iterator<Integer> iterator = myLinkedList.iterator();
        Assert.assertEquals(iterator.next(), new Integer(2));
        Assert.assertEquals(iterator.next(), new Integer(1));

    }

}