package service;

import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

class Start {
    public static void main(String[] data) {
        var context = SpringApplication.run(Setup.class);
        LinkedList w = context.getBean(LinkedList.class);
        System.out.println(w);
    }
} 

@SpringBootApplication
class Setup {
    @Bean LinkedList create1() {
        LinkedList a = new LinkedList();
        a.add("a");
        a.add("b");
        a.add("c");
        return a;
    }
    @Bean DriverManagerDataSource connect(){
        return new DriverManagerDataSource(Source);
    }
    String Source = "jdbc:mysql://127.0.0.1" +
                    "/sample_august_2023" +
                    "?user=frank&password=lampard";
}

@RestController
class Sample {
    @RequestMapping("/api/get-products")
    LinkedList m1() {
        return products;
    }
    
    @RequestMapping("/api/get-branch")
    Iterable m2() {
        return bs.findAll();
    }
    
    @Autowired LinkedList products;
    @Autowired BranchStorage bs;
}

@Table("branch")
class Branch {
    int number;
    double area;
    String name;
}

@Repository
interface BranchStorage  extends CrudRepository<Branch, Integer> { }

