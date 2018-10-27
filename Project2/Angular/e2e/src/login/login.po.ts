import { browser, by, element } from 'protractor';

export class loginPage {
    public currentUri:string;
    //Navigate to the correct url
    navigateTo() {
        return browser.get('/Ticketopia/login');
    }

    //check the page contains the correct header
    getHeaderText() {
        return element(by.css("app-login h1")).getText();
    }
    //input the username into the element named loginEmail.
    inputUsername(email: string) {
        element(by.name('loginEmail')).sendKeys(email);
    }
    
    //input the password into the element named loginPassword.
    inputPassword(password: string) {
        element(by.name('loginPassword')).sendKeys(password);
    }

    //Click the login button, prefably after inputting the INCORRECT information.
    clickLogin(){
        element(by.name('loginSubmit')).click();
        return browser.getCurrentUrl();
    }

}
