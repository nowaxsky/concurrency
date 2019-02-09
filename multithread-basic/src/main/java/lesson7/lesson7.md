# Lesson 7 - Thread Noun

https://www.baeldung.com/java-concurrency
https://blog.csdn.net/Evankaka/article/details/44153709
https://blog.csdn.net/evankaka/article/details/51489322

1. 主线程：JVM调用程序main()所产生的线程. 
1. 当前线程：这个是容易混淆的概念. 一般指通过Thread.currentThread()来获取的进程. 
1. 守护线程：指为其他线程提供服务的线程, 也称为后台线程. JVM的垃圾回收线程就是一个后台线程. __用户线程和守护线程的区别在于, 是否等待主线程依赖于主线程结束而结束.(JVM會在所有的用戶線程結束後關閉, 亦即當所有的線程均為守護線程時, JVM會關閉)__
1. 前台线程：是指接受后台线程服务的线程, 其实前台后台线程是联系在一起, 就像傀儡和幕后操纵者一样的关系. 傀儡是前台线程、幕后操纵者是后台线程. 由前台线程创建的线程默认也是前台线程. 可以通过isDaemon()和setDaemon()方法来判断和设置一个线程是否为后台线程. __(调用线程对象的方法setDaemon(true), 则可以将其设置为守护线程. )__
1. 線程常用方法: 
	* sleep(n): 强迫一个线程睡眠n毫秒.  
	* isAlive(): 判断一个线程是否存活.  
	* join(): 等待线程终止.  
	* activeCount(): 程序中活跃的线程数.  
	* enumerate(): 枚举程序中的线程.  
	* currentThread(): 得到当前线程.  
	* isDaemon(): 一个线程是否为守护线程.  
	* setDaemon(): 设置一个线程为守护线程. (用户线程和守护线程的区别在于, 是否等待主线程依赖于主线程结束而结束) 
	* setName(): 为线程设置一个名称.  
	* wait(): 强迫一个线程等待.  
	* notify(): 通知一个线程继续运行.  
	* setPriority(): 设置一个线程的优先级. 
