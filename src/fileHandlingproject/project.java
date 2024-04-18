package fileHandlingproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class project {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner1 = new Scanner(System.in);
		int ch;
		String fname;
		do
		{
			
			System.out.println("***************Welcome to my Application************************");
			System.out.println("++++++++++++SIBONGINKOSI BONEFANTURE MASHELE+++++++++++++++++");
			System.out.println("***************Java Full Stack Developer************************");
			
			System.out.println("operations");
			System.out.println("1. Create a new file");
			System.out.println("2. Write into a file ");
			System.out.println("3. Read a file ");
			System.out.println("4. Delete a file ");
			System.out.println("5. Search for a file");
			System.out.println("6. List of all files ");
			System.out.println("7. Exit");
			
			System.out.println("enter your choice ");
			ch=scanner1.nextInt();
			switch(ch)
			{
			
			//case1 file creation
			case 1:
				System.out.println("Enter the file name to create :");
				
				fname=scanner1.next();
				
				File f = new File("C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\"+fname+".txt");
				
				
				if(f.createNewFile())
				{
					System.out.println("file has been created successfully");
				}
				else
				{
					if(f.exists())
					{
						System.out.println("File already exist");
					}
					else
					{
						System.out.println("error in creating the file ");
					}
				}
				break;
				
			//case 2 write in file
			case  2:
				System.out.println("Enter the file name where you wanna write ");
				fname=scanner1.next();
				
				Scanner sc1= new Scanner(System.in);
				
				System.out.println("Enter the content you wanna write in a file ");
				String content=sc1.nextLine();
				
				FileWriter fw = new FileWriter("C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\"+fname+".txt");
				fw.write(content);
				
				System.out.println("Data Written into file successfully ");
				fw.close();
				break;
				
			//case 3 read files
			case 3:
				System.out.println("Enter the file name whose data you wanna read ");
				fname=scanner1.next();
				
				File f2= new File("C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\"+fname+".txt");
				Scanner readSc = new Scanner(f2);
				
				while(readSc.hasNextLine())
				{
					String line=readSc.nextLine();
					System.out.println(line);
				}
				
				readSc.close();
				break;
				
			//case 4 deletion
			case 4:
				
				System.out.println("Enter file name which you wanna delete ");
				File f6 = new File("C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\");
				
				File[] l1 = f6.listFiles();
				
				for(File fi: l1)
				{
					if(fi.isDirectory())
					{
						System.out.println(fi.getName());
					}
					else if(fi.isFile())
					{
						System.out.println(fi.getName());
					}
				}
				fname=scanner1.next();
				
				File f3 = new File("C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\"+fname+".txt");
				
				
				if (!f3.exists()) {
			        System.out.println(" File name is either incorrect or file does not exist ");
			        break;
			    }

			    if (f3.delete()) {
			        System.out.println("File deleted successfully!");
			    } else {
			        System.out.println("Error found in deleting the file!");
			    }

			    if (!f3.exists()) {
			        System.out.println("File does not exist after deletion.");
			    }
				break;
				
			//case 5 searching
			case 5:
				System.out.println("Enter the file name for searching (include format eg .txt) ");
				fname=scanner1.next();
				
				File f5 = new File("C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\");
				
				String[] list = f5.list();
				int fl=0;
				if(list==null)
				{
					System.out.println("there is no file present in the directory ");
				}
				else
				{
					for(int i=0;i<list.length;i++)
					{
						String sfile= list[i];
						if(sfile.equalsIgnoreCase(fname))
						{
							System.out.println("file found in the directory successfully");
						
							fl=1;
						}
					}
					
					if(fl==0)
					{
						System.out.println("file not found ");
					}
				}
				break;
				
			//case 6
			case 6:
				Scanner scanner = new Scanner(System.in);
		        String rootDirectory = "C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\";
		        
		        int choice;
		        do {
		            System.out.println("1. List files and folders");
		            System.out.println("0. Exit");
		            System.out.print("Enter your choice: ");
		            choice = scanner.nextInt();
		            
		            switch (choice) {
		                case 1:
		                    System.out.println("Enter sorting order (asc/desc), or enter 0 to return to the menu: ");
		                    String sortOrder = scanner.next();
		                    if (sortOrder.equals("0")) {
		                        break;
		                    }
		                    listFilesAndFolders(rootDirectory, sortOrder);
		                    break;
		                case 0:
		                    System.out.println("Exiting...");
		                    break;
		                default:
		                    System.out.println("Invalid choice.");
		                    break;
		            }
		        } while (choice != 0);
		        break;
		        
		    //case 7    
			case 7:
				System.out.println("Thank you for using the Application  ");
				System.exit(ch);
				break;
			default:
				System.out.println("Please enter a valid option ");
			}
		}
		while(true);
//method for listing files
	}
	private static void listFilesAndFolders(String rootDirectory, String sortOrder) {
        File directory = new File(rootDirectory);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files or folders found in the directory.");
            return;
        }

        if (sortOrder.equalsIgnoreCase("asc")) {
            Arrays.sort(files);
        } else if (sortOrder.equalsIgnoreCase("desc")) {
            Arrays.sort(files, Collections.reverseOrder());
        } else {
            System.out.println("Invalid sorting order.");
            return;
        }

        System.out.println("List of Files and Folders:");

        for (File file : files) {
            if (file.isDirectory() || file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }


}
