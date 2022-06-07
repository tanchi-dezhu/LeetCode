package util.lock;

public class Output implements Runnable
{
    private Resource r;

    public Output(Resource r)
    {
        this.r = r;
    }

    public void run()
    {
        //无限消费车辆
        for (; ; )
        {
            synchronized (r)
            {
                //消费车辆
                System.out.println(r.toString());
            }
        }
    }
}
