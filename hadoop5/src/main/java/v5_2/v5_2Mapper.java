package v5_2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class v5_2Mapper extends Mapper<LongWritable, Text, NullWritable,  Employee> {

    protected void map(LongWritable k1, Text v1, Context context) throws IOException, InterruptedException {
        String data = v1.toString();
        String[] words = data.split(",");

        //创建员工对象
        Employee emp = new Employee();
        //设置员工属性
        emp.setEmpno(Integer.parseInt(words[0]));

        emp.setEname(words[1]);

        emp.setJob(words[2]);

        try {
            emp.setMgr(Integer.parseInt(words[3]));//可能为空,加try...catch包围
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        emp.setHiredate(words[4]);

        emp.setSal(Integer.parseInt(words[5]));

        try {
            emp.setComm(Integer.parseInt(words[6]));//可能为空
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        emp.setDeptno(Integer.parseInt(words[7]));


        NullWritable k2 = NullWritable.get();
        //k2充当占位符
        Employee v2 = emp;
        //输出k2, v2
        context.write(k2, v2);

    }
}
