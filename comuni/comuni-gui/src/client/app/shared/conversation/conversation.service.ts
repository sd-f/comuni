import {Http, Headers, RequestOptionsArgs, RequestMethod, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';

import {Injectable} from '@angular/core';
import {Answer} from './Answer';
import {Question} from './Question';
import {Config} from '../config/env.config';

@Injectable()
export class ConversationService<T> {

  private _answer: T;

  private _request: Observable<Answer<T>>;

  constructor(private http: Http) {}

  public ask(question: Question): Observable<Answer<T>> {
    let uri:string = Config.API + question.question;

    let headers:Headers = new Headers();
    headers.set('Accept','application/json');

    let opt: RequestOptionsArgs = {
      method: RequestMethod.Get,
      headers: headers,
      url: uri
    };

    this._request = this.http.request(uri, opt)
              //.retry(OPTIONS.NR_OF_RETRIES)
              .distinctUntilChanged()
              //.delay(OPTIONS.DELAY_TIME)
              //.debounceTime(OPTIONS.DEBOUNCE_TIME)
              .map(this.extractData)
              .catch(this.handleError);


    return this._request;
  }

  private extractData(response: Response): Observable<Answer<T>> {
    let body = response.json();
    return body || { };
  }

  private handleError (error: any) {
    // In a real world app, we might use a remote logging infrastructure
    // We'd also dig deeper into the error to get a better message
    let errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg); // log to console instead
    return Observable.throw(errMsg);
  }
}
