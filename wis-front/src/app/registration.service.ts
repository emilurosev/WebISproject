import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  uri = 'http://localhost:8080/register';

  constructor(private http: HttpClient) { }

  registerStudent(username: string, password: string, role: string, firstname: string, lastname: string, cardnumber:string) {
    let userForRegistration = {"username": username, "password": password, "role": role};
    let studentForRegistration = {"firstname": firstname, "lastname": lastname, "cardnumber": cardnumber};

    let objectToSend = {"user": userForRegistration, "student": studentForRegistration};
    this.http.post(`${this.uri}/student`, objectToSend).subscribe(res => {
      console.log(res);
    })
  }

  registerTeacher(username: string, password: string, role: string) {
    let userForRegistration = {"username": username, "password": password, "role": role};
    this.http.post(`${this.uri}`, userForRegistration).subscribe(res => {
      console.log(res);
    })
  }

  registerAdmin(username: string, password: string, role: string) {
    let userForRegistration = {"username": username, "password": password, "role": role};
    this.http.post(`${this.uri}`, userForRegistration).subscribe(res => {
      console.log(res);
    })
  }
}
