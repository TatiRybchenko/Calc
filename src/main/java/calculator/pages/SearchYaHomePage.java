package calculator.pages;

import calculator.block.SearchBlock;

public class SearchYaHomePage extends AbstractPage {
    public SearchBlock.SearchArrowYa searchArrowYa;

    public SearchYaHomePage() {    }

    public void search(String request) {
        searchArrowYa.search(request);
    }

}