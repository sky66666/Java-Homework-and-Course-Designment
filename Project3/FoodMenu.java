package Project3;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<String> menu;
    public FoodMenu(){
        menu = new ArrayList<String>();
    }
    public void addFood(String food) throws MultipleFoodException{
        if(menu.contains(food))throw new MultipleFoodException("菜单中已有该菜品!");
        menu.add(food);
    }
    public String getFoodByNo(int no){
        return menu.get(no-1);
    }
    public int getFoodNumbers(){
        return menu.size();
    }
    public void showMenu(){
        for(int i=0;i<getFoodNumbers();i++){
            System.out.println(i+1+"."+menu.get(i));
        }
    }
}
