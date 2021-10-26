
public class main {
    public static void main (String[] args){

        Integer n = null; //n为题目的个数
        Integer r = null; //r为数值范围
        String answerPath = null;
        GenerateArithmetic generateArithmetic = new GenerateArithmetic();
        for(int i = 0;i < args.length;i++){
            String param = args[i];
            if(i % 2 == 0){
                if("-n".equals(param)){
                    n = Integer.valueOf(args[i+1]);
                }
                else if("-r".equals(param)){
                    r = Integer.valueOf(args[i+1]);
                }
            }
        }

        if(n == null || r == null){
            try{
                throw new Exception("请输入n与r的数值");
            } catch (Exception e){
                System.out.println("请输入n与r的数值");
            }
        }else if(n != null && r != null) {
            if (n <= 0 || r <= 0){
                try {
                    throw new Exception("请输入正整数。");
                } catch (Exception e) {
                    System.out.println("请输入正整数。");
                }
            }
            try {
                generateArithmetic.generatearithmetics(n, r);
            } catch (Exception e) {
                System.out.println("生成四则运算题目失败，请重试！");
            }
        }else if(answerPath != null){
            try{
                generateArithmetic.checkAnswer(answerPath);
            }catch (Exception e){
                System.out.println("文件不存在，请重试!");
            }

        }


    }
}
