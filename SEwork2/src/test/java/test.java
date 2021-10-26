import Symbol.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    GenerateArithmetic generateArithmetic = new GenerateArithmetic();

    public static void setArrayList(List list) {
        list.set(1, 1111);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(11);
        list.add(22);
        list.add(33);
        test.setArrayList(list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }


    public void Symboltest() {
        Symbol Symbol = new Division();
        System.out.println(Symbol.getName() + " " + Symbol.getPriority());
    }


    public void RandomNumbertest() {
        while (true) {
            Integer a = generateArithmetic.getRandomNumber(3) + 2;
            System.out.println(a);
            if (a == 4) {
                return;
            }
        }
    }


    public void RandomListtest() {
        //运算式的数字个数，最多4个,最少2个。
        Integer b = generateArithmetic.getRandomNumber(3) + 2;
        generateArithmetic.bracList = new ArrayList<Integer>();
        generateArithmetic.operList = new ArrayList<Operand>();
        generateArithmetic.SymList = new ArrayList<Symbol>();
        List<Integer> bracketList = generateArithmetic.bracList;
        List<Operand> operandList = generateArithmetic.operList;
        List<Symbol> NOList = generateArithmetic.SymList;
        //运算符的个数
        Integer SymbolNumber = b - 1;
        Integer bracketNumber = null;
        try {
            //括号内包含运算符的个数与位置
            bracketNumber = generateArithmetic.getRandomNumber(SymbolNumber);
        } catch (Exception e) {

        }

        System.out.println("number: " + b);
        System.out.println("SymbolNumber: " + SymbolNumber);
        System.out.println("bracetNumber: " + bracketNumber);

        //括号的位置
        Integer bracketPos = null;
        //存在括号时：
        if (bracketNumber == 1) {
            bracketPos = generateArithmetic.getRandomNumber(SymbolNumber);
            generateArithmetic.bracList.add(bracketPos);
        } else if (bracketNumber == 2) {
            bracketPos = generateArithmetic.getRandomNumber(2);
            generateArithmetic.bracList.add(bracketPos);
            generateArithmetic.bracList.add(bracketPos + 1);
        }

        //随机生成参与运算的数
        for(int i = 0; i < b; i++){

            Integer numerator = generateArithmetic.getRandomNumber(10 - 1) + 1;
            Integer denominator = generateArithmetic.getRandomNumber(10 - 1) + 1;
            Operand operand = new Operand();
            operand.setNumerator(numerator);
            operand.setDenominator(denominator);
            operandList.add(operand);

        }
        //随机生成运算符
        for (int i = 0; i < SymbolNumber; i++) {
            Integer j = generateArithmetic.getRandomNumber(4);
            Symbol Symbol = null;
            switch (j) {
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
            generateArithmetic.SymList.add(Symbol);
        }

        System.out.print("Number: ");
        for (Operand operand:generateArithmetic.operList) {
            System.out.print(operand + " ");
        }
        System.out.println();
        System.out.print("NO: ");
        for (Symbol Symbol : generateArithmetic.SymList) {
            System.out.print(Symbol.getName() + " ");
        }
        System.out.println();
        System.out.print("pos: ");
        for (Integer Pos : generateArithmetic.bracList) {
            System.out.print(Pos + " ");
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            sb.append(generateArithmetic.operList.get(i).toString());
            try {
                sb.append(generateArithmetic.SymList.get(i).getName());
            } catch (Exception e) {

            }
        }

        int bracketListSize = bracketNumber;
        try{
            if(bracketListSize == 1){
                Integer pos = bracketList.get(0);
                sb.insert(pos*2,"(");
                sb.insert(pos*2+4,")");
            }else {
                Integer Pos = bracketList.get(0);
                sb.insert(Pos*2,"(");
                Pos = bracketList.get(1);
                sb.insert(Pos*2+4,")");
            }
        }catch (Exception e){

        }


        System.out.println();
        System.out.println(sb);
    }


    public void generatequestionstest() throws Exception {
        for(int i = 0;i < 100; ){
            String question = generateArithmetic.generatequestion(10);
            String result = generateArithmetic.calculatequestion();
            if(question == null){
                continue;
            }
            if(result == null){
                continue;
            }
            i++;
            System.out.println(question);
            System.out.println(result);

            System.out.println(i+"  -----------------");
        }

    }


    public void generateArithmetictest() throws Exception {
        generateArithmetic.generatearithmetics(10,10);
    }


    public void savetest(){
        List<String> save = QAFiles.readTo("Answers.txt");
        System.out.println(save);
    }



    public void Maptest(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("a","a");
        map.put("a","b");
        System.out.println(map.get("a"));
    }


    public void testArrayEqual(){
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(222);
        list2.add(1);
        list2.add(2);
        list2.add(222);

        System.out.println(list1.equals(list2));
    }


    public void testSort(){
        List<Float> list = new ArrayList<Float>();
        list.add((float) 2);
        list.add((float) 5);
        list.add((float) 1);
        list.add((float) 10);
        System.out.println(list);
        generateArithmetic.quickSort(list,0,list.size() - 1);
        System.out.println(list);

    }



    public void testString(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("+");
        list.add("2");
        for(String s : list){
            System.out.print(s);
        }

    }


    public void testIntString(){
        Integer i = 11;
        String s = i.toString();
        System.out.println(s);
    }


    public void testNumber(){
        Operand operand = new Operand();
        operand.setNumerator(3);
        operand.setDenominator(1);
        System.out.println(operand.getValue() == 3.0);
    }


    public void testList(){
        List<Integer> list = new ArrayList<Integer>();
        list.set(0,1);
        System.out.println(list);


    }


    public void testSpilt(){
        String str = "(r + r)+ r × r ";
        String[] rs = str.split("r");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < rs.length;i++){
            if( i == rs.length - 1){
                sb.append(rs[i]);
            }else {
                sb.append(rs[i]).append(i);
            }

        }
        System.out.println(sb);
    }


    public void testTrim(){
        String str = "abcd";
        str = str.replace(""," ").trim();
        System.out.println(str);
        str = "a b c d";
        str = str.replace(" ","");
        System.out.println(str);
    }
}
