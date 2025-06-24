import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatCard, MatCardModule } from '@angular/material/card';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInput, MatInputModule } from '@angular/material/input';
import { MatDatepicker, MatDatepickerModule } from '@angular/material/datepicker';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule ,MatIcon} from '@angular/material/icon';
import {MatRadioModule } from '@angular/material/radio';
import { EmployeDto } from '../../models/EmployeDTO';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-add-employe',
  imports: [MatCardModule,MatIconModule,MatRadioModule,
    MatFormFieldModule, ReactiveFormsModule, MatInputModule, MatDatepickerModule, MatButtonModule],
  templateUrl: './add-employe.component.html',
  styleUrl: './add-employe.component.css'
})
export class AddEmployeComponent implements OnInit {
  
  
  
  
  
  creationEmploye(): void {
    if (this.employeform.valid)
    {
        console.log("Les données envoyées sont :", this.employeform.value);
        const data = this.employeform.value;
        const employe: EmployeDto = {
        structureId: data.structureId,
        postetravailId: data.postetravailId,
        nom: data.nom,
        prenom: data.prenom,
        datenaissance:   new Date(data.datenaissance),
        daterecrutement: new Date(data.daterecrutement),
        nss: data.nss,
        telephone: data.telephone,
        adresse_1: data.adresse_1,
        matricule: data.matricule,
        email: data.email,
        sexe: data.sexe,
        pathphoto : ''
      };
      
      
      
      console.log("EMPLOYE DATA :", employe);
    }
    else
    {
      console.log("Formulaire INvalide");
      this.employeform.markAllAsTouched();
    }
    
}

  employeform!: FormGroup;

  constructor(private fb: FormBuilder, private http :HttpClient) { }
  

  ngOnInit(): void {
    
      this.employeform   = this.fb.group({
      structureId: [null, Validators.required],
      postetravailId: [null, Validators.required],
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      datenaissance: [null, Validators.required],
      email: ['', [Validators.required, Validators.email]],
      adresse_1: ['', Validators.required],
      sexe: ['', Validators.required],
      daterecrutement: [null, Validators.required],
      pathphoto: [''],
      nss: [null, Validators.required],
      matricule: ['', Validators.required],
      telephone: ['', Validators.required]



    });
  }

  formatDate(date: Date): string {
  const d = new Date(date);
  const jour = String(d.getDate()).padStart(2, '0');
  const mois = String(d.getMonth() + 1).padStart(2, '0');
  const annee = d.getFullYear();
  return `${jour}/${mois}/${annee}`;
}

}
