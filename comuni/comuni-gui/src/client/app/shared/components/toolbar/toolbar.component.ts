import {Component, OnInit} from '@angular/core';
import {MdToolbar} from '@angular2-material/toolbar';
import {MdIcon, MdIconRegistry} from '@angular2-material/icon/icon';
import {MdButton, MdAnchor} from '@angular2-material/button/button';
import {ConversationService} from '../../conversation/conversation.service';
import {InformingAboutMyName} from '../../../home/conversation/InformingAboutMyName';
import {WHAT_IS_YOUR_NAME} from '../../../home/conversation/HomeQuestions';
import {Question} from '../../conversation/Question';

@Component({
  moduleId: module.id,
  selector: 'cm-toolbar',
  templateUrl: 'toolbar.component.html',
  styleUrls: ['../../../theme.css', 'toolbar.component.css'],
  directives: [MdToolbar, MdIcon, MdButton , MdAnchor],
  providers: [Location, ConversationService],
  viewProviders: [MdIconRegistry],
})
export class ToolbarComponent implements OnInit {

  informingAboutMyName: InformingAboutMyName;

  constructor(private askForNameService: ConversationService<InformingAboutMyName>) {}

  refresh():void {
    location.reload();
  }

  ngOnInit(): any {
    this.askForNameService
        .ask(new Question(WHAT_IS_YOUR_NAME))
        .subscribe(
          answer => {
            this.informingAboutMyName = answer.sentences[0];
          }
        );
    return null;
  }


}
