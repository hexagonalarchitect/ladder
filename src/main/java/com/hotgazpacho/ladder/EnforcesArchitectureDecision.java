package com.hotgazpacho.ladder;

import java.lang.annotation.*;

import static com.hotgazpacho.ladder.DecisionType.UNCATEGORIZED;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface EnforcesArchitectureDecision
{
  int[] recordNumber();
  String title();
}
