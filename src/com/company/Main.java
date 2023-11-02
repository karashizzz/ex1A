package com.company;

import com.company.View.AppFrame;

public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.println(System.getProperty("java.library.path"));
    System.out.println(System.getenv("PATH"));

    new AppFrame().dataInjection();
  }
}
