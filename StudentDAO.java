import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO 
{
    public void addStudent(Student s) 
    {
        try 
        {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "insert into student values(?,?,?)"
            );

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setDouble(3, s.getMarks());

            ps.executeUpdate();

            System.out.println("Inserted");
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public void viewStudents() 
    {
        try 
        {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "select * from student"
            );

            ResultSet rs = ps.executeQuery();

            while(rs.next()) 
            {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getDouble(3)
                );
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public void updateStudent(int id, double marks) 
    {
        try 
        {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "update student set marks=? where id=?"
            );

            ps.setDouble(1, marks);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Updated");
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public void deleteStudent(int id) 
    {
        try 
        {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "delete from student where id=?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Deleted");
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}
