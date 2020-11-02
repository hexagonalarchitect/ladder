package com.hotgazpacho.ladder;

import java.lang.annotation.*;

import static com.hotgazpacho.ladder.DecisionType.UNCATEGORIZED;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PACKAGE})
@Retention(RetentionPolicy.SOURCE)
public @interface ArchitectureDecisionRecord
{
  int number();
  String title();
  String date();
  DecisionType decisiontype() default UNCATEGORIZED;
  Status status();
  String context();
  String decision();
  String consequence();
  int[] linksTo() default {};
  int[] supersedes() default {};

}
