package com.github.airflow.filetype;

import com.github.airflow.dto.FileTypeArguments;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;

import java.util.Arrays;
import java.util.EnumSet;

public class App {

  public static void main(String[] args) {
    Gson gson = new GsonBuilder().serializeNulls().create();
    System.out.println(args.length);
    for (String arg : args) {
      System.out.println(arg);
    }
    InputArgument inputArgument = gson.fromJson(args[0], InputArgument.class);
    FileTypeArguments fileTypeArguments = new FileTypeArguments();
    fileTypeArguments.setFileName(inputArgument.getFileName());
    fileTypeArguments.setExperimentId(inputArgument.getExperimentId());
    fileTypeArguments.setHashKey("HashKey");
    fileTypeArguments.setType(getFailSafeValueOf(FileType.class, inputArgument.getType()).getValue());
    System.out.println(new Gson().toJson(fileTypeArguments));
  }

  public static <T extends EnumId> T getFailSafeValueOf(Class<T> enumClass, int enumId) {
    return Arrays.stream(enumClass.getEnumConstants()).filter(e->e.getId() == enumId).findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unsupported enum id %d " + enumId));
  }

  private static interface EnumId {
    int getId();
  }

  private enum FileType implements EnumId{

    FCS(1, "fcs_file"), ATTACHMENT(2, "attachment");

    @Getter
    private int id;

    @Getter
    private String value;

    FileType(int id, String value) {
      this.id = id;
      this.value = value;
    }
  }
}
