import {  Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Structure} from '../models/Structure'

@Injectable({
  providedIn: 'root'
})
export class StructureServiceService {
 private readonly apiUrl = 'http://localhost:8081/structures';



  constructor(private http : HttpClient) { }

  getStructure(): Observable<Structure[]> {
    return this.http.get<Structure[]>(this.apiUrl);
  }
}
