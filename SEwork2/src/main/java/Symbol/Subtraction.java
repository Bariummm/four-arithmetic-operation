package Symbol;

public class Subtraction extends Symbol{

    //设置符号名、优先级、序号
    public Subtraction(){
        this.setName("-");
        this.setPriority(1);
        this.setNO((float) 2);
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
