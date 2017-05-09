package org.careerop.pccontrolapp;

/**
 * Created by JuyelRana on 17/05/09.
 */

public class ImageId {
    private String image, id;

    public ImageId() {
    }

    public ImageId(String image, String id) {
        this.image = image;
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
