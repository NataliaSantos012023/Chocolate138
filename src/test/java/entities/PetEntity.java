package entities;

import jdk.jfr.Category;

 public class PetEntity {

     public int id;
     public static Category category = new Category();
     public String name;
     public String[] photoUrls;
     public Tags[] tags;
     public String status;

     public static class Category {

         public int id;
         public String name;

     }
     static class Tags {
         public int id;
         public String name;
     }
 }
