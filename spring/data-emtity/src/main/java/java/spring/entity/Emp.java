package java.spring.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @author: shanlei
 * @version: 1.0
 */
/*
 * ʵ����:
 * �����ݿ������ƺ��ֶ���һһ��Ӧ����
 * ����Ķ�����Ҫ�ô��Ǵ洢�����ݿ��в�ѯ����������
 * ����֮��,����û���κε���������
 * Ҫ��
 * 1�����ͱ�������һ��  (����֪��)
 * 2���Ը��������ݿ�ı����������һ��
 * 3���Ե��������ͺ��е��������ͱ���һ��
 * 4�����������ݿ��������Ҫ����һ��
 * 5���е����Ա��붼��˽�е� (���ڰ�ȫ����)
 * 6ʵ����������Ƽ�д�ɰ�װ��
 * 7���������Ƽ�д��java.util.Date
 * 8���е����Զ�Ҫ��get��set����
 * 9����߱��ղι��췽��
 * 10ʵ����Ӧ��ʵ�����л��ӿ� (mybatis����  �ֲ�ʽ��Ҫ )
 * 11ʵ�������������췽����ѡ
 * */
public class Emp implements Serializable {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;

    @Override
    public String toString() {
        return "emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }

    // �ղι�����
    public Emp(int empno, String ename, String job, Date hiredate, double sal, double comm, int deptno) {
    }

    // �вι�����
    public Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    // ���涼��set��get����
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

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
}

