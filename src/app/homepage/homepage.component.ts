import { Component, OnInit } from '@angular/core';
import { FormdataService } from '../services/formdata.service';
import { Comment } from '../model/comment.model';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(private formDataService: FormdataService) { }
  
  public comment: Comment = new Comment(3,'a@gmail.com','','');

  getFormData(): void {
    this.formDataService.fetchFormData(this.comment.id)
    .subscribe(
      comment => this.comment = comment,
      error => console.log(`Error: ${ error}`)
    );
  }

  ngOnInit() {
    this.getFormData();
  }

}
