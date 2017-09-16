package org.gwtproject.tutorial.ui;

import com.vaadin.polymer.paper.PaperCheckboxElement;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class ItemView implements IsElement<HTMLDivElement>{

    @DataElement
    Element title;

    @DataElement
    Element description;

    @DataElement
    PaperCheckboxElement done;

    @PostConstruct
    void onInit(){
        done.addEventListener("iron-change", event -> {
            if (done.getActive()) {
                title.classList.add("done");
            } else {
                title.classList.remove("done");
            }
        });
    }

    public String getTitle() {
        return title.textContent;
    }
    public void setTitle(String s) {
        title.textContent=s;
    }
    public String getDescription() {
        return description.textContent;
    }
    public void setDescription(String s) {
        description.textContent=s;
    }
    public boolean isDone() {
        return done.getActive();
    }
    public void setDone(boolean b) {
        done.setActive(b);
    }

    public static ItemView create(){
        return new Templated_ItemView();
    }
}
