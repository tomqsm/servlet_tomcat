package com.letsweb.tutorial.servlet_tomcat.dataaccess.model;

import java.sql.Timestamp;

/**
 *
 * @author toks
 */
public class PropertyLine {

    private int id;
    private String name;
    private String value = "";
    private Timestamp inserted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getInserted() {
        return inserted;
    }

    public void setInserted(Timestamp inserted) {
        this.inserted = inserted;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PropertyLine other = (PropertyLine) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PropertyLine{" + "id=" + id + ", name=" + name + ", value=" + value + ", inserted=" + inserted + '}';
    }
}
