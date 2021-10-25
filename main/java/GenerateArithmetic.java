
import Symbol.*;

import java.util.*;

public class GenerateArithmetic {
    //生成随机数
    public Integer getRandomNumber(int range){

        Random randomnumber = new Random();
        Integer RandomNumber = randomnumber.nextInt(range);
        return RandomNumber;
    }

    public List<Operand>operandList; //运算数链表
    public List<Operand>operandList2; //用以存储原数据
    public List<Symbol>NOList; //符号链表
    public List<Symbol>NOList2; //用以存储原数据
    public List<Integer>bracketList; //括号链表
    //运算结果链表和字符串
    List<String>resultList = new ArrayList<String>();
    String resultCollection = null;
    //将问题存入HashMap中
    Map<String,Boolean>Collection = new HashMap<String, Boolean>();

    public void generateArithmetic(int n,int r) throws Exception{

        List<Float>operandCollection; //数字的集合
        List<Symbol>symbolCollection; //符号的集合
        List<Float> NOCollection; //符号序号的集合

        for(int i = 0;i < n; ){
            String question = generateQuestion(r); //调用生成问题的方法
            String result = calculateQuestion(); //调用计算问题的方法

            //若返回空值判断生成问题不符合，跳过
            if(question == null){
                continue;
            }
            if(result == null){
                continue;
            }

            operandCollection = new ArrayList<Float>();
            symbolCollection = new ArrayList<Symbol>();
            NOCollection = new ArrayList<Float>();

            for(Operand operand: operandList2){
                operandCollection.add(operand.getValue()); //取运算数的值
            }

            for(Symbol Symbol:NOList2){
                NOCollection.add(Symbol.getNO()); //取符号的序号
            }

            //这里插入对运算数和运算符的排序
            sort(operandCollection,0,operandCollection.size() - 1);
            sort(NOCollection,0,NOCollection.size() - 1);

            for(int j = 0;j < NOCollection.size();j++){
                Float NO = NOCollection.get(j);
                if(NO == 1){
                    symbolCollection.add(new Addition());
                }
                else if(NO == 2){
                    symbolCollection.add(new Subtraction());
                }
                else if(NO == 3){
                    symbolCollection.add(new Multiplication());
                }
                else if(NO == 4){
                    symbolCollection.add(new Division());
                }
            }

            StringBuilder questionmessage;
            questionmessage = new StringBuilder();

            for(Float oper:operandCollection){
                questionmessage.append(oper+"");
            }

            for(Symbol Symbol:symbolCollection){
                questionmessage.append(Symbol.getName()+"");
            }

            questionmessage.append(resultCollection);
            String message = questionmessage.toString(); //将上述循环所得信息写入信息字符串中

            //通过在Collection中查找字符串判断是否出现题目重复
            if(Collection.get(message) != null){
                System.out.println("题目重复。");
                continue;
            }

            //保存结果 resultList.add(result);

            System.out.println(i+1+"、题目："+question);
            System.out.println("答案:"+result);
            i++;
            Collection.put(message,true);
        }

        StringBuilder Questions = new StringBuilder();
        StringBuilder Answers = new StringBuilder();
        QAFiles.QAFiles(Questions.toString(),"Questiongs.txt");
        QAFiles.QAFiles(Answers.toString(),"Answers.txt");

    }

    //生成问题的方法
    public String generateQuestion(int r)throws Exception{
        operandList = new ArrayList<Operand>();
        operandList2 = new ArrayList<Operand>();
        NOList = new ArrayList<Symbol>();
        NOList2 = new ArrayList<Symbol>();
        bracketList = new ArrayList<Integer>();

        Integer RandomNumber = getRandomNumber(3) + 2; //问题中的运算数个数
        Integer SymbolNumber = RandomNumber - 1; //问题中的运算符号个数
        Integer BracketNumber = null; //括号内的运算符号个数

        try{
            BracketNumber = getRandomNumber(SymbolNumber);
        }catch (Exception e){

        }

        Integer bracketPos = null; //定义括号的Pos序号
        if(BracketNumber == 1){
            bracketPos = getRandomNumber(SymbolNumber);
            bracketList.add(bracketPos);
        }
        else if(BracketNumber == 2){
            bracketPos = getRandomNumber(2);
            bracketList.add(bracketPos);
            bracketList.add(bracketPos + 1);
        }

        //生成随机数运算数
        for(int i = 0;i < RandomNumber;i++){
            Integer numerator = getRandomNumber(r - 1) + 1; //生成随机数分子
            Integer denominator = getRandomNumber(r - 1) + 1; //生成随机数分母
            Operand operand = new Operand();
            operand.setNumerator(numerator);
            operand.setDenominator(denominator);
            operandList.add(operand);
            operandList2.add(operand);
        }

        //生成随机运算符号
        for(int i = 0;i < SymbolNumber;i++){
            Integer a = getRandomNumber(4);
            Symbol Symbol = null;
            //通过序号得到符号
            switch (a){
                case 0:
                    Symbol = new Addition();
                    break;
                case 1:
                    Symbol = new Subtraction();
                    break;
                case 2:
                    Symbol = new Multiplication();
                    break;
                case 3:
                    Symbol = new Division();
                    break;
            }
            NOList.add(Symbol);
            NOList2.add(Symbol);
        }

        StringBuilder question = new StringBuilder();
        for(int i = 0;i < RandomNumber;i++){
            if(i == RandomNumber - 1){
                question.append("" + "b");
            }else{
                question.append("" + "b");
            }

            try{
                question.append("" + NOList.get(i).getName());
            }catch (Exception e){

            }
        }

        //括号加入
        try{
            Integer bracketFrom = bracketList.get(0);
            Integer bracketTo = null;
            if(BracketNumber == 2){
                bracketTo = bracketList.get(1);
            }
            if(BracketNumber == 1){
                question.setCharAt((bracketFrom * 4) + 3 - 3,'(');
                question.setCharAt((bracketFrom * 4) + 3 - 3,')');
            }
            else if(BracketNumber == 2){
                question.setCharAt((bracketFrom * 4) + 3 - 3,'(');
                question.setCharAt((bracketTo * 4) + 3 - 3,')');
            }
        }catch (Exception e){

        }

        String stb = question.toString();
        String[] bs = stb.split("b");
        StringBuilder bstring = new StringBuilder();
        for(int i = 0;i < bs.length;i++){
            if(i == bs.length - 1){
                bstring.append(bs[i]);
            }else{
                bstring.append(bs[i]).append(operandList.get(i));
            }
        }
        bstring.append("=");

        //格式化字符串
        String result = bstring.toString();
        result = result.replace("(","(");
        result = result.replace(")",")").trim();

        return result;
    }


    //计算问题的方法
    public String calculateQuestion()throws Exception{
        Operand SUM = null;
        while(NOList.size() != 0){
            SUM = new Operand();

            //获得括号位置
            Integer BracketFrom = null;
            Integer BracketTo = null;
            try{
                BracketFrom = bracketList.get(0);
                BracketTo = bracketList.get(bracketList.size() - 1);
            }catch (Exception e){

            }
            //运算数
            Operand a = null;
            Operand b = null;
            //运算符号
            Integer SymbolFrom;
            Integer SymbolTo;
            //当题目中有括号时，在括号中找到优先级最高的运算符号
            if(BracketFrom != null){
                SymbolFrom = BracketFrom;
                SymbolTo = BracketTo;
            }else{
                //当题目中没有括号时，从左往右找到优先级最高的运算符号
                SymbolFrom = 0;
                SymbolTo = NOList.size() - 1;
            }

            //把第一个括号设置成最高优先级
            Integer highestPriority = null;
            try{
                highestPriority = NOList.get(SymbolFrom).getPriority();
            }catch (Exception e){
                return null;
            }

            Integer highestPos = SymbolFrom;
            Integer priority = null;
            Integer Pos = null;
            //查找题目中最高优先级的符号以及用Pos记录位置
            for(int i = SymbolFrom; i <= SymbolTo;i++){
                try{
                    priority = NOList.get(i).getPriority();
                }catch (Exception e){
                    return null;
                }

                Pos = i;
                if(priority > highestPriority){
                    highestPriority = priority;
                    highestPos = Pos;
                }
            }

            Integer numerator = null;
            Integer denominator = null;
            a = operandList.get(highestPos);
            b = operandList.get(highestPos + 1);
            String Symbol = NOList.get(highestPos + 0).getName();

            //根据符号是加减乘除判断不同的运算方式
            if(Symbol.equals("+")){
                denominator = a.getDenominator() * b.getDenominator();
                Integer aNumerator = a.getNumerator() * b.getDenominator();
                Integer bNumerator = a.getDenominator() * b.getNumerator();
                numerator = aNumerator + bNumerator;
            }
            else if(Symbol.equals("-")){
                denominator = a.getDenominator() * b.getDenominator();
                Integer aNumerator = a.getNumerator() * b.getDenominator();
                Integer bNumerator = a.getDenominator() * b.getNumerator();
                numerator = aNumerator - bNumerator;
            }
            else if(Symbol.equals("×")){
                numerator = a.getNumerator() * b.getNumerator();
                denominator = a.getDenominator() * b.getDenominator();
            }
            else if(Symbol.equals("÷")){
                numerator = a.getNumerator() * b.getDenominator();
                denominator = a.getDenominator() * b.getNumerator();
            }

            SUM.setNumerator(numerator);
            SUM.setDenominator(denominator);

            //当除数为0时或分子为负数时返回空值
            if(Symbol.equals("÷") && denominator == 0){
                return null;
            }

            if(numerator < 0){
                return null;
            }

            //将计算最后的步骤存入
            if(NOList.size() == 1){
                if(a.getValue() > b.getValue() && (Symbol.equals("+") || Symbol.equals("×"))){
                    resultCollection = b.toString() + Symbol + a.toString();
                }else{
                    resultCollection = a.toString() + Symbol + b.toString();
                }
            }

            //当完成运算时为下一次运算修改Pos值
            operandList.set(highestPos,SUM);
            try{
                operandList.remove(highestPos + 1);
                NOList.remove(highestPos + 0);
                bracketList.remove(highestPos);
            }catch (Exception e){

            }
        }

        return SUM.toString();
    }

    //排序的方法
    public void sort(List<Float>arr,int leftindex,int rightdex){
        if(leftindex >= rightdex){
            return;
        }

        int left = leftindex;
        int right = rightdex;
        Float base =arr.get(left);
        while(left < right){
            while(left < right && arr.get(right) >= base){
                right--;
            }
            arr.set(left,arr.get(right));

            while(left < right && arr.get(left) <= base){
                left++;
            }
            arr.set(right,arr.get(left));
        }

        arr.set(left,base);
        sort(arr,leftindex,left - 1);
        sort(arr,right + 1,rightdex);
    }

}
