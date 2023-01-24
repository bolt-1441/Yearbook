import java.io.Serial;
import java.io.Serializable;

public class stuPicObj implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String firstName;
    String lastName;
    String grade;
    String fileNum;
    String fileFolder;
    boolean staff;

    stuPicObj(String fileFolder,String fileNum,String grade,String lastName,String firstName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.fileNum = fileNum;
        this.fileFolder = fileFolder;
        if(grade.equals("STAFF"))
            staff = true;
        if(grade.equals(""))
            System.out.println(firstName);
    }

    public int getGrade() {
        if(staff)
        {
            return -1;
        }
        else {
            //return 21;
             return Integer.parseInt(grade);
        }
    }

    public String getFileNum() {
        return fileNum;
    }

    public String getFileFolder() {
        return fileFolder;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFileFolder(String fileFolder) {
        this.fileFolder = fileFolder;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
