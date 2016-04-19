import {Http, Headers} from 'angular2/http';
import {Question} from './Question';
import {Answer} from './Answer';

export class Conversation {

  answer: Answer;

  constructor(public http: Http) {
  }

  say(text: string): Answer {
    let answer: Answer;
    const headers = new Headers({'Accept': 'application/json'});
    this.http.get('comuni-conversations/start-conversations/home/' + text, { headers: headers })
      .subscribe(
        data => {
          answer = data.json();
          //console.log('Test: '+this.answer.sentences.length);
        },
        err => console.error(err),
        () => {
          console.log('answered');
        }
      );
    return answer;
  }

  ask(question:Question): Answer {
    let answer: Answer;
    const headers = new Headers({'Accept': 'application/json'});
    this.http.get('comuni-conversations/start-conversations/home/' + question.getQuestionText(), { headers: headers })
      .subscribe(
        data => {
          answer = data.json();
          //console.log('Test: '+this.answer.sentences.length);
        },
        err => console.error(err),
        () => {
          console.log('answered');
        }
      );
    return answer;
  }
}
