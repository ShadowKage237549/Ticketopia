import { HomePage } from './home.po';

describe('project-workspace App', () => {
    let page:HomePage;

    beforeEach(() => { page = new HomePage();});

    it('should display the home page header',() => {
        page.navigateTo();
        expect(page.getHeaderText()).toEqual('Ticketopia!');
    });
    it('should have more than 0 partners', () => {
        expect(page.getNumberOfPartners()).toBeGreaterThan(-1); //Number of partners is zero index based.
    });
});