# Lesson 3 - Thread vs Runnable

如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。

总结：
实现Runnable接口比继承Thread类所具有的优势：
1. 适合多个相同的程序代码的线程去处理同一个资源
1. 可以避免java中的单继承的限制
1. 增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
1. 线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类
