import { browser, by, element } from 'protractor';

export class StorePage {

    navigateTo(){
        return browser.get('/Ticketopia/store');
    }

    getHeaderText(){
        return element(by.css('app-store h1')).getText();
    }

    getNumberOfTickets(){
        //Return all elements which are inside of a 'second div' tag within the app-store tag.
        //The self invoking lambda below is required because .then executes whenever it feels like it
        //But I demand! that I want to execute it immediately after the promise is fulfilled.
        return element.all(by.css('app-store div:nth-child(2)')).count().then(((value) => {
            console.log(value + " : HEY LOOK AT ME I'M A VALUE COME CHECK ME OUT HEY OVER HERE DO IT HEY HEYEHEYEAHEAYEYAEHA I SAID HAAAYAYEAEYAEAEAEAEAEYAEAE");
            return value;
         })());
    }
}