package com.isoft.iwechat.corporation.menu.impl;

import com.isoft.iwechat.core.AbstractResponse;
import com.isoft.iwechat.corporation.menu.Button;

import java.util.ArrayList;
import java.util.List;

public class MenuResponse extends AbstractResponse {
    ArrayList<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(ArrayList<Button> button) {
        this.button = button;
    }
}
