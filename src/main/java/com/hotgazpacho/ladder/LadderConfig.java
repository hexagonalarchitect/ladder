package com.hotgazpacho.ladder;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PACKAGE})
@Retention(RetentionPolicy.SOURCE)
public @interface LadderConfig
{
  String outputDir();
}
