package Symbol;

public class Addition {

    public String name;
    public int priority;
    public int NO;
    //设置符号名、优先级、序号
    public Addition(){
        this.setName("+");
        this.setPriority(1);
        this.setNO(1);
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

    public int getNO(){
        return NO;
    }

    public void setNO(int NO){
        this.NO = NO;
    }
}
