/**
 * Created by tengf on 2016/11/18.
 */
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
public class FileSearch {
    public void SearchKeyword(File file,String keyword) {
        verifyParam(file, keyword);
        LineNumberReader lineReader = null;
        try {
            lineReader = new LineNumberReader(new FileReader(file));
            String readLine = null;
            while((readLine =lineReader.readLine()) != null){
                int index = 0;
                int next = 0;
                int times = 0;
                while((index = readLine.indexOf(keyword,next)) != -1) {
                    next = index + keyword.length();
                    times++;
                }
                if(times > 0) {
                    System.out.println("第"+ lineReader.getLineNumber() +"行" + "出现 "+keyword);
                    System.out.println(readLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(lineReader);
        }
    }
    private void verifyParam(File file, String keyword) {
        if(file == null ){
            throw new NullPointerException("the file is null");
        }
        if(keyword == null || keyword.trim().equals("")){
            throw new NullPointerException("the keyword is null");
        }

        if(!file.exists()) {
            throw new RuntimeException("the file is not exists");
        }

        if(!file.canRead()) {
            throw new RuntimeException("the file can't read");
        }
    }
    private void close(Closeable able){
        if(able != null){
            try {
                able.close();
            } catch (IOException e) {
                e.printStackTrace();
                able = null;
            }
        }
    }

}