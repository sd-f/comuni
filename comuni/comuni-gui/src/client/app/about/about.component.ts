import { Component } from '@angular/core';
import {MD_CARD_DIRECTIVES} from '@angular2-material/card';

@Component({
  moduleId: module.id,
  selector: 'cm-about',
  templateUrl: 'about.component.html',
  styleUrls: ['about.component.css'],
  directives: [MD_CARD_DIRECTIVES]
})
export class AboutComponent {}
