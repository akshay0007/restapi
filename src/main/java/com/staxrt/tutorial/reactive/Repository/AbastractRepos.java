package com.staxrt.tutorial.reactive.Repository;

import com.staxrt.tutorial.reactive.entities.Items;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ubuntu on 18/05/20.
 */
public class AbastractRepos {
    protected Map<String, Items> itemsMap = new HashMap();

    boolean isExist(Object object) {
        return itemsMap.get(object) != null;
    }

}
