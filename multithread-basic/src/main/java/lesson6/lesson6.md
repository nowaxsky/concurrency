# Lesson 6 - Thread Method Example

http://larry850806.github.io/2016/06/10/Java-Thread/
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
1. WaitDemo
	* 
1. 线程唤醒：Object类中的notify()方法，唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，并在对实现做出决定时发生。线程通过调用其中一个 wait 方法，在对象的监视器上等待。 直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。类似的方法还有一个notifyAll()，唤醒在此对象监视器上等待的所有线程。注意：Thread中suspend()和resume()两个方法在JDK1.5中已经废除，不再介绍。因为有死锁倾向。
