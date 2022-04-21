package com.github.airflow.fcs;

import com.github.airflow.dto.FileTypeArguments;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

  public static void main(String[] args) {
    Gson gson = new GsonBuilder().serializeNulls().create();
    System.out.println(args.length);
    for (String arg : args) {
      System.out.println(arg);
    }
    FileTypeArguments fileTypeArguments = gson.fromJson(args[0], FileTypeArguments.class);
    fileTypeArguments.setMessage("copied fcs");
    System.out.println(gson.toJson(fileTypeArguments));
  }
}
