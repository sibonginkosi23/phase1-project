package fileHandlingproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class project {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// System.out.println(System.getProperty(user.dir));
		
		Scanner scanner1 = new Scanner(System.in);
		int ch;
		String fname;
		do
		{
			
			System.out.println("__________Welcome to my Application_________");
			System.out.println("______________SIBONGINKOSI BONEFANTURE MASHELE__________________");
			System.out.println("__________Java Full Stack Developer__________ ");
			
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
			case  2:
				
				System.out.println("Enter the file name where you wanna write ");
				fname=scanner1.next();
				
				Scanner sc1= new Scanner(System.in);
				
				System.out.println("Enter the content you wanna write in a file ");
				String content=sc1.nextLine();
				
				FileWriter fw = new FileWriter("C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\"+fname+".txt");
				fw.write(content);
				
				System.out.println("Data Written in the file successfully ");
				
				fw.close();
				break;
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
			case 4:
				
				System.out.println("Enter file name which you wanna delete ");
				fname=scanner1.next();
				
				File f3 = new File("C:\\Users\\Mashe\\eclipse-workspace\\fileHandlingproject\\src\\fileHandlingproject\\filesoperation\\"+fname+".txt");
				
				f3.delete();
				
				if(f3.exists())
				{
					System.out.println("Error found in deleting the file ");
				}
				else
				{
					System.out.println("File deleted uccessfully ");
				}
				
				break;
			case 5:
				
				System.out.println("Enter the file name for searching ");
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
			case 6:
				
				System.out.println("List of Files and Folders are :");
				
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
				break;
			case 7:
				System.out.println("Thank you for using the Application  ");
				System.exit(ch);
				break;
			default:
				System.out.println("zPlease enter a valid option ");
			}
		}
		while(true);

	}

}
