package sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MeetupController {
	final MeetupProperties meetup;
	
	@GetMapping("/")
	String meetup() {
		return "Hi " + meetup.getLocation() + "! "+ meetup.getAttendees();
	}
}
