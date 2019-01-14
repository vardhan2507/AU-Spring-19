import { Component, OnInit, Input } from '@angular/core';
import {SampleServiceService} from '../sample-service.service';
import { SampleComponentComponent } from '../sample-component/sample-component.component';

@Component({
  selector: 'app-employee-list-component',
  templateUrl: './employee-list-component.component.html',
  styleUrls: ['./employee-list-component.component.css']
})
export class EmployeeListComponentComponent implements OnInit {

  @Input()
  count:number;
  users: Object;
  empID:number;

  getEmpDetails(i:number){

    this.empID=i+1;
  }

  constructor(private sampleService:SampleServiceService) {
  
   }

  ngOnInit() {

    this.sampleService.getUsers().subscribe(data => {

      this.users=data;
    });
  }

}
