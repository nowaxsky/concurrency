# Lesson 6 - Thread Method Example

https://www.baeldung.com/java-concurrency
https://blog.csdn.net/Evankaka/article/details/44153709
https://blog.csdn.net/evankaka/article/details/51489322

1. SleepDemo
	* sleep(long millis)在指定的毫秒数内让当前正在执行的线程休眠(暂停执行).
	* sleep是讓當前的thread暫停工作, 呼叫繼承Thread的類別的sleep也只能暫停"當前"的執行緒
1. JoinDemo
	* threadB.join()意思為等待B執行緒完成後該程式才會繼續執行, 是主執行緒等待子執行緒的方法.
	* 在很多情况下如果子线程里要进行大量的耗时的运算, 主线程往往将于子线程之前结束, 但是如果主线程处理完其他的事务后需要用到子线程的处理结果, 即主线程需要等待子线程执行完成之后再结束, 这个时候就要用到join()方法了.
1. YieldDemo
	* yield()暂停当前正在执行的线程对象, 把执行机会让给相同或者更高优先级的线程.
	* yield是让当前运行线程回到可运行状态, 所以無法保證yield()达到让步目的, 因为让步的线程还有可能被线程调度程序再次选中.
	* __yield从未导致线程转到等待/睡眠/阻塞状态, 在大多数情况下yield将导致线程从运行状态转到可运行状态, 但有可能没有效果.__
	* yield不會讓給優先級比自己低的執行緒執行, 且讓出的時間不可控(因為只是回到可運行狀態, 和sleep下的不可運行狀態不同).
1. PriorityDemo 
	* setPriority可以設定 1~10, 預設值是5, 數字越大優先權越高.
	* 優先權低不代表一定比較晚執行, 只是代表他們同時競爭相同資源時, 會先給優先權大的.
1. InterruptDemo
	* interrupt()線程發送一個中斷信號，讓線程在等待時(如死鎖時)能拋出InterruptedException
	* __注意: 這個方法不能中斷線程! 只是在等待的地方拋出錯誤, 之後繼續執行該線程.__
	* InterruptedException是线程自己从内部抛出的, 并不是interrupt()方法抛出的. 
	* __对某一线程调用 interrupt()时, 如果该线程正在执行普通的代码, 那么该线程根本就不会抛出InterruptedException. 但是该线程进入到 wait()/sleep()/join()后, 就会立刻抛出InterruptedException.__ 
1. WaitAndNotifyDemo
	* https://www.programcreek.com/2009/02/notify-and-wait-example/
	* https://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
	* wait,与notify是针对已经获取了Obj锁进行操作, 从语法角度来说就是Obj.wait(), Obj.notify必须在synchronized(Obj){...}语句块内.
	* 从功能上来说wait就是说线程在获取对象锁后, 主动释放对象锁, 同时本线程休眠. 直到有其它线程调用对象的notify()唤醒该线程, 才能继续获取对象锁并继续执行. 
	* 的notify()就是对对象锁的唤醒操作. 但有一点需要注意的是notify()调用后, 并不是马上就释放对象锁的, 而是在相应的synchronized(){}语句块执行结束, 自动释放锁后, JVM会在wait()对象锁的线程中随机选取一线程, 赋予其对象锁, 唤醒线程, 继续执行. 
	* Thread.sleep()与Object.wait()二者都可以暂停当前线程, 释放CPU控制权, 主要的区别在于Object.wait()在释放CPU同时, 释放了对象锁的控制.
	* 本例中Waiter1和Waiter2取得message物件者才能執行同步區塊內的程式碼, 假設Waiter1先搶到, 直到呼叫wait()時釋放CPU才輪到Waiter2呼叫.
	* Notifier代碼中故意先睡一秒, 若無等待直接進入同步區塊, 有可能造成死鎖(若Notifier不是最後一個取得物件鎖, 則最後一個取得物件鎖的Waiter無法喚醒).
	* 當Waiter1和Waiter2都在wait過1秒後, Notifier取得物件鎖, 並喚醒其中一個等待的線程(有可能是Waiter1或Waiter2).
	* __注意: 由console可以看出有印出notifier stopped字樣, 代表呼叫notify()並不會立刻喚醒線程, 而是要整個同步區塊執行完才會釋放物件鎖並喚醒線程!__
	* 另一個沒有被喚醒的Waiter則會永遠等待, 請記得terminate!
1. WaitAndNotifyDemo2
	* notifyAll()可以喚醒所有線程, 但有物件鎖的關係, 所以由搶到物件鎖的Waiter先執行.
	* 假設由Waiter1先搶到喚醒的物件鎖, 則Waiter2會在Waiter1執行完成後獲得物件鎖並執行, 最後所有線程均完成.
1. wait和sleep区别
	* 共同點
		1. 他们都是在多线程的环境下, 都可以在程序的调用处阻塞指定的毫秒数, 并返回. 
		2. wait()和sleep()都可以通过interrupt()方法 打断线程的暂停状态 , 从而使线程立刻抛出InterruptedException.
	* 不同點
		1. Thread类的方法：sleep(),yield()等 ; Object的方法：wait()和notify()等.
		2. __sleep方法没有释放锁, 而wait方法释放了锁__, 使得其他线程可以使用同步控制块或者方法. 
		3. wait, notify和notifyAll只能在同步控制方法或者同步控制块里面使用, 而sleep可以在任何地方使用.
	* 總結
		1. sleep()和wait()方法的最大区别是: __sleep()睡眠时, 保持对象锁, 仍然占有该锁; 而wait()睡眠时, 释放对象锁.__
		1. wait()和sleep()都可以通过interrupt()方法打断线程的暂停状态, 从而使线程立刻抛出InterruptedException(但不建议使用该方法).
		 