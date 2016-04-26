import {Component} from 'angular2/core';
import {MD_CARD_DIRECTIVES} from '@angular2-material/card';

@Component({
  selector: 'sd-about',
  templateUrl: 'app/+about/components/about.component.html',
  styleUrls: ['app/+about/components/about.component.css'],
  directives: [MD_CARD_DIRECTIVES]
})
export class AboutComponent {}
