import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumtopicComponent } from './forumtopic.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('ForumtopicComponent', () => {
    let component: ForumtopicComponent;
    let fixture: ComponentFixture<ForumtopicComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ForumtopicComponent],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
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
