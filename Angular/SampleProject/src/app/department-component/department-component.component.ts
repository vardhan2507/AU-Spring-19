import { Component, OnInit } from '@angular/core';
import { deepStrictEqual } from 'assert';

@Component({
  selector: 'app-department-component',
  templateUrl: './department-component.component.html',
  styleUrls: ['./department-component.component.css']
})
export class DepartmentComponentComponent implements OnInit {

  public depts:string[];
  constructor() {

    this.depts=[];
    this.depts.push("Sales");
    this.depts.push("Operations");
    this.depts.push("Research");
    this.depts.push("Administration");
    this.depts.push("HeadQuarters");
    
   }

  ngOnInit() {
  }

}
