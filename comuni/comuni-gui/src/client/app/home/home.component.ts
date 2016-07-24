import {Component, OnInit} from '@angular/core';
import {REACTIVE_FORM_DIRECTIVES} from '@angular/forms';
import {MdButton} from '@angular2-material/button';
import {MD_CARD_DIRECTIVES} from '@angular2-material/card';
import {MD_INPUT_DIRECTIVES} from '@angular2-material/input';
import {MD_LIST_DIRECTIVES} from '@angular2-material/list';

import {ConversationService} from '../shared/conversation/conversation.service';
import {Question} from '../shared/conversation/Question';
import {HELLO} from './conversation/HomeQuestions';
import {Answer} from '../shared/conversation/Answer';
import {ProposingWelcome} from './conversation/ProposingWelcome';
import {InformingAboutMyName} from './conversation/InformingAboutMyName';
import {ContentComponent} from '../shared/components/content/content.component';

@Component({
  moduleId: module.id,
  selector: 'cm-home',
  templateUrl: 'home.component.html',
  styleUrls: ['home.component.css'],
  providers: [ConversationService],
  directives: [REACTIVE_FORM_DIRECTIVES, MdButton, MD_INPUT_DIRECTIVES, MD_CARD_DIRECTIVES, MD_LIST_DIRECTIVES,
  ContentComponent]
})
export class HomeComponent implements OnInit {

  proposingWelcome: ProposingWelcome;
  informingAboutMyName: InformingAboutMyName;

  constructor(private askHelloService: ConversationService<ProposingWelcome>,
              private askForNameService: ConversationService<InformingAboutMyName>,
              private askForNameAgainService: ConversationService<InformingAboutMyName>) {
  }

  ngOnInit(): any {
    this.askHelloService
        .ask(new Question(HELLO))
        .subscribe(
          answer => {
            this.proposingWelcome = answer.sentences[0];
            this.askForName(answer);
          }
        );

    return null;
  }

  private askForName(answer: Answer<ProposingWelcome>): void {
    let question: Question = answer.youCanAsk.questions[0];
    if (question) {
      this.askForNameService
          .ask(question)
          .subscribe(
            answer => {
              this.informingAboutMyName = answer.sentences[0];
              this.askForNameAgain(answer);
            }
          );
    }
  }

  private askForNameAgain(answer: Answer<InformingAboutMyName>): void {
    let question: Question = answer.youCanAsk.questions[0];
    if (question) {
      this.askForNameAgainService
          .ask(question)
          .subscribe(
            answer => {
              this.informingAboutMyName = answer.sentences[0];
            }
          );
    }
  }

}
