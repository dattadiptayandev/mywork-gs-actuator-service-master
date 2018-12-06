package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	private static final String welcomemsg = "Welcome Mr. %s!";

	@GetMapping("/hello-world")
	@ResponseBody
	public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/welcome/user")
	@ResponseBody
	public Welcome welcomeUser(@RequestParam(name = "name", required = false, defaultValue = "Java Fan") String name) {
		return new Welcome(String.format(welcomemsg, name));
	}

	@GetMapping("/default")
	@ResponseBody
	public ResponseEntity<Boolean> testOne() {
		return counter.intValue() % 2 == 0 ? new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK)
				: new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
	}

}
