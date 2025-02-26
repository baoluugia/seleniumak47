package pages;

import org.openqa.selenium.By;

import static supports.Browser.*;

public class FormAuthenticationTestPage {
    private By usernameTxt = By.id("username");
    private By passwordTxt = By.id("password");
    private By loginBtn = By.cssSelector("button[type=submit]");

    public void login(String username, String password) {
        fill(usernameTxt, username);
        fill(passwordTxt, password);
        click(loginBtn);
    }

    public void open (String url){
        visit(url);
    }

    public String getMessage(String expectedMessageType) {
        return getText(By.className(expectedMessageType));
    }

    public boolean isMessageContents(String messageType, String content){
       return getMessage(messageType).contains(content);
    }

}
