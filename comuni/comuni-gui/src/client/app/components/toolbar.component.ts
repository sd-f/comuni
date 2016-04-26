import {Component} from 'angular2/core';
import {MdToolbar} from '@angular2-material/toolbar';

@Component({
  selector: 'sd-toolbar',
  templateUrl: 'app/components/toolbar.component.html',
  styleUrls: ['app/components/toolbar.component.css'],
  directives: [MdToolbar]
})
export class ToolbarComponent {}
