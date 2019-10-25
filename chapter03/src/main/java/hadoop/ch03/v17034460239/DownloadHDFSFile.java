package hadoop.ch03.v17034460239;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class DownloadHDFSFile {

    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );

        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.30.130:8020");
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");
        Path dfs = new Path("/student/17034460239/test4.txt");
        Path in =new Path("F:\\down.txt");
        fs.copyToLocalFile(false,dfs,in,true);
        fs.close();
    }

}
