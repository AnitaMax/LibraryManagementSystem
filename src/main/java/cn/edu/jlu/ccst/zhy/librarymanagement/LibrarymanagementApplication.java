package cn.edu.jlu.ccst.zhy.librarymanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
@MapperScan("cn.edu.jlu.ccst.zhy.librarymanagement.Dao")
@ServletComponentScan
@SpringBootApplication
public class LibrarymanagementApplication {


    public static void main(String[] args) {
        SpringApplication.run(LibrarymanagementApplication.class, args);
    }

}
