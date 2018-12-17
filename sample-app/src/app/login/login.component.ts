import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import {
  trigger,
  state,
  style,
  animate,
  transition,
  // ...
} from '@angular/animations';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private loginService: LoginService,
  ) { 
    this.createForm();
  }

  ngOnInit() {
  }

  private createForm() {
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', Validators.required]
    });
  }

  private login() {
    console.log(this.loginForm);
    this.loginService.obtainAccessToken(this.loginForm).subscribe(res => {
      localStorage.setItem('techmaster_token', res['access_token']);
      localStorage.setItem('techmaster_refresh', res['refresh_token']);
      this.router.navigate(['/']);
    });
  }

  register() {
    this.router.navigate(['/register']);
  }

}
