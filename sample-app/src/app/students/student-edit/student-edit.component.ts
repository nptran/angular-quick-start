import { Component, OnInit } from '@angular/core';
import { Student, StudentControllerService } from 'src/swagger';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.scss'],
  providers: [StudentControllerService]
})
export class StudentEditComponent implements OnInit {

  id;
  student: Student;
  studentForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router:Router,
    private studentService:StudentControllerService,
    private form: FormBuilder,
  ) { }

  ngOnInit() {
    this.route.params.subscribe( param => {
      this.id = param.id;

      this.studentService.findStudentUsingGET(this.id).subscribe(res => {
        this.student = res;
        this.createForm(this.student);
      });
    });
  }

  private createForm(student: Student) {
    this.studentForm = this.form.group({
      name: [student.name, [Validators.minLength(2), Validators.required]],
      class: [student.clazz, [Validators.required]],
      age: [student.age, [Validators.min(18)]]
    });
  }

  update() {

    let student: Student = {};

    student.id = this.id;
    student.name = this.studentForm.value.name;
    student.clazz = this.studentForm.value.class;
    student.age = this.studentForm.value.age;

    this.studentService.insertStudentUsingPOST(student).subscribe(res=> {
        this.router.navigate(['/students']);
      }, err => { }
    )
  }

  cancel() {
    this.router.navigate(['/students']);
  }

}
