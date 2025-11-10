import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl,FormsModule, FormGroup, Validators } from '@angular/forms';
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
import { StructureServiceService } from '../../services/structure-service.service';
import { Structure } from '../../models/Structure';
import { MatSelect,MatSelectModule} from '@angular/material/select'
import { CommonModule } from '@angular/common';
import { PosteTravail } from '../../models/PosteTravail';
import { PostetravailServiceService } from '../../services/postetravail-service.service';
import { Codepaie } from '../../models/Codepaie';
import { debounceTime, distinctUntilChanged, filter } from 'rxjs/operators';
import { EmployeServiceService } from '../../services/employe-service.service';
import { Codeirg } from '../../models/Codeirg';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-add-employe',
  imports: [MatCardModule,MatIconModule,MatRadioModule,MatSelectModule,CommonModule,FormsModule,
    MatFormFieldModule, ReactiveFormsModule, MatInputModule, MatDatepickerModule, MatButtonModule],
  templateUrl: './add-employe.component.html',
  styleUrl: './add-employe.component.css'
})
export class AddEmployeComponent implements OnInit {
  
  private readonly apiUrl = 'http://localhost:8081/employes';
  
  
  
  creationEmploye(): void {
    if (this.employeform.valid)
    {
        console.log("Les données envoyées sont :", this.employeform.value);
        const data = this.employeform.value;
        const employe: EmployeDto = {
        id: 0,
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
        email:  data.email,
        sexe:   data.sexe,
        pathphoto: '',
        distance: 0,
        codeirg:  data.codeirg,
        codepaie: data.codepaie,
        stituationfamille: '',
        coderecrutement:''
        
        };
      
      //  - Envoyer de l'objet construit au backend avec la méthode poste

        this.http.post(this.apiUrl, employe).subscribe({
          next: (response) =>
          {
            console.log("L'employé a été enregistré avec succés", response);
            this.snackbar.open('Employé enregistré avec succès !', 'Fermer', {
            duration: 5000, // 3 secondes
            panelClass: ['snackbar-success'], // classe CSS personnalisée (optionnel)
            });
            this.employeform.reset();
           },
            error: (error) => {
            console.log("Erreur lors de l'enregistrement de l'employé", error); 
            
          this.snackbar.open('Erreur lors de l\'enregistrement', 'Fermer', {
          duration: 3000,
          panelClass: ['snackbar-error'],
        });


          }
     });
      
      console.log("EMPLOYE DATA :", employe);
    } 
    else
    {
      console.log("Formulaire Invalide");
      this.employeform.markAllAsTouched();
    }
    
}

  employeform!: FormGroup;
  structures: Structure[]=[];
  postetravails: PosteTravail[] = []
  codepaies: string[] = [];
  codeirgs: string[] = [];  
  private readonly posteTravailserive = inject(PostetravailServiceService);
  private readonly employeservice = inject(EmployeServiceService)

  constructor(private fb: FormBuilder,
             private  http: HttpClient,
             private  structureservice: StructureServiceService,
             private  snackbar : MatSnackBar) { }
  
  structure =new FormControl<Structure | null>(null, Validators.required);
      
  private dernirePremireletre: string | null = null;       

  ngOnInit(): void {
    

    //récuperation des valeurs code irg à partir de l'énumeration
    
    for(let elem in Codeirg)
    {
      console.log("CODE IRG" + elem);
      if (typeof Codeirg[elem] === 'string')
        this.codeirgs.push(Codeirg[elem]);

    }

    this.codeirgs.forEach(element => {
      console.log("VALEUR :" + element);      
    });

    // Récuperation des valeurs à partir de l'énumeration Code paie    
      for (let elem in Codepaie) {
      if (typeof Codepaie[elem] === 'string')
      this.codepaies.push(Codepaie[elem]);
    
      }
    
      //Récupération de la liste des postes de travail via API REST
      this.posteTravailserive.getPostetravail().subscribe(
      {
        next: data => {
          this.postetravails = data;
          console.log("la liste des poste de travail a été récupérée", this.postetravails);
        },
        error: error => console.log("Erreur à la récupération des poste de travail", error)

      }

    )
    // Récuparation de la liste des structures Via à API REST
    this.structureservice.getStructure().subscribe({
      next: data => {
        this.structures = data;
        console.log("La liste des strcutures est :", this.structures);
         
         this.structures.forEach(element => {
          console.log(element.libelle);
        });
      },
      error: error => console.log("Impossible de récuéperer la liste des structures")
      
    });

    
   
      // Initialisation des champs de ReactiveForm de l'employé
      this.employeform = this.fb.group({
      structureId: [2, Validators.required],
      postetravailId: [2, Validators.required],
      nom: ['KABI', Validators.required],
      prenom: ['ZIDANE', Validators.required],
      datenaissance: [null, Validators.required],
      email: ['zidane.kabi@gamil.com', [Validators.required, Validators.email]],
      adresse_1: ['19 rue du collége', Validators.required],
      sexe: ['Homme', Validators.required],
      daterecrutement: [null, Validators.required],
      pathphoto: ['1'],
      nss: ['111111', Validators.required],
      matricule: ['111', Validators.required],
      telephone: ['075304581', Validators.required],
      codeirg: ['1'],
      codepaie: ['1'],
      distance: ['1']
     
      });
    
    
    // inscription d'un événements pour le champs nom valueChange
    //
      this.employeform.get('nom')?.valueChanges.pipe(
      debounceTime(500),                  // attend 500ms après la dernière saisie
      distinctUntilChanged(),             // ignore si la même valeur est resaisie
      filter(nom => nom!==null) // ignore les valeurs vides
      ).subscribe( nom => {
      
          if (nom.length > 0)  {
        
          const premierelettre = nom.charAt(0).toUpperCase();
        
          if (premierelettre  !==  this.dernirePremireletre)
          {
        
            this.dernirePremireletre = premierelettre;

            this.employeservice.getavailableMatricule(nom).subscribe({
            next: data => {
              this.employeform.patchValue({ matricule: data })
            },
            error: e => console.error("impossible de générer le matricule", e)
          
            })


          }
  
        }
        else
         {
         this.dernirePremireletre = null;
         this.employeform.patchValue({ matricule: '' });
         }


      });
          
    
    
  }

  formatDate(date: Date): string {
  const d = new Date(date);
  const jour = String(d.getDate()).padStart(2, '0');
  const mois = String(d.getMonth() + 1).padStart(2, '0');
  const annee = d.getFullYear();
  return `${jour}/${mois}/${annee}`;
  }
  
  getStructureLibelle(): string | undefined {
  const id = this.employeform.get('structureId')?.value;
  return this.structures.find(s => s.idstructure === id)?.libelle;
}

}
