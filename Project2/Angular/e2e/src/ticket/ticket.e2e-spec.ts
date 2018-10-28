import { TicketPage } from "./ticket.po";

describe('project-workspace App', () => {
    let page:TicketPage;

    beforeEach(() => {page = new TicketPage();});

    //Check if the test is on the correct page
    it('should display the ticket header text', () => {
        page.navigateTo();
        expect(page.getHeaderText()).toEqual('Venom at Zmax');
    });

    it('should display the forum associated with the ticket',() =>{
        expect(page.getForumData()).toBeDefined();
    });
});
