AtomicInteger: CAS

In reality, even a method such as getAndIncrement() still takes several
steps to execute. The reason this implementation is now thread-safe is
something called CAS. CAS stands for Compare And Swap. Most modern
CPUs have a set of CAS instructions. Following is a basic outline of what is
happening now:
1. The value stored in count is copied to a temporary variable.
2. The temporary variable is incremented.
3. Compare the value currently in count with the original value. If it is
unchanged, then swap the old value for the new value.

Step 3 happens atomically. If step 3 finds that some other thread has already
modified the value of count, then repeat steps 1–3 until we increment the
field without interference.

The central method in a class like AtomicInteger is the boolean
compareAndSet(int expect, int update) method, which provides the
CAS behavior. Other atomic methods delegate to the compareAndSet method.
The getAndIncrement method implementation is simply:

------------------------------------------------------------------
Locks:
-The ability to duplicate traditional synchronized blocks.
-Nonblock scoped locking—obtain a lock in one method and release it in another (this can be dangerous, though).
-Multiple wait/notify/notifyAll pools per lock—threads can select which pool (Condition) they wait on.
-The ability to attempt to acquire a lock and take an alternative action if locking fails.
-An implementation of a multiple-reader, single-writer lock.

1) tryLock
lock.tryLock() - no throws
lock.tryLock(3, TimeUnit.SECONDS) -  throws InterruptionException

2) Avoid deadlock
synchronized(a){
	synchronized(b){
	}
}

synchronized(b){
	synchronized(a){
	}
}


boolean a1 = lock1.tryLock();
boolean a2 = lock2.tryLock();
if(a1 && a2){
}
------------------------------------------------------------------------

1) CopyOnWriteArrayList
Any mutating operations on the List (add, set, remove, etc.) will cause a new
modified copy of the array to be created, which will replace the original readonly array. The read-only nature of the underlying array in a
CopyOnWriteArrayList allows it to be safely shared with multiple threads.

 - CopyOnWriteArrayList is a thread-safe variant of ArrayList where operations which can change the ArrayList (add, update, set methods) creates a clone of the underlying array.
 - CopyOnWriteArrayList is to be used in a Thread based environment where read operations are very frequent and update operations are rare.
 - Iterator of CopyOnWriteArrayList will never throw ConcurrentModificationException.
 - Any type of modification to CopyOnWriteArrayList will not reflect during iteration since the iterator was created.
 - List modification methods like remove, set and add are not supported in the iteration. This method will throw UnsupportedOperationException.
 - null can be added to the list.
 
 if we get Iterator and then add some data --> iterator will not see changes (it will iterate over old version)

2) Other collections 
ConcurrentHashMap
ConcurrentLinkedDeque
ConcurrentLinkedQueue
ConcurrentSkipListMap - sorted (items should be Comparable)
ConcurrentSkipListSet - sorted (items should be Comparable)

3) BlockingQueue
a) Bounded Queues
	ArrayBlockingQueue, LinkedBlockingDeque, and LinkedBlockingQueue
b) SynchronousQueue
	like ArrayBlockingQueue with capacity=1
c) DelayBlockingQueue
	A DelayQueue is useful when you have objects that should not be
	consumed until a specific time. The elements added to a DelayQueue will
	implement the java.util.concurrent.Delayed interface, which defines a
	single method: public long getDelay(TimeUnit unit). The elements of a
	DelayQueue can only be taken once their delay has expired. 
d) LinkedTransferQueue
	boolean b1 = tq.add("a") - returns true if added or throws IllegalStateException if full
	tq.put("b") - blocks if bounded and full
	boolean b3 = tq.offer("a") - returns true if added or false if bounded and full recommended over add
	boolean b4 = tq.offer("a", 10, MILLISECONDS) - returns true if added within the given time false if bound and full
	tq.transfer("a") - blocks until this element is consumed
	boolean b6 = tq.tryTransfer("a") - returns true if consumed by an awaiting thread or returns false without adding if there was no awaiting consumer
	boolean b7 = tq.tryTransfer("a", 10, MILLISECONDS); - will wait the given time for a consumer
	String i1 = tq.element() - gets without removing throws NoSuchElementException if empty
	String i1 = tq.peek() - gets without removing returns nill if empty
	String i1 = tq.poll() - removes the head of the queue returns null if empty
	String i1 = tq.poll(10, MILLISECONDS) - removes the head of the queue, WAITS UP TO THE TIME SPECIFIED BEFORE RETURNING  returns null if empty
	String i1 = tq.remove() - removes the head of the queue throws NoSuchElementException if empty
	String i1 = tq.take() - removes the head of the queue blocks until an element is ready

4) CyclicBarrier - check code coma.book.ch11.concur.app02.MyCyclicBarrier
p. 1173





