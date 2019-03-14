import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Random;

public class Mu {

	static int depth = 3;
	static int id = 100;
	public static void insert(String fileName,long points,String insertContent) {
		try {
			File tmp = File.createTempFile("tmp", null);
			tmp.deleteOnExit();
			
			RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
			
			FileOutputStream tmpOut = new FileOutputStream(tmp);
			FileInputStream tmpIn = new FileInputStream(tmp);
			raf.seek(points);
			
			byte[] buff = new byte[1024];
			int hasRead = 0;
			
			while((hasRead = raf.read(buff))>0) {
				
				tmpOut.write(buff,0,hasRead);
			}
			
			raf.seek(points);
			raf.write(insertContent.getBytes());
			
			while((hasRead = tmpIn.read(buff))>0) {
				raf.write(buff,0,hasRead);
			}
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}

	public static void randomWrite(String path,String insertContent) {
		try {
			RandomAccessFile raf = new RandomAccessFile(path,"rw");
			raf.seek(raf.length());
			raf.write(insertContent.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		String path = "G:\\MyApplication6\\app\\src\\main\\res\\layout\\activity_login.xml";

		File file = new File(path);
		InputStream in = null;
		int count = 2;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int by = 0;
		try {
			while((by= in.read()) != '>') {
				count += 1;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pos = count;
		System.out.println(pos);
		addNode(3,path,"constraintLayout100",pos);
		insert (path,pos, 
"<android.support.constraint.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\r\n" + 
"    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\r\n" + 
"    xmlns:tools=\"http://schemas.android.com/tools\"\r\n" + 
"    android:id=\"@+id/constraintLayout100\"\r\n" + 
"    android:layout_width=\"match_parent\"\r\n" + 
"    android:layout_height=\"match_parent\"\r\n" + 
"    app:layout_constraintBottom_toBottomOf=\"parent\"\r\n" + 
"    app:layout_constraintEnd_toEndOf=\"parent\"\r\n" + 
"    app:layout_constraintHorizontal_bias=\"1.0\"\r\n" + 
"    app:layout_constraintStart_toStartOf=\"parent\"\r\n" + 
"    app:layout_constraintTop_toTopOf=\"parent\"\r\n" + 
"    app:layout_constraintVertical_bias=\"1.0\"\r\n" + 
"    tools:context=\".MainActivity\">");
		randomWrite(path,"</android.support.constraint.ConstraintLayout>");
	}
	
	
	public static void addlayout(String path, String container, int pos, String filename) {
		insert(path,pos,"<LinearLayout\r\n" + 
				"        android:id=\"@+id/linearLayout"+id+"\"\r\n" + 
				"        android:layout_width=\"286dp\"\r\n" + 
				"        android:layout_height=\"509dp\"\r\n" + 
				"        android:layout_marginEnd=\"1dp\"\r\n" + 
				"        android:layout_marginLeft=\"1dp\"\r\n" + 
				"        android:layout_marginRight=\"1dp\"\r\n" + 
				"        android:layout_marginStart=\"1dp\"\r\n" + 
				"        android:layout_marginTop=\"40dp\"\r\n" + 
				"        android:orientation=\"vertical\"\r\n" + 
				"        app:layout_constraintEnd_toEndOf=\"parent\"\r\n" + 
				"        app:layout_constraintStart_toStartOf=\"parent\"\r\n" + 
				"        app:layout_constraintTop_toTopOf=\"parent\">");		
		
		
	}
	public static void addNode(int condepth,String path,String container,int pos) {

		Random p = new Random();
		int rand = p.nextInt(10)+1;
		for(int i = 0;i < rand;++i) {
			Random r = new Random();
			boolean randNum = r.nextBoolean();
			id += 1;
		if(randNum&&condepth!=3) {
			Random r1 = new Random();
			int rander = r1.nextInt(2);
			switch(rander) {
			case 0:
					insert(path,pos,"       <Button\r\n" + 
					"        android:id=\"@+id/button" +id +"\"\r\n" + 
					"        android:layout_width=\"155dp\"\r\n" + 
					"        android:layout_height=\"516dp\"\r\n" + 
					"        android:background=\"@android:color/transparent\"\r\n" + 
					"        app:layout_constraintStart_toStartOf=\"parent\"\r\n" +    //@+id/"+container +"\"\r\n" + 
					"        app:layout_constraintTop_toTopOf=\" parent\"/>" ); //@+id/"+container+"\" />            ");
					break;
			case 1:
					insert(path,pos,"    <Button\r\n" + 
							"        android:id=\"@+id/button"+id+"\"\r\n" + 
							"        android:layout_width=\"wrap_content\"\r\n" + 
							"        android:layout_height=\"wrap_content\"\r\n" +  
							"        android:visibility=\"invisible\"\r\n" + 
							"        app:layout_constraintEnd_toEndOf=\"parent\"\r\n" + 
							"        app:layout_constraintTop_toTopOf=\"parent\" />");
					break;
	
			}

		}
		else {
		if(condepth >  0 ) {
			insert(path,pos,"</LinearLayout>");
			int idtmp = id;
			addNode(condepth-1,path,container,pos);
			Random r1 = new Random();
			int rander = r1.nextInt(2);
			switch(rander) {
			
			case 0:
			insert(path,pos,"<LinearLayout\r\n" + 
				"        android:id=\"@+id/linearLayout"+idtmp+"\"\r\n" + 
				"        android:layout_width=\"286dp\"\r\n" + 
				"        android:layout_height=\"509dp\"\r\n" + 
				"        android:layout_marginEnd=\"1dp\"\r\n" + 
				"        android:layout_marginLeft=\"1dp\"\r\n" + 
				"        android:layout_marginRight=\"1dp\"\r\n" + 
				"        android:layout_marginStart=\"1dp\"\r\n" + 
				"        android:layout_marginTop=\"40dp\"\r\n" + 
				"        android:orientation=\"vertical\"\r\n" + 
				"        app:layout_constraintEnd_toEndOf=\"parent\"\r\n" + 
				"        app:layout_constraintStart_toStartOf=\"parent\"\r\n" + 
				"        app:layout_constraintTop_toTopOf=\"parent\">");		
			break;
			case 1:
			insert(path,pos,"    <LinearLayout\r\n" + 
					"        android:id=\"@+id/linearLayout"+idtmp+"\"\r\n" + 
					"        android:layout_width=\"100dp\"\r\n" + 
					"        android:layout_height=\"462dp\"\r\n" + 
					"        android:layout_marginEnd=\"8dp\"\r\n" + 
					"        android:layout_marginLeft=\"8dp\"\r\n" + 
					"        android:layout_marginRight=\"8dp\"\r\n" + 
					"        android:layout_marginStart=\"8dp\"\r\n" + 
					"        android:layout_marginTop=\"8dp\"\r\n" + 
					"        android:orientation=\"horizontal\"\r\n" + 
					"        app:layout_constraintEnd_toEndOf=\"parent\"\r\n" + 
					"        app:layout_constraintStart_toStartOf=\"parent\"\r\n" + 
					"        app:layout_constraintTop_toTopOf=\"parent\">");
			break;
			}
		}
		}
		}	
//		}
		
	}
	}
