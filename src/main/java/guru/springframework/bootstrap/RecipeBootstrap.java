package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeBootstrap {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private List<Recipe> getRecipies(){
        List<Recipe> recipies = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if (!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }


        //Categories
        Optional<Category> AmericanCategoryOptional = categoryRepository.findByDescription("American");

        if (!AmericanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<Category> ItalianCategoryOptional = categoryRepository.findByDescription("Italian");

        if (!ItalianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!");
        }
        Optional<Category> MexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (!MexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!");
        }
        Optional<Category> FastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");

        if (!FastFoodCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!");
        }

        return recipies;
    }
}
