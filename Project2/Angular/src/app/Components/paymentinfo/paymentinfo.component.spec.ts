import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentinfoComponent } from './paymentinfo.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('PaymentinfoComponent', () => {
    let component: PaymentinfoComponent;
    let fixture: ComponentFixture<PaymentinfoComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [PaymentinfoComponent],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(PaymentinfoComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
