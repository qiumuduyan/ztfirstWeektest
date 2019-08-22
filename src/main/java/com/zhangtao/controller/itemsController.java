package com.zhangtao.controller;

import com.zhangtao.dao.ItemsRepository;
import com.zhangtao.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class itemsController {
    @Autowired
    private ItemsRepository repository;
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        Items items=repository.getOne(id);
        model.addAttribute("items",items);
        return "edit";

    }

    @RequestMapping("/show")
    public String show(Model model) {
        List<Items> list = repository.findAll();
        model.addAttribute("list", list);
        return "show";
    }

    @RequestMapping("/save")
    public String save(Items items) {
        System.out.println(items);
        Items it = repository.save(items);
        if (it != null) {
            return "redirect:show";
        }
        return "error";
    }

    @RequestMapping("/delete")
    public String save(Integer id) {
        repository.deleteById(id);
        return "redirect:show";
    }
    @RequestMapping("/selectByName")
    public String selectByName(String name,Model model) {
        System.out.println(name);
      List<Items> list=  repository.findByName(name);
        System.out.println(list);
      model.addAttribute("list",list);
        return "show";
    }
    @RequestMapping("/selectByNameLike")
    public String selectByNameLike(String name,Model model) {

        List<Items> list=  repository.findByNameLike("%"+name+"%");
        model.addAttribute("list",list);
        return "show";
    }
}
