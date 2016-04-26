import {Component} from 'angular2/core';
import {ROUTER_DIRECTIVES} from 'angular2/router';
import {MdButton} from '@angular2-material/button';

@Component({
  selector: 'sd-navbar',
  templateUrl: 'app/components/navbar.component.html',
  styleUrls: ['app/components/navbar.component.css'],
  directives: [ROUTER_DIRECTIVES, MdButton]
})
export class NavbarComponent {}
