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
        //Return all elements which are inside of a card header tag within the page.
        //The self invoking lambda below is required because .then executes whenever it feels like it
        //But I demand! that I want to execute it immediately after the promise is fulfilled.
        return element.all(by.css('.card-header')).count().then(((value) => {
            return value;
        })());
    }


}