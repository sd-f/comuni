import { Component } from '@angular/core';
import {MdToolbar} from '@angular2-material/toolbar';
import {MdIcon, MdIconRegistry} from '@angular2-material/icon/icon';
import {MdButton, MdAnchor} from '@angular2-material/button/button';

/**
 * This class represents the toolbar component.
 */
@Component({
  moduleId: module.id,
  selector: 'sd-toolbar',
  templateUrl: 'toolbar.component.html',
  styleUrls: ['../../theme.css', 'toolbar.component.css'],
  directives: [MdToolbar, MdIcon, MdButton , MdAnchor],
  viewProviders: [MdIconRegistry],
})
export class ToolbarComponent {}
