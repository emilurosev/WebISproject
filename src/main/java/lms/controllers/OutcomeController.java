package lms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.domain.Outcome;
import lms.service.OutcomeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/outcome")
public class OutcomeController {

	@Autowired
	OutcomeService outcomeService;

	@RequestMapping()
	public ResponseEntity<Iterable<Outcome>> getOutcome() {
		return new ResponseEntity<Iterable<Outcome>>(outcomeService.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Outcome> getOutcomeById(@PathVariable Long id) {
		Optional<Outcome> courseOutcome = outcomeService.getOutcome(id);
		if (courseOutcome.isPresent()) {
			return new ResponseEntity<Outcome>(courseOutcome.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Outcome>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Outcome> addOutcome(@RequestBody Outcome courseOutcome) {

		outcomeService.addOutcome(courseOutcome);
		return new ResponseEntity<Outcome>(courseOutcome, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Outcome> updateOutcome(@PathVariable Long id, @RequestBody Outcome courseOutcome) {
		outcomeService.updateOutcome(id, courseOutcome);
		return new ResponseEntity<Outcome>(courseOutcome, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Outcome> removeOutcome(@PathVariable Long id) {
		try {
			outcomeService.removeOutcome(id);
		} catch (Exception e) {
			return new ResponseEntity<Outcome>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Outcome>(HttpStatus.NO_CONTENT);
	}
}
