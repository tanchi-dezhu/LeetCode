package util.lock;

public class Resource
{
    //一辆车对应一个id
    private int id;
    //车名
    private String name;
    //车的轮子数
    private int wheelNumber;
    //标记(后面会用到)
    private boolean flag = false;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getWheelNumber()
    {
        return wheelNumber;
    }

    public void setWheelNumber(int wheelNumber)
    {
        this.wheelNumber = wheelNumber;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public String toString()
    {
        return "id=" + id + "--- name=" + name + "--- wheelNumber=" + wheelNumber;
    }
}
