import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sample-component',
  templateUrl: './sample-component.component.html',
  styleUrls: ['./sample-component.component.css']
})
export class SampleComponentComponent implements OnInit {

  public empName:string;
  public date:Date;

 

  constructor() {
    this.date=new Date();
    this.empName="Vardhan";
   
  
   }

  ngOnInit() {
  }

  
}
