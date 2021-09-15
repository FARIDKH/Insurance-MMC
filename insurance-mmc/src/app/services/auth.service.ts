import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";


@Injectable()
export class AuthService {


    constructor(private httpClient: HttpClient) { }

    login(phone : String, password : String){
        return this.httpClient.post(environment.host + "/userAuth/user/login",{phone,password});
    }

}