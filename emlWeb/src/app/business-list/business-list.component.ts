import { Component } from '@angular/core';
import {MyserviceService} from "../myservice.service";
import { Router } from '@angular/router';
@Component({
  selector: 'app-business-list',
  templateUrl: './business-list.component.html',
  styleUrls: ['./business-list.component.css']
})
export class BusinessListComponent {
  allbusiness:any[]=[];
  constructor(public myservice:MyserviceService,
              public router:Router) {

  }
  ngOnInit(){
    this.myservice.getallbusiness().subscribe((response:any)=>{
        console.log(response);
        this.allbusiness=response;
      },
      (error) => {
        console.log("Some error in catch");
        if (error.status === 401 || error.status === 403){
          this.router.navigate(['/login']);//没有权限，跳转登录页面
        }
      });

  }

}
