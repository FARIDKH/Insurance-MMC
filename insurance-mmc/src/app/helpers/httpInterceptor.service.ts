import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


@Injectable()
export class HttpInterceptorService implements HttpInterceptor {



    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
            const authReq = req.clone({
                headers : new HttpHeaders({
                    "Access-Control-Allow-Origin" : "*"
                })
            })
            console.log("httpInter")
            return next.handle(authReq)
    }
    
}