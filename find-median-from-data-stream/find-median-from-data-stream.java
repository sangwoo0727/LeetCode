class MedianFinder {

  private final PriorityQueue<Integer> maxHeap;
  private final PriorityQueue<Integer> minHeap;

  public MedianFinder() {
    maxHeap = new PriorityQueue<>();
    minHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  public void addNum(int num) {
    minHeap.add(num);
    maxHeap.add(minHeap.poll());

    if (minHeap.size() < maxHeap.size()) {
      minHeap.add(maxHeap.poll());
    }
  }

  public double findMedian() {
    if (minHeap.size() > maxHeap.size()) {
      return minHeap.peek();
    }else {
      return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */