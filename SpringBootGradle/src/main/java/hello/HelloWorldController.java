package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Autor> sayHello( @RequestBody Autor autor ) {
		return new ResponseEntity<Autor>( autor, HttpStatus.OK );
	}
}
