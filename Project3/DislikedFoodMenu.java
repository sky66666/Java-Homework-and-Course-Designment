package Project3;

import java.util.ArrayList;
import java.util.List;

public class DislikedFoodMenu {
    private List<String > foods;
    public DislikedFoodMenu(){
        foods = new ArrayList<String >();
    }
    public void addDislikedFood(String food) throws MultipleFoodException{
        if(foods.contains(food))throw new MultipleFoodException("该菜品已经在名单中了!");
        foods.add(food);
    }
    public void checkFood(String food) throws BadFoodException{
        if(foods.contains(food))throw new BadFoodException("有人不喜欢该菜品!");
    }
}
