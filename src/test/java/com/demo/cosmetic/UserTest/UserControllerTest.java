package UserTest;


import com.demo.cosmetic.CosmeticApplication;
import com.demo.cosmetic.User.User;
import com.demo.cosmetic.User.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CosmeticApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAlluser(){
        List<User> userList= restTemplate.getForObject("/user", ArrayList.class);

        assertEquals("[{firstname=Pim, lastname=Jaidee, username=pimJaidee, password=123456}, {firstname=minmin, lastname=adminmin, username=admin, password=123456}]",userList.toString());
    }
}
