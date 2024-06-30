package com.idstu;
import java.util.Random ;
import java.util.Scanner ;
public class test9 {
    public static void main(String[] args) {
        //双色球 六个红一个蓝 红色1-33 蓝色1-16 不能重复
        //1.让用户输入一组号码‘
        //2.随机一组号码
        //3.看想不想等
        // 4.中奖情况
        int[] uesrnumbers = userSelectNumbers();
        int[] lucknumbers = creatLuckNumbers() ;

        System.out.println("您输入的号码是：");
        nums(uesrnumbers);
        System.out.println("");
        System.out.println("中奖号码是：");
        nums(lucknumbers);
        System.out.println("");
        System.out.println("??????????");
        judge(uesrnumbers , lucknumbers);
        System.out.println("!!!!!!!!!!!!!!!!!");
    }
    //用户输入！！！！！！！！！！！
    public static int[] userSelectNumbers () {
        //1.让用户输入一组号码
        Scanner sc = new Scanner(System.in);
        int[] user = new int[7];
        //输入号码七次 for循环
        //red * 6
        for (int i = 0; i < user.length - 1; i++) {
            while (true) {
                System.out.println("请输入第" + (i + 1) + "个红球数字（1-33）不能重复");
                int number = sc.nextInt();
                if (number > 33 || number < 1 ) {
                    System.out.println("格式不对 重新输入");
                    continue;
                } else if( panduan(user , number)){
                    System.out.println("您输入的数字重复，请重新输入");
                    continue;
                } else {
                    user[i] = number;
                    break;
                }
            }
        }
        //blue * 1
        while (true) {
            System.out.println("请输入第" + user.length + "个蓝球数字（1-16）不能重复");
            int number = sc.nextInt();
            if (number > 16 || number  < 1) { //不在范围内
                System.out.println("格式错误，重新输入");
                continue;
//                user[user.length - 1 ] = number;
//                break;
            }else if(panduan(user ,number)){ //判断重复
                System.out.println("您输入的数字重复，请重新输入");
                continue;
            } else {
                user[user.length - 1 ] = number;
                break;
            }
        }
        return user ;
    }

    //2.随机一组号码!!!!!!!!!!!!!!!!!!
    public static int[] creatLuckNumbers (){
        //随机数放到一个数列里
        //蓝色r+1
        int[] ran = new int[7] ;
        //随机红*6，判断重复
        for (int i = 0; i < ran.length - 1; i++) {
            while (true) {
                Random r = new Random();
                int numblue = r.nextInt(33);
                if (panduan(ran, numblue)) {
                    continue;
                }else{
                    ran[i] = numblue + 1;
                    break;
                }
            }
        }
            //blue * 1

        while (true) {
            Random r = new Random() ;
            int numblue = r.nextInt(15) ;
            if (panduan(ran, numblue)) {
                continue;
            }else {
                ran[ran.length - 1] = numblue + 1 ;
                break;
            }
        }
        return ran ;
    }
    //判断是否重复!!!!!!!!!!!!!!
    //true 重复,false no重复
    public static boolean panduan (int[]user,int number){
        //总数列
        for (int i = 0; i < user.length; i++) {
            if(user[i] == 0){
                return false ;
            }else if (number == user[i]){
                return true ;
            }
        }
        return false ;
    }
    //遍历数组！！！！！！！！！！！！！
    public static void nums(int[] a){
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(i <= a.length - 1? a[i] + "," : "");
        }
        System.out.print("]");
    }
    public static void judge(int[]usernumbers ,int[]lucknumbers){

        //中奖情况！！！！！！！！几个红几个蓝
        int numred = 0 ;

        for (int i = 0; i < userSelectNumbers().length - 1 ; i++) {
            for (int j = 0; j < lucknumbers.length - 1; j++) {
                if (usernumbers[i] == lucknumbers[i]){
                    numred++ ;
                    break;
                }
            }
        }
        int numblue = usernumbers[6] ==lucknumbers[6] ? 1: 0 ;
        System.out.println("红球数量："+ numred + "   " + "蓝球数量：" + numblue);
//        if(numblue == 1 && numred <= 1 ){
//            System.out.println("5");
//        }else if(numred >= 6 && numblue==1){
//            System.out.println("1000wan");
//        } else if (numred == 5 && numblue == 1) {
//            System.out.println("3000");
//        }else if(numred >= 6 && numblue == 0) {
//            System.out.println("500wan");
//        }else if(numred + numblue == 5) {
//            System.out.println("200");
//        }else{
//            System.out.println("20");
//
//    }
    //中奖奖金

    }

}

