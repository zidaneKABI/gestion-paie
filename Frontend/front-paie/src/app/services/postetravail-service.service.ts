import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PosteTravail } from '../models/PosteTravail';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class PostetravailServiceService {

   private readonly apiUrl = `${environment.apiUrl}/postetravails`;



  private readonly http  = inject(HttpClient)
  constructor() { }


  getPostetravail(): Observable<PosteTravail[]>{

      return this.http.get<PosteTravail[]>(this.apiUrl);
  }

}
