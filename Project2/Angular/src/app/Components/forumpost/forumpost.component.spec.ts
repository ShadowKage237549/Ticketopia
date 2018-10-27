import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumpostComponent } from './forumpost.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('ForumpostComponent', () => {
    let component: ForumpostComponent;
    let fixture: ComponentFixture<ForumpostComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ForumpostComponent],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(ForumpostComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
