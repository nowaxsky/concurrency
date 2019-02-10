# Lesson 8 - Thread Wait and Notify

## Thread Status

![Alt text](./l4.jpg "Thread Status")

1. 新建状态（New）：新创建了一个线程对象。
1. 就绪状态（Runnable）：线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权。
1. 运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码。
1. 阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
	* 等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。(wait会释放持有的锁)
	* 同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
	* 其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。（注意,sleep是不会释放持有的锁）
1. 死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。

## Thread 調度

1. 调整线程优先级: 
	* Java线程有优先级，优先级高的线程会获得较多的运行机会。
	* Java线程的优先级用整数表示，取值范围是1~10，Thread类有以下三个静态常量：
		1. static int MAX_PRIORITY: 线程可以具有的最高优先级，取值为10。
		1. static int MIN_PRIORITY: 线程可以具有的最低优先级，取值为1。
		1. static int NORM_PRIORITY: 分配给线程的默认优先级，取值为5。
	* Thread类的setPriority()和getPriority()方法分别用来设置和获取线程的优先级。
 	* 每个线程都有默认的优先级。主线程的默认优先级为Thread.NORM_PRIORITY。
	* 线程的优先级有继承关系，比如A线程中创建了B线程，那么B将和A具有相同的优先级。
	* JVM提供了10个线程优先级，但与常见的操作系统都不能很好的映射。如果希望程序能移植到各个操作系统中，应该仅仅使用Thread类有以下三个静态常量作为优先级，这样能保证同样的优先级采用了同样的调度方式。
	* setPriority可以設定 1~10, 預設值是5, 數字越大優先權越高.
	* 優先權低不代表一定比較晚執行, 只是代表他們同時競爭相同資源時, 會先給優先權大的.
1. 线程睡眠:
	* Thread.sleep(long millis)方法，使线程转到阻塞状态。millis参数设定睡眠的时间，以毫秒为单位。当睡眠结束后，就转为就绪（Runnable）状态。sleep()平台移植性好。
	* sleep(long millis)在指定的毫秒数内让当前正在执行的线程休眠(暂停执行).
	* sleep是讓當前的thread暫停工作, 呼叫繼承Thread的類別的sleep也只能暫停"當前"的執行緒
1. join:
	* 等待其他线程终止。在当前线程中调用另一个线程的join()方法，则当前线程转入阻塞状态，直到另一个进程运行结束，当前线程再由阻塞转为就绪状态。
	* threadB.join()意思為等待B執行緒完成後該程式才會繼續執行, 是主執行緒等待子執行緒的方法.
	* 在很多情况下如果子线程里要进行大量的耗时的运算, 主线程往往将于子线程之前结束, 但是如果主线程处理完其他的事务后需要用到子线程的处理结果, 即主线程需要等待子线程执行完成之后再结束, 这个时候就要用到join()方法了.
1. 線程讓步:
	* yield()暂停当前正在执行的线程对象, 把执行机会让给相同或者更高优先级的线程.
	* yield是让当前运行线程回到可运行状态, 所以__無法保證yield()达到让步目的__, 因为让步的线程还有可能被线程调度程序再次选中.
	* __yield从未导致线程转到等待/睡眠/阻塞状态, 在大多数情况下yield将导致线程从运行状态转到可运行状态, 但有可能没有效果.__
	* yield不會讓給優先級比自己低的執行緒執行, 且讓出的時間不可控(因為只是回到可運行狀態, 和sleep下的不可運行狀態不同).
1. __線程中斷:__
	* interrupt()線程發送一個中斷信號，讓線程在等待時(如死鎖時)能拋出InterruptedException.
	* __注意: 這個方法不能真的中斷線程! 只是在等待的地方拋出錯誤, 之後繼續執行該線程.__
	* InterruptedException是线程自己从内部抛出的, 并不是interrupt()方法抛出的. 
	* __对某一线程调用 interrupt()时, 如果该线程正在执行普通的代码, 那么该线程根本就不会抛出InterruptedException. 但是该线程进入到 wait()/sleep()/join()后, 就会立刻抛出InterruptedException.__
1. 線程暫停與喚醒:
	* Object类中的notify()方法，唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，并在对实现做出决定时发生。线程通过调用其中一个 wait 方法，在对象的监视器上等待。 直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。类似的方法还有一个notifyAll()，唤醒在此对象监视器上等待的所有线程。注意：Thread中suspend()和resume()两个方法在JDK1.5中已经废除，不再介绍。因为有死锁倾向。
	* WaitAndNotifyDemo:
		* wait,与notify是针对已经获取了Obj锁进行操作, 从语法角度来说就是Obj.wait(), Obj.notify必须在synchronized(Obj){...}语句块内.
		* 从功能上来说wait就是说线程在获取对象锁后, 主动释放对象锁, 同时本线程休眠. 直到有其它线程调用对象的notify()唤醒该线程, 才能继续获取对象锁并继续执行. 
		* 的notify()就是对对象锁的唤醒操作. 但有一点需要注意的是notify()调用后, 并不是马上就释放对象锁的, 而是在相应的synchronized(){}语句块执行结束, 自动释放锁后, JVM会在wait()对象锁的线程中随机选取一线程, 赋予其对象锁, 唤醒线程, 继续执行. 
		* Thread.sleep()与Object.wait()二者都可以暂停当前线程, 释放CPU控制权, 主要的区别在于Object.wait()在释放CPU同时, 释放了对象锁的控制.
		* 本例中Waiter1和Waiter2取得message物件者才能執行同步區塊內的程式碼, 假設Waiter1先搶到, 直到呼叫wait()時釋放CPU才輪到Waiter2呼叫.
		* Notifier代碼中故意先睡一秒, 若無等待直接進入同步區塊, 有可能造成死鎖(若Notifier不是最後一個取得物件鎖, 則最後一個取得物件鎖的Waiter無法喚醒).
		* 當Waiter1和Waiter2都在wait過1秒後, Notifier取得物件鎖, 並喚醒其中一個等待的線程(有可能是Waiter1或Waiter2).
		* __注意: 由console可以看出有印出notifier stopped字樣, 代表呼叫notify()並不會立刻喚醒線程, 而是要整個同步區塊執行完才會釋放物件鎖並喚醒線程!__
		* 另一個沒有被喚醒的Waiter則會永遠等待, 請記得terminate!
	* WaitAndNotifyDemo2:
		* notifyAll()可以喚醒所有線程, 但有物件鎖的關係, 所以由搶到物件鎖的Waiter先執行.
		* 假設由Waiter1先搶到喚醒的物件鎖, 則Waiter2會在Waiter1執行完成後獲得物件鎖並執行, 最後所有線程均完成.
	* 參考資料:
		* https://www.programcreek.com/2009/02/notify-and-wait-example/
		* https://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
		
## wait vs sleep
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