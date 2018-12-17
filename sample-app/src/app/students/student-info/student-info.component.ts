import { Mark } from './../../../../swagger/model/mark';
import { MarkControllerService } from './../../../../swagger/api/markController.service';
import { Student } from './../../../../swagger/model/student';
import { StudentControllerService } from './../../../../swagger/api/studentController.service';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.scss']
})
export class StudentInfoComponent implements OnInit {
  
  student: Student;
  avg;
  hidden: boolean = true;
  labelShowHide = "Show";

  constructor(
    private studentService : StudentControllerService,
    private router: Router,
    private markService: MarkControllerService
    ) {
     
    const helper = new JwtHelperService();

    const decodedToken = helper.decodeToken(localStorage.getItem('techmaster_token'));

    this.studentService.getStudentUsingGET(decodedToken.user_name).subscribe(res => {
      this.student = res;
    });

  }

  ngOnInit() {
  }

  navigateToRegister() {
    this.router.navigate(['/subjects/registration'])
  }

  showGPA() {
    this.labelShowHide = this.hidden ?"Hide":"Show";
    this.hidden = !this.hidden;
    this.markService.getAvgMarkUsingGET(this.student.id).subscribe(res => {
      if(res<0) {
        this.avg = 'Updating';
      } else {
        this.avg = res;
      }
    });
  }

}
