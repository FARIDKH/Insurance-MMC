import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {


  title = 'insurance-mmc';
  client_id : any = null;

  ngOnInit(): void {
    if (localStorage.getItem("CLIENT_ID") != ''){
      this.client_id = localStorage.getItem("CLIENT_ID")
    } 
  }
  

}
