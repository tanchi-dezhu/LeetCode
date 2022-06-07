package util.lock;

public class Input implements Runnable
{
    private Resource r;

    public Input(Resource r)
    {
        this.r = r;
    }

    public void run()
    {
        //无限生产车辆
        for (int i = 0; ; i++)
        {
            synchronized (r)
            {
                if (i % 2 == 0)
                {
                    r.setId(i);//设置车的id
                    r.setName("小汽车");//设置车类型
                    r.setWheelNumber(4);//设置车的轮子数
                } else
                {
                    r.setId(i);//设置车的id
                    r.setName("电动车");//设置车类型
                    r.setWheelNumber(2);//设置车的轮子数
                }
            }
        }
    }
}
