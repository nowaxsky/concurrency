# Appendix - Asynchronous Callback

## Callback Definition
1. Define the methods in an interface that we want to invoke after callback.
1. Define a class that will implement the callback methods of the interface.
1. Define a reference in other class to register the callback interface.
1. Use that reference to invoke the callback method.

## Demo
1. Demo1
	* Callback:
		1. Define the methods in an interface that we want to invoke after callback.
		1. Define a class that will implement the callback methods of the interface.
		1. Define a reference in other class to register the callback interface.
		1. Use that reference to invoke the callback method.
	* An Asynchronous call do not block the program from the code execution. when the call returns from the event the call returns back to the callback function. So in the context of java we have to Create a new thread invoke the callback method inside that thread. Callback may be invoked from a thread but is not a requirement.

1. Demo2(CallBack, Li, Wang)
	* 回調函數經典應用場景: 
		1. class A 實現介面 CallBack
		1. class A 中包含一個 class B 的引用 b
		1. class B 有一個參數為 callback的方法f(CallBack callback)
		1. 物件 a 調用 B 的方法 f(CallBack callback) ——A類調用B類的某個方法 C
		1. b 就可以在f(CallBack callback)方法中調用 A 的方法 ——B類調用A類的某個方法D
	* 情境如下:
		1. 有一天小王遇到一个很难的问题，问题是“1 + 1 = ?”.
		1. 小王不會只好打电话问小李，小李一下子也不知道，就跟小王说，等我办完手上的事情(看電影)，就去想想答案.
		1. 小王也不会傻傻的拿着电话去等小李的答案吧，于是小王就对小李说，我还要去逛街，你知道了答案就打我电话告诉我，于是挂了电话，自己办自己的事情.
		1. 过了一个小时，小李打了小王的电话，告诉他答案是2.
	* 這邊由於Wang.askQuestion中的Thread啟動時間不一定比原執行緒執行play()晚, 所以才有可能出現"小王繼續逛街!!!"在前, "問題太難! 先打電話給小李!"在後的現象.
	* 物件 a 調用 B 的方法 f(CallBack callback), 因為不用解題需要時間且無法立刻獲得回覆, 所以f這個方法不需要回傳值.
	* 雖然f沒有回傳任何結果, 但結果會在b獲得後透過A的方法讓a知道

## When to use?
* __Synchronous Callback__
	* Any process having multiple tasks where the tasks must be executed in sequence and doesn’t occupy much time should use Synchronous Callbacks.
	* For example : You’re in a movie queue for ticket you can’t get one until everyone in front of you gets one.
* __Asynchronous Callback__
	* When the tasks are not dependent on each other and may take some time for execution we should use Asynchronous Callbacks.
	* For example: When you order your food other people can also order their food in the restaurant. They don’t have to wait for your order to finish, If you’re downloading a song from internet, Getting an API response.
