package it.tasgroup.xtderp.xtdplatform.infrastructure.action.service;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = ActionServiceTest.TestConfig.class)
public class ActionServiceTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void execute() {

    }

    /*class TestConfig {

        @Bean
        public Actions actions() {
            return () -> Collections.<Action>emptyList().iterator();
        }

        @Bean
        public ActionLookup actionLookup() {
            return MockAction::new;
        }
    }

    @RequiredArgsConstructor
    class MockAction implements Action {

        private final String id;

        @Override
        public Result execute(Request request) {
            return new LoopBackResult(request);
        }

        @Override
        public String id() {
            return id;
        }
    }*/
}