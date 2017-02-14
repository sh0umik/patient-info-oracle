package hosman;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author avp
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class JDBC 
{
    Connection con = null;
    JDBC()
    {
        try
        {
		Class.forName("oracle.jdbc.OracleDriver") ;
		con = DriverManager.getConnection("jdbc:oracle:thin:system/nikhil@localhost:1521:XE");
	}
	catch (Exception e) 
	{
                System.err.println("Exception: "+e.getMessage());
	}
  
    }
    public void test() throws ClassNotFoundException, SQLException
    {
  	try
        {    
  //	Class.forName("oracle.jdbc.OracleDriver") ;
//	Connection con = DriverManager.getConnection("jdbc:oracle:thin:system/nikhil@localhost:1521:XE");
       int n = 0;
        Statement smt = con.createStatement();
        //String msql = "delete from branch where branch_name = '" + s +"'";
	String sql = "select * from branch";
        ResultSet rs = smt.executeQuery(sql);
        rs.next();
        String qq = (String)rs.getString(1);
        System.out.println(qq);
	if(n==1)
            System.out.println("Deleted");
	else
            System.out.println("Not Found");
        }
        catch (Exception e)
        {
            System.out.println("Exception " + e.getMessage());
        
        }
    }

/////////       PATIENT    STARTS  ///////////////////////////////    
    public int Insert_Patient(int id, int age, String date_admitted, String date_discharged, String name, String sex, String address, String contact_no) throws ClassNotFoundException, SQLException
    {
        int n = 0;
        try
        {
            Statement smt = con.createStatement();
            String sql = "insert into Patient values ("+id+","+age+",'"+date_admitted+"','"+date_discharged+"','"+name+"','"+sex+"','"+address+"','"+contact_no+"')" ;
            n = smt.executeUpdate(sql);
            if (n == 1)
            {
                System.out.println("Success");
            }
            else 
            {
                System.out.println("Failed");          
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage());                    
        }
        return n;
    }
    
    public int Delete_Patient()
    {
        int id = 0;
        try {
            System.out.println(" tmtpmtkm");                               
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID of patient to be deleted."));
            Statement smt = con.createStatement();
            String sql = "delete from Patient where patient_id = " + id;
            smt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());                               
        }
        return id;
    }
    
    public ResultSet Retrieve_Patient_id(int id)
    {
        ResultSet rs = null;    
        int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select * from Patient where patient_id = " + id ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        //            return n;          
    }

    public ResultSet Retrieve_Patient_name(String name)
    {
        ResultSet rs = null;    
        int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select * from Patient where name like '%" + name + "%'";
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        //            return n;          
    }
    
    public ResultSet Retrieve_Patient_age(int age)
    {
        ResultSet rs = null;    
        int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select * from Patient where age = " + age ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        //            return n;          
    }
    
    public int Generate_Patient_Id()
    {
        ResultSet rs = null;
        int id = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select max(patient_id) from Patient";
            rs = smt.executeQuery(sql);
            rs.next();
            id = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public ResultSet Update_Patient(int id)
    {
        ResultSet rs = null;
        rs = this.Retrieve_Patient_id(id);
        return rs;
    }

    public int Update_Patient(int id, String name, String date_admitted, String date_discharged, String sex, String address, String contact_no, int age) {
       int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "update Patient set name='"+name+"',age="+age+",date_admitted='"+date_admitted+"',date_discharged='"+date_discharged+"',sex='"+sex+"',address='"+address+"',contact_no='"+contact_no+"' where patient_id="+id;
            System.out.println(sql);
            n = smt.executeUpdate(sql);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "EXception : "+ e.getMessage());
        }
        return n;
    }
/////////       PATIENT    ENDS  ///////////////////////////////    

    
/////////       EMPLOYEE    STARTS  ///////////////////////////////    
    public int Insert_Employee(int id, int salary, String name, String sex, String qualification, int experience, int shift, int age)
    {
        int n = 0;
        try
        {
            Statement smt = con.createStatement();
            String sql = "insert into Employee values ("+id+",'"+salary+"','"+name+"','"+sex+"','"+qualification+"',"+experience+","+shift+ ","+age+")" ;
            System.out.println(sql);
            n = smt.executeUpdate(sql);
            if (n == 1)
            {
                System.out.println("Success");
            }
            else 
            {
                System.out.println("Failed");          
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage());                    
        }
        return n;
        
    }
    
    public int Generate_Employee_Id()
    {
        ResultSet rs = null;
        int id = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select max(employee_id) from Employee";
            rs = smt.executeQuery(sql);
            rs.next();
            id = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int Delete_Employee()
    {
        int n = 0;
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID of Employee to be deleted."));
            Statement smt = con.createStatement();
            String sql = "delete from Employee where employee_id = " + id;
            n = smt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());                               
        }
        return n;
    }

public ResultSet Retrieve_Employee_id(int id)
{
    ResultSet rs = null;
        int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select * from Employee where employee_id = " + id ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rs;
}

    public ResultSet Retrieve_Emplpoyee_name(String name)
    {
        ResultSet rs = null;    
        int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select * from Employee where name like '%" + name + "%'";
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        //            return n;          
    }

        public ResultSet Retrieve_Employee_age(int age)
    {
        ResultSet rs = null;    
        int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select * from Employee where age = " + age ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        //            return n;          
    }

    public ResultSet Update_Employee(int id)
    {
        ResultSet rs = null;
        rs = this.Retrieve_Employee_id(id);
        return rs;
    }
    
public int Update_Employee(int id, int salary, String name, String sex, String qualification, int experience, int shift, int age)    
{
    int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "update Employee set salary ="+salary+",name='"+name+"',age="+age+",sex='"+sex+"',qualification='"+qualification+"',experience="+experience+",working_shift="+shift+" where employee_id="+id;
            System.out.println(sql);
            n = smt.executeUpdate(sql);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "EXception : "+ e.getMessage());
        }
    return n;
}
/////////       EMPLOYEE    ENDS  ///////////////////////////////    

    
/////////       RECORD    STARTS  ///////////////////////////////    
    public int Insert_Record(int rid, int pid, int eid, int rno, int amount) throws ClassNotFoundException, SQLException
    {
        int n = 0;
        try
        {
            Statement smt = con.createStatement();
            String sql = "insert into Record values ("+rid+","+pid+","+eid+","+rno+","+amount+")";
            n = smt.executeUpdate(sql);
        }
        catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage());                    
        }
        return n;
    }

    public int Delete_Record(int rid)
    {
        int n = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "delete from Record where record_no = " + rid;
            n = smt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());                               
        }
        return n;
    }

    public int Generate_Record_Id()
    {
        ResultSet rs = null;
        int id = 0;
        try {
            Statement smt = con.createStatement();
            String sql = "select max(employee_id) from Employee";
            rs = smt.executeQuery(sql);
            rs.next();
            id = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
public ResultSet Retrieve_Record_rid(int rid)
{
        ResultSet rs = null;    
        try 
        {
            Statement smt = con.createStatement();
            String sql = "select * from Record where record_no = " + rid ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) 
        {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}

public ResultSet Retrieve_Record_pid(int pid)
{
        ResultSet rs = null;    
        try 
        {
            Statement smt = con.createStatement();
            String sql = "select * from Record where patient_id =" + pid ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) 
        {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
public ResultSet Retrieve_Record_eid(int eid)
{
        ResultSet rs = null;    
        try 
        {
            Statement smt = con.createStatement();
            String sql = "select * from Record where employee_id = " + eid ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) 
        {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
public ResultSet Retrieve_Record_rno(int rno)
{
        ResultSet rs = null;    
        try 
        {
            Statement smt = con.createStatement();
            String sql = "select * from Record where room_no = " + rno ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) 
        {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
        /////////       RECORD    ENDS  ///////////////////////////////    

    
/////////       ROOM    STARTS  ///////////////////////////////    
    public int Delete_Room()
    {
        int n = 0;
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter no. of room to be deleted."));
            Statement smt = con.createStatement();
            String sql = "delete from Room where room_no = " + id;
            n = smt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());                               
        }
        return n;
    }

    public int Insert_Room(int rnumber, int pid, String rtype, String raval) throws ClassNotFoundException, SQLException
    {
        int n = 0;
        try
        {
            Statement smt = con.createStatement();
            String sql = "insert into Room values ("+rnumber+","+pid+",'"+rtype+"','"+raval+"')";
            n = smt.executeUpdate(sql);
        }
        catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage());                    
        }
        return n;
    }

    public int Insert_Room_null(int rnumber, String pid, String rtype, String raval) throws ClassNotFoundException, SQLException
    {
        int n = 0;
        try
        {
            Statement smt = con.createStatement();
            String sql = "insert into Room values ("+rnumber+","+pid+",'"+rtype+"','"+raval+"')";
            n = smt.executeUpdate(sql);
        }
        catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage());                    
        }
        return n;
    }

    public int Update_Room(int rnumber,int pid,String rtype,String raval)throws ClassNotFoundException, SQLException
{
         int n = 0;
         try
        {
            Statement smt = con.createStatement();
            String sql = "update Room set patient_id="+pid+",room_type='"+rtype+"',availability='"+raval+"' where room_no="+rnumber ;
            n = smt.executeUpdate(sql);
            if (n == 1)
            {
                System.out.println("Success");
            }
            else 
            {
                System.out.println("Failed");          
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception : " + e.getMessage());                    
        }
        return n;
    }

 public ResultSet Retrieve_Room_rno(int rno)
 {
     ResultSet rs = null;
        try 
        {
            Statement smt = con.createStatement();
            String sql = "select * from Room where room_no = " + rno ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) 
        {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
     return rs;
 }

  public ResultSet Retrieve_Room_pid(int pid)
 {
     ResultSet rs = null;
        try 
        {
            Statement smt = con.createStatement();
            String sql = "select * from Room where patient_id = " + pid ;
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) 
        {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
     return rs;
 }

    public ResultSet Retrieve_Room_type(String type)
 {
     ResultSet rs = null;
        try 
        {
            Statement smt = con.createStatement();
            String sql = "select * from Room where room_type = '" + type + "'";
            rs = smt.executeQuery(sql);
        } catch (SQLException ex) 
        {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
     return rs;
 }
    
public ResultSet Update_Room(int rno)
{
        ResultSet rs = null;
        rs = this.Retrieve_Room_rno(rno);
        return rs;
}
/////////       ROOM ENDS       //////////////////////////////

    }