package in.cdac.hms.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.hms.dto.StudentDto;
import in.cdac.hms.payload.AllotmentStatus;
import in.cdac.hms.payload.ApiResponse;
import in.cdac.hms.service.IStudentService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

	private IStudentService studentService;

	@GetMapping
	public ResponseEntity<StudentDto> getStudent() {
		return ResponseEntity.ok().body(studentService.viewStudent());
	}

	@PutMapping
	public ResponseEntity<ApiResponse> updateStudent(@RequestBody StudentDto studentDto) {
		return ResponseEntity.ok().body(studentService.updateStudent(studentDto));
	}

	@GetMapping("/get-all-students")
	public ResponseEntity<Page<StudentDto>> getAllStudents(Pageable pageable) {
		return ResponseEntity.ok().body(studentService.getAllStudents(pageable));
	}
	
	@PostMapping("/make-payment")
	public ResponseEntity<ApiResponse> makePayment(@RequestParam String transactionId) {
		return ResponseEntity.ok().body(studentService.makePayment(transactionId));
	}

	@PostMapping("/book")
	public ResponseEntity<ApiResponse> bookRoom(@RequestParam int roomId) {
		return ResponseEntity.ok().body(studentService.bookRoom(roomId));
	}

	@GetMapping("/allottment")
	public ResponseEntity<AllotmentStatus> getAllotmentStatus() {
		return ResponseEntity.ok().body(studentService.getAllotmentStatus());
	}
}
