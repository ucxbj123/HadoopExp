package v5_3;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class v5_3Mapper extends Mapper<LongWritable, Text, Text, v5_3able> {
    @Override
    protected void map(LongWritable k1, Text v1, Context context) throws IOException, InterruptedException {
        String data = v1.toString();
        String[] words = data.split(",");

//        String t1 = StringUtils.substringAfter(data, ",");
//        String t2 = StringUtils.substringAfter(t1, "-");
        //取出时间偏移量
        String t2 = words[2];
        String[] words2 = t2.split("-");

        v5_3able sold = new v5_3able();
        sold.setTime(words2[0]);
        sold.setQuantity_sold(Integer.parseInt(words[5]));
        sold.setAmount_sold(Float.valueOf(words[6]));
        context.write(new Text(words2[0]),sold);
    }
}
