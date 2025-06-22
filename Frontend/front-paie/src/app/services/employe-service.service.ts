import { Inject, Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EmployeDto } from '../models/EmployeDTO';

@Injectable({
  providedIn: 'root'
})
export class EmployeServiceService {

  private apiUrl = 'http://localhost:8081/api/employes';
  
  constructor(private http : HttpClient) { }

  getEmployes(): Observable<EmployeDto[]> {
    
    return this.http.get<EmployeDto[]>(this.apiUrl);
  }
}
