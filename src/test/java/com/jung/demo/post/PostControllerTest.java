package com.jung.demo.post;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class PostControllerTest {

    @Autowired
    private PostController postController;

    @Test
    void findAllTest() throws Exception{
        ResponseEntity<List<Post>> response = postController.findAll();
        
        List<Post> posts = response.getBody();
        assertNotNull(posts, "Response body should not be null");
        if (posts != null) {
            assertEquals(5, posts.size());
        }
    }
    // @Test
    void dbConnectTest() throws Exception{
        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";
        String user = "sa";

        Connection connection = DriverManager.getConnection(jdbcURL,user,"");
 
        System.out.println("Connected to H2 database.");
 
        String sql = "select * from TEST";
         
        Statement statement = connection.createStatement();
        ResultSet rs= statement.executeQuery(sql);
        while(rs.next()){
            // rs.getString(0);
            System.out.println("Value:"+rs.getString(2));    
        }
         
        System.out.println("===================================================");
         
        
         
        
 
        connection.close();
    }
}
