import { browser, by, element } from 'protractor';

export class ForumPage {
  //Ensure the page navigates to the correct URL
  navigateTo() {
    return browser.get('/Ticketopia/forum');
  }

  //Get the topics
  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
}
