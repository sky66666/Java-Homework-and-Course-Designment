package Project3;

public class Application {
    private FoodMenu foodMenu;
    private FoodMenu foodPicked;
    private DislikedFoodMenu dislikedFoodMenu;
    public Application(FoodMenu foodMenu,DislikedFoodMenu dislikedFoodMenu){
        this.dislikedFoodMenu=dislikedFoodMenu;
        this.foodMenu=foodMenu;
        this.foodPicked=new FoodMenu();
    }
    public void addFood(String food){
        try {
            foodMenu.addFood(food);
        }catch (MultipleFoodException msg){
            System.out.println(msg.getMessage());
        }
    }public void addDislikedFood(String food){
        try {
            dislikedFoodMenu.addDislikedFood(food);
        }catch (MultipleFoodException msg){
            System.out.println(msg.getMessage());
        }
    }
    public void showMenu(){
        System.out.println("******菜单******");
        foodMenu.showMenu();
    }
    public void showPicked(){
        System.out.println("******已选******");
        foodPicked.showMenu();
    }
    public void pickFood(int no){
        try {
            String food = foodMenu.getFoodByNo(no);
            dislikedFoodMenu.checkFood(food);
            foodPicked.addFood(food);
        }catch(BadFoodException msg){
            System.out.println(msg.getMessage());
        }catch (MultipleFoodException msg){
            System.out.println(msg.getMessage());
        }
    }
}
