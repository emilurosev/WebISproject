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

import lms.domain.CourseRealization;
import lms.service.CourseRealizationService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/courserealization")
public class CourseRealizationController {

	@Autowired
	CourseRealizationService courseRealizationService;

	@RequestMapping()
	public ResponseEntity<Iterable<CourseRealization>> getAllCourseRealization() {
		return new ResponseEntity<Iterable<CourseRealization>>(courseRealizationService.getAllCourseRealization(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseRealization> getCourseRealizationById(@PathVariable Long id) {
		Optional<CourseRealization> courseRealization = courseRealizationService.getCourseRealizationId(id);
		if (courseRealization.isPresent()) {
			return new ResponseEntity<CourseRealization>(courseRealization.get(), HttpStatus.OK);
		}
		return new ResponseEntity<CourseRealization>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<CourseRealization> addCourseRealization(@RequestBody CourseRealization courseRealization) {

		courseRealizationService.addCourseRealization(courseRealization);
		return new ResponseEntity<CourseRealization>(courseRealization, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CourseRealization> updateCourseRealization(@PathVariable Long id, @RequestBody CourseRealization courseRealization) {
		courseRealizationService.updateCourseRealization(id, courseRealization);
		return new ResponseEntity<CourseRealization>(courseRealization, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CourseRealization> removeCourseRealization(@PathVariable Long id) {
		try {
			courseRealizationService.removeCourseRealization(id);
		} catch (Exception e) {
			return new ResponseEntity<CourseRealization>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CourseRealization>(HttpStatus.NO_CONTENT);
	}
}