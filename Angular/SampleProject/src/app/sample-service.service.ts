import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SampleServiceService {

  constructor(private httpClient:HttpClient) {

   


   }

  getUsers(){

    return this.httpClient.get('https://gorest.co.in/public-api/users?_format=json&access-token=ggolvSv4UpUH_a9Qk5x5KAC2YudbptpltVYZ');
    }
    
  }

