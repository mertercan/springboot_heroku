package io.schultz.dustin.todoapp;

import io.schultz.dustin.todoapp.controller.TodoController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoAppApplicationTests {

	@Test
	void hello() {
		TodoController controller = new TodoController();
		String response = controller.hello("World");
		assertEquals("Hello,World",response);

	}

}
