package Symbol;

public abstract class Symbol {
    public String name;
    public int priority;
    public Float NO;
    //设置符号名、优先级、序号

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getPriority();

    public abstract void setPriority(int priority);

    public abstract Float getNO();

    public abstract void setNO(Float NO);
}
