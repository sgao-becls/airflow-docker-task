package com.github.airflow.dto;

import lombok.Data;

@Data
public class FileTypeArguments {

  String fileName;
  String hashKey;
  int experimentId;
  String type;
  String message;
}
