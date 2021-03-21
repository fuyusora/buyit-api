package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.Category;
import com.gyh.buyit.entity.ListInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {
//    int isExistCategory()
    Category findCategoryByCategoryId(int categoryId);
    int createCategory(Category category);
    List<Category> findAllCategory();
    List<Category> findAllCategoryByPage(ListInfo listInfo);
    int setCategoryInfo(Category category);
    int categoryCount();
    int deleteCategoryByCategoryId(int categoryId);

}
