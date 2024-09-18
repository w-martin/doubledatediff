package features.cucumber;

import com.will_martin.application.MainApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@CucumberContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = MainApplication.class
)
@AutoConfigureMockMvc
public class SpringIntegrationTest {
    @Autowired
    private MockMvc mvc;

    protected MockHttpServletResponse executeGet(String url) throws Exception {
        return mvc.perform(get(url)).andReturn().getResponse();
    }
}
