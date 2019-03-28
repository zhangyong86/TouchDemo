# TouchDemo
事件分发机制
Touch事件分发：
	the touch down action that begins a touch gesture
解释：DOWN，MOVE和UP事件都是交给同一对象来处理，完整的touch gesture.

View：dispatchTouchEvent、onTouchEvent
ViewGroup：dispatchTouchEvent、dispatchTouchEvent、onTouchEvent

1	TextView的打印：

	DOWN事件会走ViewGroup和View的流程最后交给Activity处理，但是MOVE和UP分发之后直接交给Activity来处理。
2	TextView的打印（ViewGroup的onIntercepTouchEvent return true）：

	ViewGroup拦截之后，不会将事件分发到子View中，但ViewGroup的onTouchEvent没有消费true，最后还是交给Activity来处理。
3	TextView的打印（在2的基础上，添加ViewGroup onTouch return true）：

	ViewGroup拦截事件并消费之后，DOWN事件处理完成，再分发MOVE和UP事件，都是交给ViewGroup来处理。即使gesture在滑动过程中，移出ViewGroup的区域，MOVE和UP事件同样交给ViewGroup来处理（见手势遥控器音量控制滑动）。
4	TextView的打印（在1的基础上，添加android:clickable="true"）

	clickable表示View可被点击或者长按点击（long_clickable）或者通过设置setOnClickListener,事件被View消费（等同于Button的打印）。
5	Button的打印（ViewGroup的onIntercepTouchEvent return true）：

	ViewGroup拦截并没有在onTouchEvent进行消费（true），并调用super交给Activity来处理，但阻止的事件下发给View。
6	Button的打印（ViewGroup的拦截Move和Up事件）：

	DOWN事件正常分发并被处理，UP事件被拦截之后cancel
问题：
λ	为什么DOWN事件被Activity消费，MOVE和UP不向下分发？
λ	为什么6被拦截之后直接结束了，代码中如何判断的？

	在ViewGroup源码中，dispatchTouchEvent中DOWN事件时将mMotionTarget置为null，当child.dispatchTouchEvent(ev)返回true，则为mMotionTarget=child;然后return true;（相当于子View消费了事件，会把这个子View保存下来）。然后在Move和Up的时候如果没有拦截的情况下，直接调用mMotionTarget dispatchTouchEvent来分发下去。

Activity的事件分发：

DOWN执行onUerInteraction，可重写在Activity中，之后调用getWindow()返回的是PhoneWindow对象，内部调用DecorView对象的dispatchTouchEvent分发（DecorView是FrameLayout的子类），所以也就是调用ViewGroup的事件分发，没有消费，直接onTouchEvent进行消费。

总结：
1、如果ViewGroup找到了能够处理该事件的View，则直接交给子View处理，自己的onTouchEvent不会被触发；

2、可以通过复写onInterceptTouchEvent(ev)方法，拦截子View的事件（即return true），把事件交给自己处理，则会执行自己对应的onTouchEvent方法

3、子View可以通过调用getParent().requestDisallowInterceptTouchEvent(true);  阻止ViewGroup对其MOVE或者UP事件进行拦截；
