import { browser, by, element } from 'protractor';

export class RegisterPage { //The login page has both login and register capabilities, can only be accessed when the user is logged out.
    public currentUri: string;
    //Navigate to the login url
    navigateTo() {
        return browser.get('/Ticketopia/register');
    }

    //check the page contains the correct header
    getHeaderText() {
        return element(by.css("app-register h1")).getText();
    }

    /* --------------- REGISTER INPUT --------------- */
    inputRegisterEmail(email: string) {
        element(by.name('registerEmail')).sendKeys(email);
    }
    inputRegisterPassword(password: string) {
        element(by.name('registerPassword')).sendKeys(password);
    }
    inputDName(displayName: string) {
        element(by.name('registerDName')).sendKeys(displayName);
    }
    inputFName(firstName: string) {
        element(by.name('registerFName')).sendKeys(firstName);
    }
    inputLName(lastName: string) {
        element(by.name('registerLName')).sendKeys(lastName);
    }
    inputAddress(address: string) {
        element(by.name('registerAddress')).sendKeys(address);
    }
    inputCity(city: string) {
        element(by.name('registerCity')).sendKeys(city);
    }
    inputState(state: string) {
        element(by.name('registerState')).sendKeys(state);
    }
    inputZipcode(zipcode: string) {
        element(by.name('registerZipcode')).sendKeys(zipcode);
    }

    //Click register preferably after inputting ALL of the information.
    clickRegister() {
        element(by.name('registerSubmit')).click();
        browser.sleep(500);
        return browser.getCurrentUrl();
    }
}
