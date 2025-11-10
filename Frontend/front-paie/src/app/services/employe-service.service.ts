import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EmployeDto } from '../models/EmployeDTO';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeServiceService {
  private readonly apiUrl = `${environment.apiUrl}/employes`;

  constructor(private readonly http: HttpClient) {}

  getEmployes(): Observable<EmployeDto[]> {
    console.log("Je vais aller récuperer la liste des employés");
    return this.http.get<EmployeDto[]>(this.apiUrl);
  }

 getavailableMatricule(nom:string): Observable<string>{
   
 return this.http.get(`${this.apiUrl}/matricule/${nom}`, { responseType: "text" });
 }

 deleteEmploye(id: number): Observable<any>{
   
    return this.http.delete(`${this.apiUrl}/${id}`);
 } 
  
}
