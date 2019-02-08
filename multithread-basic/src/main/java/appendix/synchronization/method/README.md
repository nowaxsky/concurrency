# Appendix - Synchronization

https://blog.csdn.net/zhangqiluGrubby/article/details/80500505<br>

## Synchronized 修飾對象
#### 1. 修饰一个代码块, 被修饰的代码块称为同步语句块, 其作用的范围是大括号{}括起来的代码, 作用的对象是调用这个代码块的对象.
#### 2. 修饰一个方法, 被修饰的方法称为同步方法, 其作用的范围是整个方法, 作用的对象是调用这个方法的对象.
#### 3. 修饰一个静态的方法, 其作用的范围是整个静态方法, 作用的对象是这个类的所有对象.
#### 4. 修饰一个类, 其作用的范围是synchronized后面括号括起来的部分, 作用主的对象是这个类的所有对象. 

## Demo
1. MethodDemo
	* 修飾整個方法, 鎖住該段程式碼, 和代碼區塊的寫法相似(略有不同).
	* 但這個做法沒有物件對象, 所以無法做到鎖住物件對象.
	* 以下兩種寫法等效:
	```java
	public synchronized void method() {
		// todo
	}

	public void method() {
		synchronized(this) {
			// todo
		}
	}

	```

1. synchronized关键字不能继承(Parent, Child)
	* 虽然可以使用synchronized来定义方法, 但synchronized并不属于方法定义的一部分, 因此, synchronized关键字不能被继承. 
	* 如果在父类中的某个方法使用了synchronized关键字, 而在子类中覆盖了这个方法, 在子类中的这个方法默认情况下并不是同步的, 而必须显式地在子类的这个方法中加上synchronized关键字才可以. 当然, 还可以在子类方法中调用父类中相应的方法, 这样虽然子类中的方法不是同步的, 但子类调用了父类的同步方法, 因此, 子类的方法也就相当于同步了. 这两种方式的例子代码如下:  
	```java
	class Parent {
		public synchronized void method() { }
	}
	
	class Child extends Parent {
   		public synchronized void method() { }
	}
	```
在子类方法中加上synchronized关键字
	```
	class Parent {
   		public synchronized void method() { }
	}
	
	class Child extends Parent {
   		public void method() { 
   			super.method();
   		}
	}
	```

1. synchronized方法的缺陷
	* 同步方法, 这时synchronized锁定的是哪个对象呢? 它锁定的是调用这个同步方法对象.
	* 当一个对象 P1在不同的线程中执行这个同步方法时, 它们之间会形成互斥, 达到同步的效果. 但是这个对象所属的Class所产生的另一对象P2却可以任意调用这个被加 了synchronized关键字的方法.
	* 同步方法实质是将synchronized作用于object reference. 线程拿到了P1对象锁, 才可以调用P1的同步方法, 而对P2而言, P1这个锁与它毫不相干, 程序也可能在这种情形下摆脱同步机制的控制, 造成数据混乱. 
	* 若将一个大的方法声明为synchronized 将会大大影响效率, 典型地, 若将线程类的方法 run()声明为 synchronized, 由于在线程的整个生命期内它一直在运行, 因此将导致它对本类任何 synchronized方法的调用都永远不会成功. 
	* 当然我们可以通过将访问类成员变量的代码放到专门的方法中, 将其声明为 synchronized, 并在主方法中调用来解决这一问题, 但是 Java为我们提供了更好的解决办法, 那就是synchronized代码块(上面已经说了). 
