package com.harioca.client.ui.consolepage;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.user.client.ui.TextArea;
import com.mastergaurav.codemirror.client.CodeMirror;

public class Console {

    public final CodeMirror codeMirror;

    public Console(TextArea consoleTextArea) {
        codeMirror = CodeMirror.forJava(consoleTextArea.getElement().<TextAreaElement>cast());
        codeMirror.setWidth(98, Style.Unit.PCT);
        codeMirror.setHeight(98, Style.Unit.PCT);

        CodeRunner.get().setConsole(this);
    }

    public String getCode() {
        return codeMirror.getContent();
    }
}
