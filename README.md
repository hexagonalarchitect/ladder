# Ladder - Annotation-based Lightweight Architecture Decision Records for Java

Ladder aims to provide annotationon-based Lightweight Architecture Decision Records for Java, generating documentation 
you can use to impress new joiners to your project, or to jog your memory when scratching your head at code
you wrote 3 months ago.

### Step 1: Add Ladder to your project

TBD

### Step 2: Configure the annotation processor

TBD

### Step 3: Configure the annotation processor (via annotation)

```java
@LadderConfig(outputDir = "target/generated-adr")

```

### Step 4: Add your architectural decision records

```java
@ArchitectureDecisionRecord
    (
        number = 1,
        title = "Use AOP to autowire entities with domain services after construction",
        date = "2020-11-01",
        decisiontype = DecisionType.DESIGN,
        status = Status.APPROVED_FOR_PROOF_OF_CONCEPT,
        context = """
            DDD advocates that the application service layer pass dependencies to entities
            at point of use, rather than the entities being constructed with the services 
            as members. In cases where many services need passed to many methods, this 
            leads to cluttered application layer code.  
            """,
        decision = """
            Add transient fields to entities for the domain services they require.
            
            Define an annotation, @AutowireReturnValue, and use AOP to autowire domain 
            services into entities when returned from annotated methods. Only factory 
            and repository methods should be annotated (i.e., entity creation and retrieval).
            """,
        consequence = """
            A lot of boilerplate can be removed from application services and domain entity 
            parameters; code should be much easier to read.
            
            A downside is that this produces "auto-magical" behaviour (but, hey, you're 
            using Spring already), and care must be taken to remember to add the annotation 
            to new factory or repository methods.
                       
            It also violates a DDD principal. Purists may not return your calls.  
            """
    )
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutowireReturnValue {}

```

### Step 5: Link to examples, or tests that enforce your architecural decisions

```java
@Test
@EnforcesArchitectureDecision
    (
        recordNumber={1},
        title="Only repository and factory methods can sport the @AutowireReturnValue annotation"
    )
public void only_repository_and_factory_methods_may_be_annotated_with_AutowireReturnValue()
{
    methods()
        .that().areAnnotatedWith(AutowireReturnValue.class)
        .should().beDeclaredInClassesThat().areAnnotatedWith(Repository.class)
        .orShould().beDeclaredInClassesThat().areAnnotatedWith(Factory.class)
        .check(classes);
}
```

### Step 6: Generate documentation

TBD
