import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';
import { HTTP_PROVIDERS } from '@angular/http';

import { Config, ToolbarComponent } from './shared/index';

@Component({
  moduleId: module.id,
  selector: 'cm-app',
  viewProviders: [HTTP_PROVIDERS],
  templateUrl: 'app.component.html',
  styleUrls: ['theme.css'],
  directives: [ROUTER_DIRECTIVES, ToolbarComponent]
})
export class AppComponent {
  constructor() {
    console.log('Environment config', Config);
  }
}
