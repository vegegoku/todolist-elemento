package org.gwtproject.tutorial;

import com.google.gwt.core.client.EntryPoint;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.app.AppDrawerElement;
import com.vaadin.polymer.app.AppToolbarElement;
import com.vaadin.polymer.iron.IronIconElement;
import com.vaadin.polymer.iron.IronIconsElement;
import com.vaadin.polymer.paper.*;
import elemental2.dom.DomGlobal;
import org.gwtproject.tutorial.ui.TodoListView;

import java.util.Arrays;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

	public void onModuleLoad() {
		Polymer.startLoading();

		Polymer.importHref("paper-styles/demo-pages.html");
		Polymer.importHref(Arrays.asList(IronIconsElement.SRC,
				PaperIconItemElement.SRC,
				PaperIconButtonElement.SRC,
				PaperDrawerPanelElement.SRC,
				PaperHeaderPanelElement.SRC,
				PaperRippleElement.SRC,
				PaperToolbarElement.SRC,
				PaperFabElement.SRC,
				IronIconElement.SRC,
				AppDrawerElement.SRC,
				AppToolbarElement.SRC,
				PaperDialogElement.SRC,
				PaperTextareaElement.SRC,
				PaperInputElement.SRC,
				PaperButtonElement.SRC,
				PaperCheckboxElement.SRC,
				PaperRippleElement.SRC), arg -> {
                    startApplication();
                    return null;
                });
	}

	private void startApplication() {
		DomGlobal.document.body.appendChild(TodoListView.create().asElement());
	}
}
