import { Component, OnInit } from '@angular/core';
import { StudentControllerService, Student } from 'src/swagger';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.scss'],
  providers: [ StudentControllerService ]
})
export class StudentCreateComponent implements OnInit {

  studentForm: FormGroup;

  constructor(
    private router: Router,
    private form: FormBuilder,
    private studentService: StudentControllerService
  ) {
    this.createForm();
   }

  ngOnInit() {
  }

  private createForm() {
    this.studentForm = this.form.group(
      {
        name: [null, [Validators.required, Validators.minLength(2)]],
        class: [null, [Validators.required]],
        age: [null, [Validators.min(18)]]
      }
    );
  }

  create() {

    let student:Student = {};
    
    student.name = this.studentForm.value.name;
    student.clazz = this.studentForm.value.class;
    student.age = this.studentForm.value.age;

    this.studentService.insertStudentUsingPOST(student).subscribe(res => {
      this.router.navigate(['/students']);
    })

  }

  cancel() {
    this.router.navigate(['/students']);
  }

  clear() {
    this.createForm();
  }

}
