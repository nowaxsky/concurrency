# Appendix - Callback Method

## Callback Definition
1. Define the methods in an interface that we want to invoke after callback.
1. Define a class that will implement the callback methods of the interface.
1. Define a reference in other class to register the callback interface.
1. Use that reference to invoke the callback method.

## When to use?
* __Synchronous Callback__
	* Any process having multiple tasks where the tasks must be executed in sequence and doesn’t occupy much time should use Synchronous Callbacks.
	* For example : You’re in a movie queue for ticket you can’t get one until everyone in front of you gets one.
* __Asynchronous Callback__
	* When the tasks are not dependent on each other and may take some time for execution we should use Asynchronous Callbacks.
	* For example: When you order your food other people can also order their food in the restaurant. They don’t have to wait for your order to finish, If you’re downloading a song from internet, Getting an API response.
	
## Callback vs Observer
* Callback是一種特殊的觀察者模式, 和觀察者模式的差別在於回調函數中被觀察者只保存了一個觀察者, 觀察者模式保存了全部的觀察者列表.
* 觀察者模式是一對多關係, 回調函數是一對一關係.

## Reference
https://blog.csdn.net/xiaanming/article/details/8703708<br>
https://www.geeksforgeeks.org/asynchronous-synchronous-callbacks-java/<br>
https://www.jianshu.com/p/dbebb0279ecc<br>
https://blog.csdn.net/cauchyweierstrass/article/details/44593807