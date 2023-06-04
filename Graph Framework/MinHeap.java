/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphFramework;

import java.util.Arrays;

/**
 *
 * @author Raghad
 */
public class MinHeap {

  private int capacity;
  private int size = 0;
  private Edge[] heap;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.heap = new Edge[capacity];
  }


  public int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  public int getRightChildIndex(int parentIndex) {
    return 2 * parentIndex + 2;
  }

  public int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  public boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  public boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  public boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  public Edge leftChild(int parentIndex) {
    return heap[getLeftChildIndex(parentIndex)];
  }

  public Edge rightChild(int parentIndex) {
    return heap[getRightChildIndex(parentIndex)];
  }

  public Edge parent(int childIndex) {
    return heap[getParentIndex(childIndex)];
  }

  public void swap(int index1, int index2) {
    Edge element = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = element;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      heap = Arrays.copyOf(heap, capacity * 2);
      capacity = capacity * 2;
    }
  }

  // Time Complexity : O(1)
  public Edge peek() {
    if (size == 0) {
      return null;
    }
    return heap[0];
  }

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

  // Time Complexity : O( Log n)
  public void add(Edge item) {
    ensureCapacity();
    heap[size] = item;
    size++;
    heapifyUp();
  }

  private void heapifyUp() {
    int index = size - 1;

    while (hasParent(index) && parent(index).weight > heap[index].weight) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

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

  public void printHeap() {
    for (int i = 0; i < size; i++) {
      System.out.print(heap[i] + " ");
    }
  }

}