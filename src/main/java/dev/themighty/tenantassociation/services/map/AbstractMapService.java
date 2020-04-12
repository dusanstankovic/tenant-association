package dev.themighty.tenantassociation.services.map;

import dev.themighty.tenantassociation.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    // used Long instead of generic to avoid type issue with getNextId() method
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        // to simulate regular data layer, we are automatically creating Id when object is saved instead of providing it
        if (object != null) {
            // if object doesn't have an ID (extended T to BaseEntity to gain access to getId() method)
            if (object.getId() == null) {
                object.setId(getNextId()); // set next Id if object doesn't have one
            }
            map.put(object.getId(), object);
        } else {
            // defensive code
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;

        // fix for NoSuchElementException when working on empty map at startup
        try {
            nextId = Collections.max(map.keySet()) + 1;

        } catch (NoSuchElementException e) {
            nextId = 1L;

        }

        return nextId;
    }
}
