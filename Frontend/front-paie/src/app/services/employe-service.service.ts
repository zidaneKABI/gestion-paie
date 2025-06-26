import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EmployeDto } from '../models/EmployeDTO';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeServiceService {
  private readonly apiUrl = 'http://localhost:8081/employes';

  constructor(private readonly http: HttpClient) {}

  getEmployes(): Observable<EmployeDto[]> {
    console.log("Je vais aller récuperer la liste des employés");
    return this.http.get<EmployeDto[]>(this.apiUrl);
  }

  getavailableMatricule(nom:string): Observable<string>{
   
    return this.http.get(`${this.apiUrl}/matricule/${nom}`, { responseType: "text" });
 }

}
