package main.java.io.testproject.pages;

public abstract class Page {
    public int timeout = 20;

    public abstract void verifyDisplayed();
    //public abstract void open() throws Exception;
}
