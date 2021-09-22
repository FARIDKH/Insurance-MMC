

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
    constructor(
        private route : ActivatedRoute,
        private router : Router,
        private authService :AuthService) { }

    email : String = ""
    password : String =  ""

    ngOnInit(): void {
        localStorage.setItem("CLIENT_ID",'')
    }

    submitLogin(){
        this.authService.login(this.email,this.password).subscribe((c) => {
            localStorage.setItem("CLIENT_ID", Object(c)["client_id"])
                this.router.navigate(['/profile'])
        })
    }
}
