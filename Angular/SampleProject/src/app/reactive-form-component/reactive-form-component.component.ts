import { Component, OnInit } from '@angular/core';

import { FormsModule, ReactiveFormsModule, FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-form-component',
  templateUrl: './reactive-form-component.component.html',
  styleUrls: ['./reactive-form-component.component.css']
})
export class ReactiveFormComponentComponent implements OnInit {

 public form: FormGroup;
 constructor(private formBuilder: FormBuilder){
  this.form = formBuilder.group({
    firstname: ['', Validators.required],
    lastname: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    phno: ['', Validators.required],

  });
}
  ngOnInit() {
  }

}
