//package br.com.fiap.techChallenge4.infraestructure.validation;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Documented
//@Constraint(validatedBy = CPFOrCNPJValidator.class)
//@Target({ ElementType.METHOD, ElementType.FIELD })
//@Retention(RetentionPolicy.RUNTIME)
//public @interface ValidCPFOrCNPJ {
//    String message() default "Invalid format/data of CPF or CNPJ. Please use numbers only: \n\nCPF: xxxxxxxxxxx \n\nCPNJ:xxxxxxxxxxxxxx";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}