package com.isoft.iwechat.corporation.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuButton {
    public MenuButton(){
        this.button = new ArrayList<>();
    }
    List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void addButton(Button btn){
        this.button.add(btn);
    }
}
