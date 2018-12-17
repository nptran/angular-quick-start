import { Student } from './../../../../swagger/model/student';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import { Subject } from './../../../../swagger/model/subject';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { TeacherControllerService, SubjectControllerService, MarkControllerService, Mark, StudentControllerService, Teacher } from 'swagger';
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'app-subjects-registration',
  templateUrl: './subjects-registration.component.html',
  styleUrls: ['./subjects-registration.component.scss']
})
export class SubjectsRegistrationComponent implements OnInit {

  subjectForm: FormGroup;
  subjects: Array<Subject>;
  teachers: Array<Teacher>;
  student: Student;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private subjectService: SubjectControllerService,
    private teacherService: TeacherControllerService,
    private markService: MarkControllerService,
    private studentService: StudentControllerService
  ) {
    
    const helper = new JwtHelperService();
    
    const decodedToken = helper.decodeToken(localStorage.getItem('techmaster_token'));
    
    this.studentService.getStudentUsingGET(decodedToken.user_name).subscribe(res => {
      this.student = res;
    });

    this.teacherService.getAllTeachersUsingGET().subscribe( res => {
      this.teachers = res;
    });
    this.subjectService.getAllSubjectsUsingGET().subscribe( res => {
      this.subjects = res;
    })
    this.createForm();
  }
  
  ngOnInit() {
  }
  
  createForm() {
    this.subjectForm = this.formBuilder.group({
      subject: [Validators.required],
      teacher: [Validators.required]
    });
  }

  register() {
    let mark: Mark = {};
 
    mark.subject = this.subjectForm.value.subject;
    mark.teacher = this.subjectForm.value.teacher;
    mark.studentmark = null;

    this.markService.postMarkUsingPOST(mark).subscribe(res => {
      this.router.navigate(['/subjects']);
    }, err => {

    })
  }

  cancel() {
    this.router.navigate(['/subjects']);
  }

}
