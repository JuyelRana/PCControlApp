package org.careerop.pccontrolapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuyelRana on 17/05/09.
 */

public class ParseJSON {
    private String json;
    public static List<ImageId> imageIdList;
    private JSONArray jsonArray = null;

    public ParseJSON(String json) {
        this.json = json;
    }

    protected void jsonParser() {
        imageIdList = new ArrayList<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray(Config.JSON_ARRAY);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                ImageId imageId = new ImageId();
                imageId.setId(object.getString(Config.ID));
                imageId.setImage(object.getString(Config.IMAGE));
                imageIdList.add(imageId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}