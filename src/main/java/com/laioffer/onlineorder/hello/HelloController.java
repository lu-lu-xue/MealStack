package com.laioffer.onlineorder.hello;

import net.datafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luluxue
 * @date 2024-09-29 2:24PM
 */
@RestController
public class HelloController {
	@GetMapping("/hello")
	public Person sayHello(@RequestParam(required = false) String name){
		if (name == null){
			name = "Guest";
		}
		Faker faker = new Faker();
//		String name = faker.name().firstName();
		String company = faker.company().name();
		String street = faker.address().streetAddress();
		String city = faker.address().city();
		String state = faker.address().state();
//		String country = faker.address().country();
		String bookTitle = faker.book().title();
		String bookAuthor = faker.book().author();
		
		String template = "This is %s\n" +
				"I work at %s\n" +
				"I live at %s in %s %s\n" +
				"My favorite book is %s by %s\n";
		
//		return template.formatted(
//				name,
//				company,
//				street,
//				city,
//				state,
//				bookTitle,
//				bookAuthor
//		);
		return new Person(name, company,new Address(street,city,state,null), new Book(bookTitle,bookAuthor));
	}
}