import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { Comment } from '../model/comment.model';
import { map } from 'rxjs/operators';

// import 'rxjs/Rx';
import { HomepageComponent } from '../homepage/homepage.component';

@Injectable()
export class FormdataService {
  constructor(private http: Http) { }

  public fetchFormData(id: number): Observable<Comment> {
    return this.http.get(`https://pokeapi.co/api/v2/pokemon/${id}`).pipe(map((response: Response) => {
      return <Comment> response.json();
    }));
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }
}
