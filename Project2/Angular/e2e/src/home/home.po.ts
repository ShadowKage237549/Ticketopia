import { browser, by, element } from 'protractor';

export class HomePage {
    
    //Navigate to the home page
    navigateTo(){
        return browser.get("/Ticketopia/home");
    }

    getHeaderText(){
        return element(by.css("app-home h1")).getText();
    }

    //Gets the number of partners based on the card headers in the html.
    getNumberOfPartners(){
        browser.sleep(500);
        let numberOfPartners:number = -1;
        numberOfPartners = element.all(by.css('.card-header')).all.length;
        return numberOfPartners;
    }


}