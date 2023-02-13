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

-----------------------------------
Executors:
To create pool dynamically:
ExecutorService executorService = Executors.newFixedThreadPool(4);
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        tpe.setCorePoolSize(4);
        tpe.setMaximumPoolSize(8);

--------------------------------------
Callable and Future
To get result of Callable: future.get()-->
you need to handle 2 exceptions:
    -InterruptedException Raised when the thread calling the Future’s
        get() method is interrupted before a result can be returned
    -ExecutionException Raised when an exception was thrown during
        the execution of the Callable’s call() method

Future<String> res = executorService.submit(() -> "Test");
        try {
            String text = res.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

-----------------------------------------------
java.util.concurrent.ThreadLocalRandom
 Math.random() - is thread-safe, but suffers when multithreaded
 A ThreadLocalRandom is unique to a thread and will perform better because it avoids any contention.
 Might have same values:
ThreadLocalRandom random = ThreadLocalRandom.current();
        for(int i=0;i<10;i++) {
            int res = random.nextInt(0, 10);
            System.out.println(res);
        }


-----------------------------------------------
Close Executor:
- void executorService.shutdown(); - graceful shutdown
    will not stop already submitted tasks, but will not accept new tasks
- List<Runnable> executorService.shutdownNow(); - immediate shutdown.
Will typically call Thread.interrupt() in an attempt to terminate any unfinished tasks.


-------------------------------------------------------
ForkJoinPool
        ForkJoinPool.commonPool();
        new ForkJoinPool();
        new ForkJoinPool(10);
        int p = Runtime.getRuntime().availableProcessors();

Fork:
With the Fork/Join Framework, each thread in the ForkJoinPool has a
queue of the tasks it is working on; this is unlike most ExecutorService
implementations that have a single shared task queue. The fork() method
places a ForkJoinTask in the current thread’s task queue. A normal thread
does not have a queue of tasks—only the specialized threads in a
ForkJoinPool do. This means that you can only call fork() if you are within
a ForkJoinTask that is being executed by a ForkJoinPool.

Join:
When you call join() on the (left) task, it should be one of the last steps in
the compute method, after calling fork() and compute(). Calling join()
says, “I can only proceed when this (left) task is done.” Several possible
things can happen when you call join():
The task you call join() on might already be done. Remember you
are calling join() on a task that already had fork() called. The task
might have been stolen and completed by another thread. In this case,
calling join() just verifies the task is complete and you can continue
on.
The task you call join() on might be in the middle of being
processed. Another thread could have stolen the task, and you’ll have
to wait until the joined task is done before continuing.
The task you call join() on might still be in the queue (not stolen). In
this case, the thread calling join() will execute the joined task.

RecursiveAction:
protected abstract void compute();

RecursiveTask:
protected abstract V compute();

FJP.invoke(RecursiveAction or RecursiveTask) - blocking method;

-------------------------------------------------------
Parallel streams

List<Integer> nums =...;
Stream<Integer> myStream = nums.parallelStream();

ForkJoinPool fjp = new ForkJoinPool(2);
fjp.submit(Stream<Integer> myStream = nums.parallelStream(););


Associative Operations - p.1212

