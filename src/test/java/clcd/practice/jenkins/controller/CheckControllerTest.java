package clcd.practice.jenkins.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckControllerTest {

    @DisplayName("올바르게 헬스체크를 할 수 있다.")
    @Test
    void testMethodNameHere() {
        // given
        CheckController controller = new CheckController("value1", "value2");

        // when
        String response = controller.checkHealth();

        // then
        assertThat(response).isEqualTo("Test Fail!");
    }
}
