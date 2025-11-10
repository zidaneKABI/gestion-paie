import {  Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Structure} from '../models/Structure'
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StructureServiceService {

 private readonly apiUrl = `${environment.apiUrl}/structures`;



  constructor(private http : HttpClient) { }

  getStructure(): Observable<Structure[]> {
    return this.http.get<Structure[]>(this.apiUrl);
  }
}
