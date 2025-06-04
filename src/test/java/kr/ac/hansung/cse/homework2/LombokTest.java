package kr.ac.hansung.cse.homework2;
import lombok.Getter;
import org.junit.jupiter.api.Test;

@Getter
public class LombokTest {
    private String name;

    @Test
    public void test() {
        LombokTest test = new LombokTest();
        test.getName();
    }
}

