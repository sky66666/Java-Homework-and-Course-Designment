package Project3;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        FoodMenu foodMenu = new FoodMenu();
        DislikedFoodMenu dislikedFoodMenu = new DislikedFoodMenu();
        Application app = new Application(foodMenu,dislikedFoodMenu);
        app.addFood("油爆基围虾");
        app.addFood("葱油大虾");
        app.addFood("盐焗大明虾");
        app.addFood("清蒸河虾");
        app.addFood("蒜蓉黑虎虾");
        app.addDislikedFood("葱油大虾");
        app.addDislikedFood("蒜蓉河虾");
        Scanner in = new Scanner(System.in);
        app.showMenu();
        System.out.print("请为大家点餐,输入0表示点餐结束：");
        while (in.hasNext()){
            int op = in.nextInt();
            if(op==0)break;
            else {
                app.pickFood(op);
                app.showPicked();
            }
            System.out.print("请为大家点餐,输入0表示点餐结束：");
        }
        app.showPicked();
    }
}
