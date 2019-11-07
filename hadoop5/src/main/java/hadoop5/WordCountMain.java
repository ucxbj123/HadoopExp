package hadoop5;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import v5_1.WordCountMapper;
import v5_1.WordCountReducer;



import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import v5_2.Employee;
import v5_2.v5_2Mapper;
import v5_2.v5_2Partitioner;
import v5_2.v5_2Reducer;
import v5_3.v5_3Mapper;
import v5_3.v5_3Reducer;
import v5_3.v5_3able;
import v5_4.v5_4Data;
import v5_4.v5_4Mapper;
import v5_4.v5_4Reducer;


/**
 * Hello world!
 *
 */
public class WordCountMain
{
    public static void main( String[] args ) throws Exception {

        Job job= Job.getInstance(new Configuration());
        job.setJarByClass(WordCountMain.class);

//        //5.1编写 Java 代码统计文件单词频率
//        job.setMapperClass(WordCountMapper.class);
//        job.setMapOutputKeyClass(Text.class);
//        job.setOutputValueClass(IntWritable.class);
//
//        job.setCombinerClass(WordCountReducer.class);
//        System.out.println("完成Combiner");
//
//        job.setReducerClass(WordCountReducer.class);
//        job.setMapOutputKeyClass(Text.class);
//        job.setOutputValueClass(IntWritable.class);


        //5.2按照上面实验步骤编写程序，对员工数据按低薪、中薪、高薪进行分区存储，输 出到 3 个文件。
        // 指定job的mapper和输出的类型<k2 v2>
//        job.setMapperClass(v5_2Mapper.class);
//        job.setMapOutputKeyClass(NullWritable.class);
//        job.setMapOutputValueClass(Employee.class);
//
//        //指定任务的分区规则的类
//        job.setPartitionerClass(v5_2Partitioner.class);
//        //指定建立几个分区
//        job.setNumReduceTasks(3);
//
//        // 指定job的reducer和输出的类型<k4  v4>
//        job.setReducerClass(v5_2Reducer.class);
//        job.setOutputKeyClass(NullWritable.class);
//        job.setOutputValueClass(Text.class);



        //5.3求出各年销售笔数、各年销售总额
        //2. 指定job的mapper和输出的类型<k2 v2>
//        job.setMapperClass(v5_3Mapper.class);
//        job.setMapOutputKeyClass(Text.class);
//        job.setMapOutputValueClass(v5_3able.class);
//
//        //3. 指定job的reducer和输出的类型<k4  v4>
//        job.setReducerClass(v5_3Reducer.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(Text.class);


            //5.4、统计用户在搜狗的搜索数据，获取到 URL 排名第二、用户点击顺序第一的日志。
        job.setMapperClass(v5_4Mapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(v5_4Data.class);
        job.setReducerClass(v5_4Reducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);




        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        job.waitForCompletion(true);





        System.out.println( "Hello World!" );
    }
}
