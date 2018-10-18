import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forumpost',
  templateUrl: './forumpost.component.html',
  styleUrls: ['./forumpost.component.css']
})
export class ForumpostComponent implements OnInit {

  constructor() { }
  post:string = "forumPostname";
  postId:number;

  ngOnInit() {
  }

}
