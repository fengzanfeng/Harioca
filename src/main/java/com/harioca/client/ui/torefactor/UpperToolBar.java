package com.harioca.client.ui.torefactor;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;

public class UpperToolBar extends HLayout {

    public UpperToolBar() {
        setHeight(40);
        setMembersMargin(16);
        setStyleName("harioca-upperToolBar");
        setAlign(Alignment.CENTER);          // todo to css

        Label connectivityItem = new Label("Connectivity");
        connectivityItem.setStyleName("harioca-upperButton-d");
        connectivityItem.setHeight(40);
        addMember(connectivityItem);

        Label librariesItem = new Label("Libraries");
        librariesItem.setStyleName("harioca-upperButton-d");
        librariesItem.setHeight(40);
        addMember(librariesItem);

        Label consoleItem = new Label("Console");
        consoleItem.setStyleName("harioca-upperButton");
        consoleItem.setHeight(40);
        addMember(consoleItem);

        Label bookmarksItem = new Label("Bookmarks");
        bookmarksItem.setStyleName("harioca-upperButton-d");
        bookmarksItem.setHeight(40);
        addMember(bookmarksItem);

//        Label latestItem = new Label("Latest executed scripts");
//        latestItem.setStyleName("harioca-upperButton-latest");
//        latestItem.setWidth(160);
//        latestItem.setHeight(50);
//        latestItem.setLeft(upperToolBar.getWidth() - 170);
//        addChild(latestItem);
    }
}
