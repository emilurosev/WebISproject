import { Component, OnInit } from '@angular/core';
import Student from '../Student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-get-student',
  templateUrl: './get-student.component.html',
  styleUrls: ['./get-student.component.css']
})
export class GetStudentComponent implements OnInit {

  students: Student[];

  constructor(private ss: StudentService, private router: Router) { }


  deleteStudent(id) {
    this.ss.deleteStudent(id).subscribe(res => {
      console.log('Deleted');
      this.router.navigate(['students']);
      this.ngOnInit();
    });
  }

  ngOnInit() {
    this.ss
      .getStudents()
      .subscribe((data: Student[]) => {
        this.students = data;
    });
  }
}
