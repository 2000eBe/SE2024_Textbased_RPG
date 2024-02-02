public enum CharacterClasses {
    MAGIER("Magier"),
    WAFFENMEISTER("Waffenmeister");

    private String className;

    CharacterClasses(String className) {
        this.className = className;
    }

    //Getter and Setter Methods
    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
