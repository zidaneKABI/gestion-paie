import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { EmployeDto } from '../../models/EmployeDTO';
import { EmployeServiceService } from '../../services/employe-service.service';
@Component({
  selector: 'app-employes',
  imports: [MatCardModule,
           MatTableModule
  ],
  templateUrl: './employes.component.html',
  styleUrl: './employes.component.css'
})
export class EmployesComponent implements OnInit {

  private readonly employeservice = inject(EmployeServiceService);
  public datasource: any;
  public employes!: EmployeDto[];

  public displayedColumns  : string[] = ['matricule','nom', 'prenom', 'email', 'datenaissance', 'daterecrutement','sexe','nss','telephone'];
  
    
   
  ngOnInit(): void {

    this.employeservice.getEmployes().subscribe({
      next: data => { this.employes = data }
      ,
      error: () => console.log("erreur de recuperation des employés")

    });
      
  }



}
