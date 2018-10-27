import { async, ComponentFixture, TestBed, tick } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { TicketComponent } from './ticket.component';

describe('TicketComponent', () => {
    let component: TicketComponent;
    let fixture: ComponentFixture<TicketComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [TicketComponent],
            schemas: [CUSTOM_ELEMENTS_SCHEMA],
        })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(TicketComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        tick();
        expect(component).toBeTruthy();
    });
});
