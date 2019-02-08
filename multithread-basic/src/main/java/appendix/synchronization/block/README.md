# Appendix - Synchronization

https://blog.csdn.net/zhangqiluGrubby/article/details/80500505<br>

## Synchronized 修飾對象
#### 1. 修饰一个代码块, 被修饰的代码块称为同步语句块, 其作用的范围是大括号{}括起来的代码, 作用的对象是调用这个代码块的对象.
#### 2. 修饰一个方法, 被修饰的方法称为同步方法, 其作用的范围是整个方法, 作用的对象是调用这个方法的对象.
#### 3. 修饰一个静态的方法, 其作用的范围是整个静态方法, 作用的对象是这个类的所有对象.
#### 4. 修饰一个类, 其作用的范围是synchronized后面括号括起来的部分, 作用主的对象是这个类的所有对象. 

## Demo
1. CodeBlockDemo
	* 当两个并发线程(thread1和thread2)访问同一个对象(这个很重要)(ThreadSyn)中的synchronized代码块时, 在同一时刻只能有一个线程得到执行, 另一个线程受阻塞, 必须等待当前线程执行完这个代码块以后才能执行该代码块. Thread1和thread2是互斥的, 因为在执行synchronized代码块时会锁定当前的对象, 只有执行完该代码块才能释放该对象锁, 下一个线程才能执行并锁定该对象, 一个对象就一个锁.
	* __注意: 因為是同一物件, 所以count不斷疊加__
1. CodeBlockDemo2
	* 当多个线程访问 不同对象 的同步代码块, 线程访问各自同步代码块, 线程不会阻塞, 互不干扰.
	* __注意: 不同物件, 所以count不會疊加__
1. CodeBlockDemo3
	* 訪問synchronized之外的代碼不受影響.
1. ThreadSyn3
	* 当没有明确的对象作为锁, 只是想让一段代码同步时, 可以创建一个特殊的对象(byte[] lock)来充当锁.
1. CodeBlockDemo4
	* 使用外來的物件當作鎖, 證明下列事實: __synchronized(a)是鎖住物件a, 如果有其他的synchronized要使用物件a是不行的__.
	
## 總結: synchronized(a){}
#### 1. 鎖住該段程式碼, 直到物件a釋放鎖.
#### 2. 鎖住物件a, 其他synchronized要使用物件a是不行的.