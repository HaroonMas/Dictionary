package com.haroonmasjidi.dictionary.model;

public class DictionaryClass {
    private String object;
    private String pos;
    private String definition;
    private String french;

    public DictionaryClass() {
    }

    public DictionaryClass(String object, String pos, String definition, String french) {
        this.object = object;
        this.pos = pos;
        this.definition = definition;
        this.french = french;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }
}
