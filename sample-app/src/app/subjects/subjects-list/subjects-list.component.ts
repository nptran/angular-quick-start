import { template } from '@angular/core/src/render3';
import { Student } from './../../../../swagger/model/student';
import { JwtHelperService } from '@auth0/angular-jwt';
import { MarkControllerService } from './../../../../swagger/api/markController.service';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { BsModalService } from 'ngx-bootstrap/modal';
import { Component, OnInit, TemplateRef, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import { SubjectControllerService, StudentControllerService } from 'swagger';
import { Router } from '@angular/router';
import { $ } from 'protractor';

@Component({
  selector: 'app-subjects-list',
  templateUrl: './subjects-list.component.html',
  styleUrls: ['./subjects-list.component.scss'],
})
export class SubjectsListComponent implements OnInit {
  
  student: Student;
  subjects;
  theseSubjects;
  modalRef: BsModalRef;
  registration:boolean = false;

  constructor(
    private modalService: BsModalService,
    private router: Router,
    private subjectService: SubjectControllerService,
    private markService: MarkControllerService,
    private studentService: StudentControllerService
  ) {

    const helper = new JwtHelperService();
    
    const decodedToken = helper.decodeToken(localStorage.getItem('techmaster_token'));
    
    this.studentService.getStudentUsingGET(decodedToken.user_name).subscribe(res => {
      this.student = res;
    });
  }

  ngOnInit() {
    this.subjectService.getAllSubjectsUsingGET().subscribe(res=> {
      this.subjects = res;
    });

    //Handle Asynchronous when ngOnInit runs
    setTimeout(() => {this.getSubjects()},100);
  }

  getSubjects() {
    this.markService.getAllMarksUsingGET(this.student.id).subscribe(res => {
      this.theseSubjects = res;
    });
   
  }

  navigateToViewCourses(template: TemplateRef<any>) {
    /* This method must be here, cannot put this in ngOnInit or Constructor
    *  unless student.id would be undefinded.
    */
    this.getSubjects();

    this.modalRef = this.modalService.show(template);
  }

  navigateToRegisterCourses() {
    this.router.navigate(['/subjects/registration']);
  }
}
