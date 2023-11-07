
package controller;

import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author rafar
 */
public class TaskController {
    public void save (Task task){
        String sql= "INSERT INTO tasks (idProject"
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,";
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?,)"; 
        Connection conn = null;
        PreparedStatement statement = null;  
        try {
            conn= ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setSring(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setInt(6, new Date(task.getDeadline().getTime()));
            statement.setInt(7, new Date(task.getCreatedAt().getTime()));
            statement.setInt(8, new Date(task.getUpdateAt().getTime()));          
            statement.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a tarefa");
        } 
        finally{
            ConnectionFactory.closeConnection(conn);
        }        
        
        
    }
    
    public void update ( Task task){
        
    }
    
    public void removeById (int TaskId){
        
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn= ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, TaskId);
            statement.execute();
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar a tarefa");
        } 
        finally{
            ConnectionFactory.closeConnection(conn);
        }
        
    }
    public List<Task> getAll ( int idProject){
        return null;
    }
    
    
}
