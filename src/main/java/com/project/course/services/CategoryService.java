package com.project.course.services;

import com.project.course.entities.Category;
import com.project.course.entities.User;
import com.project.course.repositories.CategoryRepository;
import com.project.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();

    }

    public Category findById(Long id){
        Optional<Category> obj= categoryRepository.findById(id);
        return obj.get();
    }

}
