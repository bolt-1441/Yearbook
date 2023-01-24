import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class runMain {
    public runMain(){}
    public static void main(String[] args) throws IOException {
        stuPicDataSplit stuPicDataSplit = new stuPicDataSplit();
        stuPicDataSplit.mainDataSplit();
        Sort sort = new Sort();
        ArrayList<stuPicObj> stuPicObs= sort.stuSort("U:\\wkspaces\\Main\\year book data\\Computer Science\\Portrait Data\\School Portraits\\databases\\our stuff\\stuPicDataSplit.txt");
        File folder1 = new File("U:\\wkspaces\\Main\\year book data\\Computer Science\\Portrait Data\\School Portraits\\databases\\our stuff\\sorted images by grade then teacher");
        boolean bool2 = folder1.mkdirs();
        if(bool2){
            System.out.println("Folder is created successfully");
        }else{
            System.out.println("Error Found!");
        }
        Collections.sort(stuPicObs, Comparator.comparing(stuPicObj::getGrade));

        for (stuPicObj stuPicOb : stuPicObs) System.out.println(stuPicOb);
        for (int i = 0; stuPicObs.size() > i; i++) { 

        }
    }

}
