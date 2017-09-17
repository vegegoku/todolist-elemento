package org.gwtproject.tutorial.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.vaadin.polymer.paper.*;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Templated
public abstract class TodoListView implements IsElement<HTMLElement>{

    private List<ItemView> items = new ArrayList<>();


    @DataElement
    PaperDrawerPanelElement drawerPanel;

    @DataElement
    HTMLElement content;

    @DataElement
    PaperFabElement addButton;

    @DataElement
    PaperDialogElement addItemDialog;

    @DataElement
    PaperInputElement titleInput;

    @DataElement
    PaperTextareaElement descriptionInput;

    @DataElement
    PaperButtonElement confirmAddButton;

    @DataElement
    PaperIconItemElement menuClearAll;

    @DataElement
    PaperIconItemElement menuClearDone;

    @PostConstruct
    void onInit(){
        addButton.addEventListener("tap", event -> addItemDialog.open());

        confirmAddButton.addEventListener("tap", event -> {
            if (!titleInput.getValue().isEmpty()) {
                addItem(titleInput.getValue(), descriptionInput.getValue());
                // clear text fields
                titleInput.setValue("");
                descriptionInput.setValue("");
            }
        });

        menuClearAll.addEventListener("tap", event -> {
            closeMenu();
            // remove all child elements
            while (content.hasChildNodes()) {
                content.removeChild(content.firstChild);
            }
        });

        menuClearDone.addEventListener("tap", event -> {
            closeMenu();
            List<ItemView> removedItems=new ArrayList<>();
            for (ItemView item : items) {
                if (item.isDone()) {
                    content.removeChild(item.asElement());
                    removedItems.remove(item);
                }
            }
            items.removeAll(removedItems);
        });
    }

    private void addItem(String title, String description) {
        ItemView item = ItemView.create();
        item.setTitle(title);
        item.setDescription(description);
        content.appendChild(item.asElement());
        items.add(item);
    }

    private void closeMenu() {
        if (drawerPanel.getNarrow()) {
            drawerPanel.closeDrawer();
        }
    }

    public static TodoListView create(){
        return new Templated_TodoListView();
    }
}
