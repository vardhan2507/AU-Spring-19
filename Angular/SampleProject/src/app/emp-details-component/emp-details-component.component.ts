import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import { PARAMETERS } from '@angular/core/src/util/decorators';
import {SampleServiceService} from '../sample-service.service';

@Component({
  selector: 'app-emp-details-component',
  templateUrl: './emp-details-component.component.html',
  styleUrls: ['./emp-details-component.component.css']
})
export class EmpDetailsComponentComponent implements OnInit {

  tempID:number;
  users: Object;

  constructor(private route: ActivatedRoute, private sampleService:SampleServiceService) { 
    this.route.params.subscribe( params => this.tempID=params.id );
    console.log(this.tempID);
  }

  ngOnInit() {
    this.sampleService.getUsers().subscribe(data => {
      this.users=data;
    });
  }

}
