package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipies());
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

        UnitOfMeasure eachUop = eachUomOptional.get();
        System.out.println("eachUop: " + eachUop.getDescription());
        UnitOfMeasure tableSpoonUop = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUop = teaSpoonUomOptional.get();
        UnitOfMeasure PintUop = pintUomOptional.get();
        UnitOfMeasure CupUop = cupUomOptional.get();
        UnitOfMeasure dashUop = dashUomOptional.get();

        //Categories
        Optional<Category> AmericanCategoryOptional = categoryRepository.findByDescription("American");

        if (!AmericanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found!");
        }

        Optional<Category> MexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (!MexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!");
        }

        Category americanCategory = AmericanCategoryOptional.get();
        Category mexicanCategory = MexicanCategoryOptional.get();

        //Guacamole
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setServings(4);
        guacRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "\n" +
                "The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\n" +
                "\n" +
                "Check for ripeness by gently pressing the outside of the avocado. If there is no give, the avocado is not ripe yet and will not taste good. If there is a little give, the avocado is ripe. If there is a lot of give, the avocado may be past ripe and not good. In this case, taste test first before using.");
        //guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);
       // guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUop));

        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUop));
        guacRecipe.addIngredient(new Ingredient("salt", new BigDecimal(".25"), teaSpoonUop));
        guacRecipe.addIngredient(new Ingredient(" fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUop));
        guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUop));
        guacRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUop));
        guacRecipe.addIngredient(new Ingredient("cilantro", new BigDecimal(2), tableSpoonUop));
        guacRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUop));
        guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUop));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);
        recipies.add(guacRecipe);
        return recipies;
    }
}
