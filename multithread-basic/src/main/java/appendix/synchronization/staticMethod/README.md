# Appendix - Synchronization

https://blog.csdn.net/zhangqiluGrubby/article/details/80500505<br>

## Synchronized 修飾對象
#### 1. 修饰一个代码块, 被修饰的代码块称为同步语句块, 其作用的范围是大括号{}括起来的代码, 作用的对象是调用这个代码块的对象.
#### 2. 修饰一个方法, 被修饰的方法称为同步方法, 其作用的范围是整个方法, 作用的对象是调用这个方法的对象.
#### 3. 修饰一个静态的方法, 其作用的范围是整个静态方法, 作用的对象是这个类的所有对象.
#### 4. 修饰一个类, 其作用的范围是synchronized后面括号括起来的部分, 作用主的对象是这个类的所有对象. 

## Demo
1. StaticMethodDemo
	* 静态方法是属于类的而不属于对象的. 同样的, synchronized修饰的静态方法锁定的是这个类的所有对象.
	* threadA和threadB是ThreadSyn的两个对象, 但在thread1和thread2并发执行时却保持了线程同步. 这是因为run中调用了静态方法method, 而静态方法是属于类的, 所以threadA和threadB相当于用了同一把锁。
