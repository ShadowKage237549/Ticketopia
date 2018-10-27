import { ForumPage } from './forum.po';

describe('workspace-project App', () => {
    let page: ForumPage;

    beforeEach(() => {
        page = new ForumPage();
    });

    it('should display the forum message', () => {
        page.navigateTo();
        expect(page.getParagraphText()).toEqual('Ticketopia!');
    });
});
