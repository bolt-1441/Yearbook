import java.util.*;
import java.io.*;

// TODO: 10/6/2022  make a system to find and creat a file for any records that have errors like missing data, anything that can not be processed
public class stuPicDataSplit{
   public void mainDataSplit() throws java.io.IOException{
      
      String[] main;
      String[] dataSlots = new String[] {"ImageFolder", "ImageFileName", "Grade", "LastName", "FirstName"};
      File fieldNames = new File("U:\\wkspaces\\Main\\year book data\\Computer Science\\Portrait Data\\School Portraits\\databases\\photos.XML");// this directory needs to me user input or somehow changed to find the file on others computers
      Scanner scan = new Scanner(fieldNames);

      String nextLine = scan.nextLine();
      main = nextLine.split("<photoEntry>");// <photoEntry> is start </photoEntry> is end

       for(int i=1; i<main.length; i++){   
                
         //this is the start of what will split the numbers in to their own "," divided slots ex: "<num>12</num>" ==> ",12,"
         //ex of input: <ImageFolder>FOLDER3</ImageFolder><ImageFileName>000529.jpg</ImageFileName><Grade>9</Grade><LastName>Wilcox</LastName><FirstName>Cameron</FirstName>
         
         StringBuilder finalOutPut = new StringBuilder();
           for (String dataSlot : dataSlots) {// this pulls out the useful data that we will use rom the .txt file in to x,y,z, format
         /*
         =============================================================================
         IF ANY NEW DATA NEEDS TO BE ADDED TO THE OUTPUT ADD TO THE "dataSlots" ARRAY
         =============================================================================
         */
               int x = main[i].indexOf(dataSlot);
               int Xlen = dataSlot.length() + 1;//+1 is for the ">" at the end of the dataSlot input

               int y = main[i].indexOf(dataSlot, x + 1);//x+1 is to look at the next one that x has not already seen

               String str1 = main[i].substring(x + Xlen, y - 2);  //-2 is to cut the "</" from the string, x+Xlen does the same thing but based on the length of the input
               finalOutPut.append(str1).append(",");
           }
         main[i] = finalOutPut.toString();
       }
         /*
         =============================================================================
         writes out put to .txt file in x,y,z, format
         default will be folderName,fileName.jpg,grade,firstName,lastName,
         (grade can include "STAFF" as an input)
         =============================================================================
         */
         FileWriter writer = new FileWriter("U:\\wkspaces\\Main\\year book data\\Computer Science\\Portrait Data\\School Portraits\\databases\\our stuff\\stuPicDataSplit.txt");//this file out put needs to change like the input file location as well
       for (String s : main) {
           writer.write(s + "\n");
           //System.out.println(main[i]);
       }
          writer.close();
   }
}
