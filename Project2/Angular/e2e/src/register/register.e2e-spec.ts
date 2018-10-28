import { RegisterPage } from './register.po';


describe('workspace-project App', () => {
    let page: RegisterPage;

    beforeEach(() => {
        page = new RegisterPage();
    });

    //Test the page header of the login page
    it('should display the login page header', () => {
        page.navigateTo();
        expect(page.getHeaderText()).toEqual('Register to Ticketopia!');
    });

    //Input the username and password into the respective fields and click login
    it('should complete the form and click register', () => {
        page.inputRegisterEmail('somenewguy@testing.test');
        page.inputRegisterPassword('testpassword');
        page.inputDName("someguysusername");
        page.inputFName("some");
        page.inputLName("guy");
        page.inputAddress("12345 someguyshouse");
        page.inputCity("someland");
        page.inputState("somebiggerland");
        page.inputZipcode("12321");
        expect(page.clickRegister()).toContain('/Ticketopia/login');
    });
});