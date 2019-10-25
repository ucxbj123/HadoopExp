package two;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.net.URI;


public class DeleteHDFSFile
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );

        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.30.130:8020");
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");
        Path dfs = new Path("/student/17034460239/test5.txt");
        Path in =new Path("F://test.txt");
        fs.delete(dfs,true);
        fs.close();
    }


}