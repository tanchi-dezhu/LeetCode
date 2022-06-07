package util.lock;

public class LockTest
{
    public static void main(String[] args)
    {
        //资源对象，对应车辆
        Resource r = new Resource();

        //生产者runnable，对应工人
        Input in = new Input(r);

        //消费者runnable，对应销售员
        Output out = new Output(r);
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        //开启生产者线程
        t1.start();

        //开启消费者线程
        t2.start();
    }
}
