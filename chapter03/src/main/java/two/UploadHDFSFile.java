package two;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.net.URI;
import org.apache.hadoop.io.IOUtils;
import java.io.*;


public class UploadHDFSFile
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );

        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.30.130:8020");
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");
        Path dfs = new Path("/student/17034460239/test4.txt");
        Path in =new Path("F:\\test.txt");
        fs.copyFromLocalFile(in,dfs);
        fs.close();
    }


}
