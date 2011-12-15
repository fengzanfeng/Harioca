package com.harioca.client.form.widget;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.MouseOutEvent;
import com.smartgwt.client.widgets.events.MouseOutHandler;
import com.smartgwt.client.widgets.events.MouseOverEvent;
import com.smartgwt.client.widgets.events.MouseOverHandler;

public class HeaderButton extends Label {

    private Boolean isPressed = false;

    private final String contents;
    private final String hotKey;

    private String pressedColor = "FFE9E9";
    private String pressedBorder = "FF2E2E";

    public HeaderButton(String contents, String hotKey) {
        super("<font color=#0000FF>" + contents + "</font>&nbsp&nbsp&nbsp<font color=#909090>" + hotKey + "</font>");
        this.contents = contents;
        this.hotKey = hotKey;

        setWidth(150);
        setAlign(Alignment.CENTER);

// todo?        setCanFocus(false);

        addHandlers();
    }

    private void addHandlers() {
        addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                setContents("<font color=#0000FF>" + contents + "</font>&nbsp&nbsp&nbsp<font color=#909090>" + hotKey + "</font>");
                setBorder(isPressed ? "1px solid #" + pressedBorder : "1px solid #A7ABB4");
            }
        });

        addMouseOutHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                setContents(contents + "&nbsp&nbsp&nbsp<font color=#909090>" + hotKey + "</font>");
                setBorder(isPressed ? "1px solid #" + pressedBorder : null);
            }
        });
    }

    public void switchPressed() {
        isPressed = !isPressed;
        setBackgroundColor(isPressed ? pressedColor : null);
        setBorder(isPressed ? "1px solid #" + pressedBorder : null);
    }

}
