package io;

/**
 * Created by majiangtao on 2018/4/20.
 */
public class Demo3 {
   String str = new String ("good");
   char[] ch = {'a','b','c'};

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        demo3.change(demo3.str,demo3.ch);
        System.out.println(demo3.str+"and");
        System.out.println(demo3.ch);
    }

    public void change(String str,char ch[]){
        str = "text ok";
        ch[0] = 'g';
    }
 }
