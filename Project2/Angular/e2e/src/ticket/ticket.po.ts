import { browser, by, element } from 'protractor';

export class TicketPage {
    
    navigateTo(){
        return browser.get('/Ticketopia/store/7');
    }

    getHeaderText(){
        return element(by.css('app-ticket h1')).getText();
    }

    getForumData() {
        return element(by.css('app-forum h1'))
    }

}