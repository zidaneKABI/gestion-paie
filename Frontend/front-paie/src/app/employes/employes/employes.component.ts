import { Component, OnInit, ViewChild, inject } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import { EmployeDto } from '../../models/EmployeDTO';
import { MatSort, MatSortModule } from '@angular/material/sort';
import {  MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { EmployeServiceService } from '../../services/employe-service.service';
import { environment } from '../../../environments/environment';


@Component({
  standalone: true,
  selector: 'app-employes',
  imports: [
    CommonModule,RouterLink,MatButtonModule,MatCheckboxModule,
    HttpClientModule,  MatButtonModule,// ← Import indispensable ici !
    MatTableModule,MatIconModule,MatIconModule,
    MatCardModule,MatPaginatorModule,MatSortModule
  ],
  templateUrl: './employes.component.html',
  styleUrls: ['./employes.component.css']
})
export class EmployesComponent implements OnInit {


onDelete(id: number) {
   
  console.log("ID EMPLOYE = ", id);

this.employeService.deleteEmploye(id).subscribe(
    
    {
    next: () => {
      
        console.log("Employé Supprimé avec succés");
        this.employes = this.employes.filter(e => e.id !== id);
        this.datasource.data = this.employes;
     } 
      ,
    error: () => { console.log("Erreur à la supression de l'employé"); }
      

    }


  );
}
onEdit(_t76: any) {
throw new Error('Method not implemented.');
  }
  
  private readonly employeService = inject(EmployeServiceService)
  public employes!: EmployeDto[];
  public displayedColumns = ['matricule', 'nom', 'prenom', 'telephone','nss','actions'];
  public datasource!: MatTableDataSource<EmployeDto>;
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) matsort!: MatSort;
  private readonly apiUrl = `${environment.apiUrl}/employes`;

  ngAfterViewInit(): void {
    //Called after ngAfterContentInit when the component's view has been initialized. Applies to components only.
    //Add 'implements AfterViewInit' to the class.
   
  }
  
  constructor( private http: HttpClient){}
  ngOnInit(): void
  {
      this.http.get<EmployeDto[]>(this.apiUrl).subscribe({
      next: (data: EmployeDto[]) => {
          this.employes = data;
          this.datasource = new MatTableDataSource(this.employes);
          this.datasource.paginator = this.paginator;
          this.datasource.sort = this.matsort;
           
        },
      error: err => {
        console.error('Erreur récupération employés', err);
      }
    });
  }







}
