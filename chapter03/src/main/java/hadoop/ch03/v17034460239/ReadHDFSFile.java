package hadoop.ch03.v17034460239;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class ReadHDFSFile {
    public static void main( String[] args ) throws Exception {
        Configuration conf = new Configuration(); // 配置 NameNode 地址，具体根据你的NameNode IP 配置
        URI uri = new URI("hdfs://192.168.30.130:8020");// 指定用户名 , 获取 FileSystem 对象
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");  //定义文件路径
        Path dfs = new Path("/student/17034460239/test6.txt");
        FSDataInputStream in=fs.open(dfs);
        BufferedReader d = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = d.readLine()) != null) {
            String[] strarray = line.split(" ");
            for (int i = 0; i < strarray.length; i++) {
                System.out.print(strarray[i]);
                System.out.print(" ");

            }

            System.out.println(" ");
        }
        d.close();
        in.close();

        fs.close();// 不需要再操作 FileSystem 了，关闭
    }
}
