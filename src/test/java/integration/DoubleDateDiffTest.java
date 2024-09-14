package integration;

import com.will_martin.application.MainApplication;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = MainApplication.class)
@AutoConfigureMockMvc
public class DoubleDateDiffTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void should_double_dates_given_in_ascending_order() throws Exception {
        // arrange
        final String a = LocalDate.now().toString();
        final String b = LocalDate.now().plusDays(1).toString();
        final String expected = LocalDate.now().plusDays(2).toString();
        // act
        mvc.perform(get("/doubledatediff/{dateOne}/{dateTwo}", a, b))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    final String actual = result.getResponse().getContentAsString();
                    // assert
                    assert actual.equals(expected);
                });
    }

    @Test
    public void should_double_dates_given_in_descending_order() throws Exception {
        // arrange
        final String a = LocalDate.now().toString();
        final String b = LocalDate.now().plusDays(1).toString();
        final String expected = LocalDate.now().plusDays(2).toString();
        // act
        mvc.perform(get("/doubledatediff/{dateOne}/{dateTwo}", b, a))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    final String actual = result.getResponse().getContentAsString();
                    // assert
                    assert actual.equals(expected);
                });
    }
}
