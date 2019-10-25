package two;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class ReadHDFSFileAttr {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.30.130:8020");
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");
        Path dfs = new Path("/student/17034460239/test7.txt");
        String user = "user_id";
        String number = "17034460239";
        byte[] value = number.getBytes();
        fs.setXAttr(dfs,user,value);
        byte[] read = fs.getXAttr(dfs, "user_id");
        String re = new String(read, "UTF-8");
        fs.close();
        System.out.println(re);
    }
}
