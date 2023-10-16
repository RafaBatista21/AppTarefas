/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author rafar
 */
public class ConectionFactory {
        
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        private static final String URL = "jdbc:mysql://localhost:3306/apptarefas";
        private static final String USER = "root";
        private static final String PASS = "";
    
        public static Connection getConnection(){
            try {
                Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USER, PASS);
            } catch (Exception ex) {
                throw new RuntimeException("Erro na connexao com o banco de dados", ex);
            }
            
        }
        public static void closeConnection (Connection connection){
            try {
                if (connection != null){
                    connection.close();
                }
            } catch (Exception ex) {
               throw new RuntimeException("Erro ao fechar connexao com o banco de dados", ex);
            }   
        }
} 