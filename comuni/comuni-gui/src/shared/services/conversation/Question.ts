export class Question {

  constructor(private questionText: string) { }

  getQuestionText(): string {
    return this.questionText;
  }

  setQuestionText(value: string): void {
    this.questionText = value;
  }

}
