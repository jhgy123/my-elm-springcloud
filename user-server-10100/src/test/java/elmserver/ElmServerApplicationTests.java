package elmserver;

import com.example.elmspringcloud.entities.dto.CommonResult;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
class ElmServerApplicationTests {

    @Test
    void contextLoads() {
       CommonResult A= new CommonResult(200,"test",null);
        System.out.println(A);
    }

}
