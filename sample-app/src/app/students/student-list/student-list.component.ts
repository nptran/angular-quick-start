import { Component, OnInit } from '@angular/core';
import { StudentControllerService } from 'src/swagger';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.scss'],
  providers: [ StudentControllerService ]
})
export class StudentListComponent implements OnInit {

  students = [];

  constructor(
    private studentServie: StudentControllerService,
    private router: Router
  ) { }

  // Run it when web-page runs
  ngOnInit() {
    this.studentServie.getAllStudentsUsingGET().subscribe(res =>{
      this.students = res;
    })
  }

  navigateToCreate() {
    this.router.navigate(['students/create']);
  }

  delete(student) {
    let i = this.students.indexOf(student);

    this.studentServie.deleteStudentUsingDELETE(student.id).subscribe(res => {
      this.students.splice(i, 1);
    })
  }
}
