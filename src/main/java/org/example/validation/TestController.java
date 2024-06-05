package org.example.validation;

import java.util.List;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class TestController {

	@PostMapping(path = "/bulk", consumes = APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@Validated(MyGroup.class)
	public Flux<String> createBatch(
			@RequestBody List<@Valid VocabularyRequest> requests) {
		return Flux.fromIterable(requests).map(VocabularyRequest::getId);
	}

}