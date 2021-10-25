import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QAFiles {
    public static void QAFiles(String txt,String FilePath){
        String File = FilePath;

        FileWriter FW = null;
        try{
            File file = new File(File);
            FW = new FileWriter(file,false);
            FW.write(txt);
            FW.write("\r\n");
            FW.flush();
            FW.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static List<String>readTo(String FilePath){
        BufferedReader BR = null;
        String answer = null;
        List<String>answerList = new ArrayList<String>();
        try{
            BR = new BufferedReader(new FileReader(new File(FilePath)));
            while((answer = BR.readLine()) != null){
                try{
                    String[] split = answer.split("\n");
                    answerList.add(split[1].trim());
                }catch (Exception e){

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                BR.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return answerList;
    }
}
