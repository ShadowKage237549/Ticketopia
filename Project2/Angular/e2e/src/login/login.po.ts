import { browser, by, element } from 'protractor';
import { BROWSER_MODULE_PROVIDERS } from '@angular/platform-browser/src/browser';

export class LoginPage { //The login page has both login and register capabilities, can only be accessed when the user is logged out.
    public currentUri:string;
    //Navigate to the login url
    navigateTo() {
        return browser.get('/Ticketopia/login');
    }

    //check the page contains the correct header
    getHeaderText() {
        return element(by.css("app-login h1")).getText();
    }

    inputUsername(email: string) {
        element(by.name('loginEmail')).sendKeys(email);
    }
    
    inputPassword(password: string) {
        element(by.name('loginPassword')).sendKeys(password);
    }
   
    //Click the login button, prefably after inputting the INCORRECT information.
    clickLogin(){
        element(by.name('loginSubmit')).click();
        browser.sleep(500);
        return browser.getCurrentUrl();
    }

    clickLogout(){
        element(by.name('pizza')).click();
    }
   
}
