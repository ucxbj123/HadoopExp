package v5_1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


import java.io.IOException;

public class WordCountReducer  extends Reducer<Text, IntWritable,Text,IntWritable>  {
    protected void reduce(Text key3, Iterable<IntWritable> v3, Context context) throws IOException, InterruptedException {
        int total=0;
        for(IntWritable v:v3){
            total+=v.get();
        }
        context.write(key3,new IntWritable(total));
        System.out.println("完成reduce");
    }
}
