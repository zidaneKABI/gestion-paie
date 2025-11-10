import { Component } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TemplateComponent } from "./template/template.component";

@Component({
  selector: 'app-root',
  imports: [ TemplateComponent, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front-paie';
}
