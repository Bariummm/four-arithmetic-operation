package Symbol;

public class Symbol {
    public String name;
    public int priority;
    public Float NO;
    //设置符号名、优先级、序号

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