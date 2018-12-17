import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Student, StudentControllerService } from 'swagger';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.scss']
})
export class RegisterStudentComponent implements OnInit {

  registerForm: FormGroup;

  constructor(
    private studentService: StudentControllerService,
    private router: Router,
    private formBuilder: FormBuilder
  ) { 
    this.createForm();
  }

  ngOnInit() {
  }

  createForm() {
    this.registerForm = this.formBuilder.group( {
      name: [null, [Validators.required]],
      dob: [null, [Validators.required]]
    });
  }

  register() {
    let student: Student = {};
    student.name = this.registerForm.value.name;
    student.dob = this.registerForm.value.dob;

    this.studentService.saveStudentUsingPOST(student).subscribe(res => {
      this.router.navigate(['/login']);
    });
  }

  cancel(){
    this.router.navigate(['/']); 
  }

}
