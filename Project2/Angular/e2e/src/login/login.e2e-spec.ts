import { loginPage } from './login.po';

describe('workspace-project App', () => {
    let page: loginPage;

    beforeEach(() => {
        page = new loginPage();
    });

    //Test the page header of the login page
    it('should display the login page header', () => {
        page.navigateTo();
        expect(page.getHeaderText()).toEqual('Login to Ticketopia');
    });

    //Input the username and password into the respective fields and click login
    it('should input email and password and login', () => {
        page.inputUsername('bob.bobson@mafia.net');
        page.inputPassword('password');
        expect(page.clickLogin()).toContain('/Ticketopia/home');
    });
});