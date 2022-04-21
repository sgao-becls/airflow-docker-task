package com.github.airflow.filetype;

import lombok.Data;

@Data
public class InputArgument {
  String fileName;
  int type;
  int experimentId;
}
