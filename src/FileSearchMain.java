/**
 * Created by tengf on 2016/11/18.
 */
import java.io.File;
public class FileSearchMain {
    public static void main(String[] args) {

        FileSearch search = new FileSearch();
        search.SearchKeyword(new File("G:\\red rock\\homework5\\text.txt"), "young");
    }

}
