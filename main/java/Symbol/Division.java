package Symbol;

public class Division extends Symbol{
    public String name;
    public int priority;
    public Float NO;
    //设置符号名、优先级、序号
    public Division(){
        this.setName("÷");
        this.setPriority(2);
        this.setNO((float) 4);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public Float getNO(){
        return NO;
    }

    public void setNO(Float NO){
        this.NO = NO;
    }
}
