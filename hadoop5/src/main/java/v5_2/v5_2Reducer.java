package v5_2;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class v5_2Reducer extends Reducer<NullWritable,Employee,NullWritable, Text> {
    protected void reduce(NullWritable k3, Iterable<Employee> v3, Context context) throws IOException, InterruptedException, IOException {
        String line=null;
        for (Employee v : v3) {
            line = v.toString();
            context.write(k3, new Text(line));
        }
    }
}
