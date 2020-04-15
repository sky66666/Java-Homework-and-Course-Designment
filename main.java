package Project1;

import java.lang.*;
import java.util.Scanner;

class data {

    //Parameters
    int n,m;
    String[] STU;
    String[] CRS;
    int[][] pnt;

    //Functions
    void init(){
        n=3;
        m=4;
        STU = new String[]{"s1", "s2", "s3"};
        CRS = new String[]{"cpp", "go", "py","alg"};
        pnt = new int[][]{
                {90,95,93,96},
                {89,100,99,84},
                {50,60,85,55},
        };
    }

    void show(){
        System.out.print("\t");
        for(int i=0;i<m;++i)System.out.print(CRS[i]+"\t");
        System.out.println("均分"+"\t");
        double tmp=0;
        for(int i=0;i<n;++i){
            System.out.print(STU[i]+"\t");
            tmp=0;
            for(int j=0;j<m;++j){
                System.out.print(pnt[i][j]+"\t");
                tmp+=pnt[i][j];
            }
            System.out.println(String.format("%.0f\t", tmp / m));
        }
        System.out.print("\t");
        double tot=0;
        for(int j=0;j<m;++j){
            tmp=0;
            for(int i=0;i<n;++i){
                tmp+=pnt[i][j];
                tot+=pnt[i][j];
            }
            System.out.print(String.format("%.0f\t",tmp/n));
        }
        System.out.println(String.format("%.0f\t",tot/m/n));
    }

    int find_stu(String s){
        for(int i=0;i<n;++i){
            if(s.equalsIgnoreCase(STU[i]))return i;
        }
        return -1;
    }

    int find_crs(String s){
        for(int i=0;i<m;++i){
            if(s.equalsIgnoreCase(CRS[i]))return i;
        }
        return -1;
    }

    void avg(String para){
        int indn=find_stu(para);
        int indm=find_crs(para);
        if(para.equalsIgnoreCase("all"))show();
        else if(indn!=-1){
            double avg=0;
            for(int i=0;i<m;++i)avg+=pnt[indn][i];
            System.out.println("学生"+para+"的均分为"+avg/m+"!");
        }else if(indm!=-1){
            double avg=0;
            for(int i=0;i<n;++i)avg+=pnt[i][indm];
            System.out.println("课程"+para+"的均分为"+avg/n+"!");
        }else{
            System.out.println("没有对应的学生或课程!");
        }
    }

    void max(String para){
        int indn=find_stu(para);
        int indm=find_crs(para);
        if(para.equalsIgnoreCase("all"))show();
        else if(indn!=-1){
            int maxx=-1,id=-1;
            for(int i=0;i<m;++i){
                if(pnt[indn][i]>maxx){
                    maxx=pnt[indn][i];
                    id=i;
                }
            }
            System.out.println("学生"+para+"的"+CRS[id]+"分数最高:"+maxx);
        }else if(indm!=-1){
            int maxx=-1,id=-1;
            for(int i=0;i<n;++i){
                if(pnt[i][indm]>maxx){
                    maxx=pnt[i][indm];
                    id=i;
                }
            }
            System.out.println("学生"+STU[id]+"的"+para+"分数最高:"+maxx);
        }else{
            System.out.println("没有对应的学生或课程!");
        }
    }

    void get(String stu,String crs){
        int indn=find_stu(stu);
        int indm=find_crs(crs);
        if(indn==-1||indm==-1)System.out.println("没有对应的学生或课程!");
        else{
            System.out.println("学生"+stu+"的"+crs+"分数:"+pnt[indn][indm]);
        }
    }

    void sort(String para){
        int id=find_crs(para);
        if(id==-1){
            System.out.println("没有对应的课程!");
        }else{
            String[] a = new String[n];
            int[] b = new int[n];
            for(int i=0;i<n;++i){
                a[i]=STU[i];
                b[i]=pnt[i][id];
            }
            for(int i=0;i<n;++i){
                for(int j=i+1;j<n;++j){
                    if(b[i]<b[j]){
                        int tint=b[i];
                        b[i]=b[j];
                        b[j]=tint;
                        String sint=a[i];
                        a[i]=a[j];
                        a[j]=sint;
                    }
                }
            }
            System.out.println("号\t名\t分");
            for(int i=0;i<n;++i){
                System.out.println((i+1)+"\t"+a[i]+"\t"+b[i]);
            }
        }
    }


}

public class main{
    public static void main(String args[]){
        data D = new data();
        D.init();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String cmd = in.next();
            if(cmd.equalsIgnoreCase("avg")){
                String para = in.next();
                if(para.equalsIgnoreCase("all"))D.show();
                else D.avg(para);
            }else if(cmd.equalsIgnoreCase("max")){
                String para = in.next();
                D.max(para);
            }else if(cmd.equalsIgnoreCase("get")){
                String para1=in.next();
                String para2=in.next();
                D.get(para1,para2);
            }else if(cmd.equalsIgnoreCase("sort")) {
                String para = in.next();
                D.sort(para);
            }else if(cmd.equalsIgnoreCase("exit")){
                System.out.println("退出系统!");
                System.exit(0);
            }else{
                System.out.println("没有对应的指令!");
            }
        }
    }
}