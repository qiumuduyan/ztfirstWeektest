package com.zhangtao.dao;

import com.zhangtao.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items,Integer> {
    public List<Items> findByName(String name);
    public List<Items> findByNameLike(String name);
}
