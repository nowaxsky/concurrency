# Appendix - Synchronization

## Synchronized 修飾對象
1. 修饰一个代码块, 被修饰的代码块称为同步语句块, 其作用的范围是大括号{}括起来的代码, 作用的对象是调用这个代码块的对象.
1. 修饰一个方法, 被修饰的方法称为同步方法, 其作用的范围是整个方法, 作用的对象是调用这个方法的对象.
1. 修饰一个静态的方法, 其作用的范围是整个静态方法, 作用的对象是这个类的所有对象.
1. 修饰一个类, 其作用的范围是synchronized后面括号括起来的部分, 作用主的对象是这个类的所有对象. 

## Reference
https://blog.csdn.net/zhangqiluGrubby/article/details/80500505
