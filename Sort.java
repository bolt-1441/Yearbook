import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sort {
    public ArrayList<stuPicObj> stuSort(String fileName)
    {
        File file = new File (fileName);
        ArrayList<stuPicObj> numberList = new ArrayList<>();
        try
        {
            Scanner myReader = new Scanner(file);//this is what's going to read my file
            //this loop reads file and does the multiplying and the printing
            myReader.nextLine();
            while(myReader.hasNextLine())
            {
                String str = myReader.nextLine();
                String[] strA = str.split(",");
                //FOLDER1,000001.jpg,9,Adcock,Addison,
                //(String firstName,String lastName,String grade,String fileNum,String fileFolder)
                stuPicObj stuPicObj = new stuPicObj(strA[0],strA[1],strA[2],strA[3],strA[4]);
                numberList.add(stuPicObj);
            }
            try {
                stuPicObj[] students = new stuPicObj[numberList.size()];
                students = numberList.toArray(students);

                //Write Student array to file.
                FileOutputStream fos = new FileOutputStream("students.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(students);
                oos.close();

                //Read Student array from file.
                //FileInputStream fis = new FileInputStream("students.ser");
                //ObjectInputStream ois = new ObjectInputStream(fis);
                //stuPicObj[] studentsFromSavedFile = (stuPicObj[]) ois.readObject();
                //ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error finding file");
        }
        return numberList;

    }
}
