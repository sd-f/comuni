import {Component} from 'angular2/core';
import {CORE_DIRECTIVES, FORM_DIRECTIVES} from 'angular2/common';
import {HTTP_PROVIDERS, Http} from 'angular2/http';
import {Conversation} from '../../shared/services/conversation/Conversation';

@Component({
  selector: 'sd-home',
  moduleId: module.id,
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  viewProviders: [HTTP_PROVIDERS],
  directives: [FORM_DIRECTIVES, CORE_DIRECTIVES]
})
export class HomeComponent {
  constructor(public http: Http) {

    var conversation = new Conversation(http);
    var questions = conversation.say('hello').getPossibleQuestions();

    for (var question of questions) {
      console.log(question);
      conversation.ask(question);
    }
  }
}
