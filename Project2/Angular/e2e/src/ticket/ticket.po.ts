import { browser, by, element } from 'protractor';

export class TicketPage {
    
    navigateTo(){
        return browser.get('/Ticketopia/store/ticket/1');
    }

    //Tests if the header returns after letting the page load for 500 ms
    getHeaderText(){
        return element(by.css('app-ticket h1')).getText().then(((value) => {
            return value;
        })());
    }
    
    getForumData() {
        return element(by.css('app-forumtopic h1'));
    }


}