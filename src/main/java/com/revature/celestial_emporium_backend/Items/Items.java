package com.revature.celestial_emporium_backend.Items;

public class Items {
    private int itemId;
    private String name;
    private String description;
    private String image;

    public Items() {
    }

    public Items(int itemId, String name, String description, String image) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
