import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoreComponent } from './store.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('StoreComponent', () => {
    let component: StoreComponent;
    let fixture: ComponentFixture<StoreComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [StoreComponent],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(StoreComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
