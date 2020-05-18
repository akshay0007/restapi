package com.staxrt.tutorial.reactive.Repository;

import com.staxrt.tutorial.reactive.entities.Items;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubuntu on 18/05/20.
 */
@Component
public class ItemReposImpl extends AbastractRepos implements ItemRepos<Integer, Items> {


    @Override
    public Items add(Items t) {
        if(!isExist(t.getId())){
            itemsMap.put(t.getId(),t);
        }
        return itemsMap.get(t.getId());
    }

    @Override
    public Items delete(Integer integer) {
        return itemsMap.remove(integer);
    }

    @Override
    public List<Items> getALL() {
        List<Items> lists=new ArrayList<>();
        itemsMap.entrySet().forEach(e->lists.add(e.getValue()));
        return lists;
    }

    @Override
    public Items find(Integer id) {
        return itemsMap.get(id);
    }
}
