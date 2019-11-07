package v5_2;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Employee implements Writable {

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int comm;//奖金
    private int deptno;
    public String toString(){
        return empno+","+ename+","+job+","+mgr+","+hiredate+","+sal+","+comm+","+deptno;
    };


    @Override
    public void write(DataOutput dataInput) throws IOException {
        dataInput.writeInt(this.empno);
        dataInput.writeUTF(this.ename);
        dataInput.writeUTF(this.job);
        dataInput.writeInt(this.mgr);
        dataInput.writeUTF(this.hiredate);
        dataInput.writeInt(this.sal);
        dataInput.writeInt(this.comm);
        dataInput.writeInt(this.deptno);

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

        this.empno = dataInput.readInt();
        this.ename = dataInput.readUTF();
        this.job = dataInput.readUTF();
        this.mgr = dataInput.readInt();
        this.hiredate = dataInput.readUTF();
        this.sal = dataInput.readInt();
        this.comm = dataInput.readInt();
        this.deptno = dataInput.readInt();

    }

    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public int getMgr() {
        return mgr;
    }
    public void setMgr(int mgr) {
        this.mgr = mgr;
    }
    public String getHiredate() {
        return hiredate;
    }
    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
    public int getSal() {
        return sal;
    }
    public void setSal(int sal) {
        this.sal = sal;
    }
    public int getComm() {
        return comm;
    }
    public void setComm(int comm) {
        this.comm = comm;
    }
    public int getDeptno() {
        return deptno;
    }
    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
}
