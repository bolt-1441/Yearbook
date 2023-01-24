import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.Scanner;
/*
===============================================================================
Created by: Theodore Clark
finished on: 1/12/23

Used for: sorting index files in standard format in to data to bu used in an Adobe plug in to help the year book of Caney Creek High School


===============================================================================
 */
public class indexSort {
    public static void main(String[] args) throws IOException {
        ArrayList<String> main = new ArrayList<>();
        ArrayList<String> linesSplit = new ArrayList<>();
        String[] dataSlots = new String[] {"ImageFolder", "ImageFileName", "Grade", "LastName", "FirstName"};
        File fieldNames = new File("U:\\wkspaces\\Main\\year book\\Caney Creek HS (Balfour_C)2\\Yearbook\\Index.txt");// this directory needs to me user input or some how changed to find the file on others computers
        Scanner scan = new Scanner(fieldNames);

String line="";
        while(scan.hasNextLine()){//takes in all lines in input file, filters out excess tabs and adds to main
            line = scan.nextLine();
            line = removeExtraTabs(line);
            main.add(line);

        }

        FileWriter writer = new FileWriter("U:\\wkspaces\\Main\\year book data\\Computer Science\\Portrait Data\\School Portraits\\databases\\our stuff\\stuPicDataSplit.txt");//this file out put needs to change like the input file location as well
        int len = main.size();
        for (int i = 0; i < len; i++) {
            writer.write(main.get(i) + "\n");
            //System.out.println(main.get(i));//for debug only
        }
        writer.close();
    }

private static String removeExtraTabs(String input){//removes and tabs that are back to back like "     " or "\t\t"
        while(true)
            if (input.indexOf("\t\t")>0)
                input = input.substring(0, input.indexOf("\t\t")) + input.substring(input.indexOf("\t\t")+1);
            else
                break;
        return input;
    }
}