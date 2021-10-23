
public class Operand {
    private Integer numerator; //定义分子
    private Integer denominator; //定义分母

    public String toString(){
        String operand = null;
        //分析比较分子和分母大小的三种情况
        if(numerator > denominator){
            Integer a = numerator / denominator;
            Integer b = numerator % denominator;
            if(b == 0){
                operand = String.valueOf(a);
            }
            else {
                operand = a + "'" + b + "/" + denominator;
            } //带分数的表示
        }
        else if(numerator < denominator)
            operand = numerator + "/" + denominator;
        else if(numerator == denominator)
            operand = "1";

        return operand;
    }

    public Integer getNumerator(){
        return numerator;
    }

    public void setNumerator(Integer numerator){
        this.numerator = numerator;
    }

    public Integer getDenominator(){
        return denominator;
    }

    public void setDenominator(Integer denominator){
        this.denominator = denominator;
    }

}
