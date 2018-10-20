import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumtopicComponent } from './forumtopic.component';

describe('ForumtopicComponent', () => {
  let component: ForumtopicComponent;
  let fixture: ComponentFixture<ForumtopicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumtopicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumtopicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
