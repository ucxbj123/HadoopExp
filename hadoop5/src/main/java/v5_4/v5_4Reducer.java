package v5_4;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class v5_4Reducer extends Reducer<Text, v5_4Data, Text, v5_4Data> {
    protected void reduce(Text k3, Iterable<v5_4Data> v3, Context context)
        throws IOException, InterruptedException{
        for (v5_4Data d:v3){
            if (d.getRank()==2 &&d.getOrder()==1){
                context.write(new Text(" "),d);
            }
        }
    }
}
