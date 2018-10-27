import { browser, by, element } from 'protractor';

export class ForumPage {
  //Ensure the page navigates to the correct URL
  navigateTo() {
    return browser.get('/Ticketopia/forum');
  }

  //get the ForumPage header
  getParagraphText() {
    return element(by.css('app-forum h1')).getText();
  }
}

/*
    Using selenium protractor should be intuitive.
    Some tricks:
        //Browser navigation
        browser.get('yoururl');
        browser.navigate().back();
        browser.navigate().forward();

        //Waits
        browser.sleep(10000); 
        browser.waitForAngular();
        browser.getLocationAbsUrl() //get the current address
        browser.ignoreSynchronization = true;

        //Waiting for an element to be visible
        browser.wait(function() {
            return element(by.id('create')).isPresent();
        }, 5000);

        use element.all(by.something) to get the collection
            then access it thorugh a for loop or el.get(number)

        //Keyboard actions:
        element(by.id('user_name').sendKeys("user1");
        sendKeys(protractor.Key.ENTER);
        sendKeys(protractor.Key.TAB);
        element(by.id('user_name')).clear()


  */
