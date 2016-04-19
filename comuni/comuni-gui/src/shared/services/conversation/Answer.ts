import {Sentence} from './Sentence';
import {Question} from './Question';
export class Answer {

  sentences: any[];
  youCan: any[];

  addSentence(sentence: Sentence) {
    this.sentences.push(sentence);
  }

  getPossibleQuestions(): any[] {
    let questions = new Array<Question>();
    for (var question of this.youCan) {
      if (question.hasOwnProperty('ask')) {
        questions.push(new Question(question['ask']['question']));
      }
    }
    return questions;
  }

}
