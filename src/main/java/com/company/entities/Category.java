package com.company.entities;

public class Category {
    private int idcategory;
    private String name;

    public Category(){}
    public Category(String name){
        this.name=name;
    }
    public Category(int idcategory, String name){
        this.idcategory = idcategory;
        this.name=name;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idcategory=" + idcategory +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (idcategory != category.idcategory) return false;
        return name != null ? name.equals(category.name) : category.name == null;
    }

    @Override
    public int hashCode() {
        int result = idcategory;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
