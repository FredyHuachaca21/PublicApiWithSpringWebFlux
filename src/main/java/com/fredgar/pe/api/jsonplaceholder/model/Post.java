package com.fredgar.pe.api.jsonplaceholder.model;

import lombok.Data;

@Data
public class Post {
  private int userId;
  private int id;
  private String title;
  private String body;
}
