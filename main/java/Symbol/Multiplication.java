package Symbol;

public class Multiplication extends Symbol{

    //设置符号名、优先级、序号
    public Multiplication(){
        this.setName("×");
        this.setPriority(2);
        this.setNO((float) 3);
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
