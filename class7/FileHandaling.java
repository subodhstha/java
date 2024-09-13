import java.io.*;
public class FileHandaling {
    public static void main(String[] args)throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try
        {
            in = new FileInputStream("D:\\input.txt");
            out = new FileOutputStream("D:\\output.txt");
            int a;
            while((a=in.read())!=-1)
            {
                out.write(a);
            }
        }
        finally{
            in.close();
            out.close();
        }
    }
}
