package cn.bt.btdemo.test;

public class TestReentrankLock {
    private ReentrankLock reentrankLock = new ReentrankLock();
    public void a() throws InterruptedException {
        reentrankLock.lock();
        System.out.println("first");
        doSomething();
        reentrankLock.unlock();
    }

    public void doSomething() throws InterruptedException {
        reentrankLock.lock();
        System.out.println("second");
        reentrankLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        new TestReentrankLock().a();
    }
}

class ReentrankLock{
    //是否占用
    private boolean isLocked = false;
    //是否为当前线程
    private Thread currentThread = null;
    //对象锁计数器
    private int holdCount = 0;

    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        if(isLocked && t != currentThread){//占用
            wait();
        }

        //如果没有占用
        isLocked = true;//改为占用状态
        currentThread = t;//赋值为当前线程
        holdCount++;//计数器加一
    }

    //释放锁
    public synchronized void unlock(){
        if(Thread.currentThread() == currentThread){
            holdCount--;//计数器减一
            if(holdCount == 0){
                isLocked = false;
                notify();
                currentThread = null;
            }
        }

    }
}