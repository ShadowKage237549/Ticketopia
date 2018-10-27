import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumComponent } from './forum.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('ForumComponent', () => {
    let component: ForumComponent;
    let fixture: ComponentFixture<ForumComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [ForumComponent],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(ForumComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
