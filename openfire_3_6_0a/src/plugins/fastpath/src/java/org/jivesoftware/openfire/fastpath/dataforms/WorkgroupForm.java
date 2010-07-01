/**
 * $RCSfile$
 * $Revision: 22802 $
 * $Date: 2005-10-20 11:06:36 -0700 (Thu, 20 Oct 2005) $
 *
 * Copyright (C) 1999-2008 Jive Software. All rights reserved.
 *
 * This software is published under the terms of the GNU Public License (GPL),
 * a copy of which is included in this distribution, or a commercial license
 * agreement with Jive.
 */

package org.jivesoftware.openfire.fastpath.dataforms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WorkgroupForm {
    private List<FormElement> elements;
    private List<FormElement> hiddenVars;
    private String title;
    private String description;

    public WorkgroupForm() {
        elements = new ArrayList<FormElement>();
        hiddenVars = new ArrayList<FormElement>();
    }

    public void addFormElement(FormElement element, int index) {
        elements.add(index, element);
    }

    public void addFormElement(FormElement element) {
        elements.add(element);
    }

    public void removeFormElement(int index) {
        elements.remove(index);
    }

    public Collection<FormElement> getFormElements() {
        return elements;
    }

    public FormElement getFormElementAt(int index) {
        return elements.get(index);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FormElement> getHiddenVars() {
        return hiddenVars;
    }

    public void setHiddenVars(List<FormElement> hiddenVars) {
        this.hiddenVars = hiddenVars;
    }

    public void addHiddenVar(FormElement formElement) {
        hiddenVars.add(formElement);
    }

    public void removeHiddenVarAt(int index) {
        hiddenVars.remove(index);
    }

    public boolean containsHiddenTag(String elementName) {
        for (FormElement elem : getHiddenVars()) {
            if (elem.getVariable().equals(elementName)) {
                return true;
            }
        }
        return false;
    }

    public void removeHiddenVar(String elementName) {
        for (FormElement elem : getHiddenVars()) {
            if (elem.getVariable().equals(elementName)) {
                hiddenVars.remove(elem);
                break;
            }
        }
    }

    public enum FormEnum {
        // Keys used to create forms
        dropdown_box("dropdown_box"),
        checkbox("checkbox"),
        radio_button("radio_button"),
        textfield("textfield"),
        textarea("textarea"),
        hidden("hidden"),
        password("password");

        private String key;


        FormEnum(String k) {
            key = k;
        }

        public String toString() {
            return (key);
        }
    }
}