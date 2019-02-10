# Appendix - Synchronous Callback

## Callback Definition
1. Define the methods in an interface that we want to invoke after callback.
1. Define a class that will implement the callback methods of the interface.
1. Define a reference in other class to register the callback interface.
1. Use that reference to invoke the callback method.

## Demo
1. Demo1
	* Suppose we want to perform some routine tasks like perform some operation or display content after some clicking a button, or fetching data from internet. This is also used in event handling, as we get notified when a button clicked via callback function.
	* This type of design pattern is used in Observer Design Pattern.
	* The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependent, called observers, and notifies them automatically of any state changes, usually by calling one of their methods( Source:wiki).
	* The code execution will block or wait for the event before continuing. Until your event returns a response your program will not execute any further. 
	* So Basically the callback performs all its work before returning to the call statement. 
	* The problem with synchronous callback is that they appear to lag.

## When to use?
* __Synchronous Callback__
	* Any process having multiple tasks where the tasks must be executed in sequence and doesn’t occupy much time should use Synchronous Callbacks.
	* For example : You’re in a movie queue for ticket you can’t get one until everyone in front of you gets one.
* __Asynchronous Callback__
	* When the tasks are not dependent on each other and may take some time for execution we should use Asynchronous Callbacks.
	* For example: When you order your food other people can also order their food in the restaurant. They don’t have to wait for your order to finish, If you’re downloading a song from internet, Getting an API response.