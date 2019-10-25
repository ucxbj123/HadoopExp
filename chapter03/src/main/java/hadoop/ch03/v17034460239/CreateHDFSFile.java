package hadoop.ch03.v17034460239;




import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Hello world!
 *
 */
public class CreateHDFSFile
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        Configuration conf = new Configuration(); // 配置 NameNode 地址，具体根据你的NameNode IP 配置
         URI uri = new URI("hdfs://192.168.30.130:8020");// 指定用户名 , 获取 FileSystem 对象
         FileSystem fs = FileSystem.get(uri, conf, "hadoop");  //定义文件路径
        Path dfs = new Path("/student/17034460239/test2.txt");
        //创建文件
        FSDataOutputStream os = fs.create(dfs, true);//创建文件
        os.writeBytes("hello,hdfs!");//往文件写入信息
        //删除文件




         os.close();   // 关闭流
         fs.close();// 不需要再操作 FileSystem 了，关闭
    }
}
