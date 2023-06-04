/* Team members:
Raghad Hawsawi 2105869 - Najd Khalid 2006156 - Wed Aljahdali 2105502 - Renad Baghdadi 2006538

Resources
1)  Levitin, A. (2012). Introduction to the design and analysis of algorithms. Pearson.
2)  KruskalAlg: https://algorithms.tutorialhorizon.com/kruskals-algorithm-minimum-spanning-tree-mst-complete- java-implementation/
3)  MinHeap:  https://medium.com/@ankur.singh4012/implementing-min-heap-in-java-413d1c20f90d
4)  MHPrimAlg :  https://www.baeldung.com/java-prim-algorithm

Section:
CP1
 */
package GraphFramework;

import java.util.Arrays;

public class MinHeap {

  private int capacity;
  private int size = 0;
  private Edge[] heap;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.heap = new Edge[capacity];
  }

//---------------------------------------------------------------------------------- 
  public int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  //----------------------------------------------------------------------------------
  public int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  //----------------------------------------------------------------------------------
  public int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  //----------------------------------------------------------------------------------
  public boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  //----------------------------------------------------------------------------------
  public boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  //----------------------------------------------------------------------------------
  public boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  //----------------------------------------------------------------------------------
  public Edge leftChild(int parentIndex) {
    return heap[getLeftChildIndex(parentIndex)];
  }

  //----------------------------------------------------------------------------------
  public Edge rightChild(int parentIndex) {
    return heap[getRightChildIndex(parentIndex)];
  }

  //----------------------------------------------------------------------------------
  public Edge parent(int childIndex) {
    return heap[getParentIndex(childIndex)];
  }

  //----------------------------------------------------------------------------------
  public void swap(int index1, int index2) {
    Edge element = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = element;
  }

  //----------------------------------------------------------------------------------
  private void ensureCapacity() {
    if (size == capacity) {
      heap = Arrays.copyOf(heap, capacity * 2);
      capacity = capacity * 2;
    }
  }

  //----------------------------------------------------------------------------------
  // Time Complexity : O(1)
  public Edge peek() {
    if (size == 0) {
      return null;
    }
    return heap[0];
  }

  //----------------------------------------------------------------------------------
  // Time Complexity : O( Log n)
  public Edge poll() {
    if (size == 0) {
      return null;
    }

    Edge element = heap[0];

    heap[0] = heap[size - 1];
    size--;
    heapifyDown();
    return element;
  }

  //----------------------------------------------------------------------------------
  // Time Complexity : O( Log n)
  public void add(Edge item) {
    ensureCapacity();
    heap[size] = item;
    size++;
    heapifyUp();
  }

  //----------------------------------------------------------------------------------
  private void heapifyUp() {
    int index = size - 1;

    while (hasParent(index) && parent(index).weight > heap[index].weight) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  //----------------------------------------------------------------------------------
  private void heapifyDown() {
    int index = 0;

    while (hasLeftChild(index)) {
      int smallestChildIndex = getLeftChildIndex(index);

      if (hasRightChild(index) && rightChild(index).weight < leftChild(index).weight) {
        smallestChildIndex = getRightChildIndex(index);
      }

      if (heap[index].weight < heap[smallestChildIndex].weight) {
        break;
      } else {
        swap(index, smallestChildIndex);
      }
      index = smallestChildIndex;
    }
  }

  //----------------------------------------------------------------------------------
  public void printHeap() {
    for (int i = 0; i < size; i++) {
      System.out.print(heap[i] + " ");
    }
  }

}
