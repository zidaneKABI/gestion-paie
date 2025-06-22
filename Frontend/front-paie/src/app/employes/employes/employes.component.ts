import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
@Component({
  selector: 'app-employes',
  imports: [MatCardModule,
           MatTableModule
  ],
  templateUrl: './employes.component.html',
  styleUrl: './employes.component.css'
})
export class EmployesComponent implements OnInit {

  private readonly http = inject(HttpClient);
  dataSource: any  ;
  public displayedColumns  : string[] = ['nom', 'prenom', 'email', 'categorie', 'salairebase'];
  


  ngOnInit(): void {
      
  }



}
