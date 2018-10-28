import { StorePage } from "./store.po";

describe('project-workspace App', () => {
    let page:StorePage;

    beforeEach(() => {page = new StorePage();});

    //Check if the test is on the correct page
    it('should display the store header text', () => {
        page.navigateTo();
        expect(page.getHeaderText()).toEqual('Ticketopia Store');;
    });

    it('should have tickets of an amount greater than zero.', () => {
        expect(page.getNumberOfTickets()).toBeGreaterThan(1); // There are two elements which are not part of the number of tickets in the DIV. returned value is 6 if there are 4 tickets
    });


});