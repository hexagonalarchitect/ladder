package com.hotgazpacho.ladder.processor;


import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.util.Set;

import com.google.auto.service.AutoService;

@SupportedAnnotationTypes({"com.hotgazpacho.ladder.LadderConfig", "com.hotgazpacho.ladder.ArchitectureDecisionRecord"})
@SupportedSourceVersion(SourceVersion.RELEASE_15)
@AutoService(Processor.class)
public class LadderProcessor extends AbstractProcessor
{
  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
  {

    for (TypeElement annotation : annotations) {
      Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);

      annotatedElements.forEach(e -> System.out.println("Found annotated element: " + e));
    }
    return true;
  }
}
