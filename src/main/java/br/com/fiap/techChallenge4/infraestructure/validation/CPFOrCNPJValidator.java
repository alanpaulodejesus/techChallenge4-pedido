//package br.com.fiap.techChallenge4.infraestructure.validation;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//public class CPFOrCNPJValidator implements ConstraintValidator<ValidCPFOrCNPJ, String> {
//    private static final String CPF_PATTERN = "\\d{11}";
//    private static final String CNPJ_PATTERN = "\\d{14}";
//
//    @Override
//    public void initialize(ValidCPFOrCNPJ constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (value == null) {
//            return true; // Consider null as valid. Use @NotNull for null checks.
//        }
//        return value.matches(CPF_PATTERN)&&isValidCPF(value) || value.matches(CNPJ_PATTERN)&&isValidCNPJ(value);
//    }
//    private boolean isValidCPF(String cpf) {
//        cpf = cpf.replaceAll("\\D", "");  // Remove non-digits.
//        if (cpf.length() != 11 || hasAllSameDigits(cpf))
//            return false;
//
//        int[] weights = {10, 9, 8, 7, 6, 5, 4, 3, 2};
//        if (!checkDigits(cpf, weights))
//            return false;
//
//        weights = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
//        return checkDigits(cpf, weights);
//    }
//
//    private boolean checkDigits(String cpf, int[] weights) {
//        int sum = 0;
//        for (int i = 0; i < weights.length; i++) {
//            sum += Integer.parseInt(cpf.substring(i, i + 1)) * weights[i];
//        }
//        int mod = sum % 11;
//        return mod < 2 ? cpf.charAt(weights.length) == '0' : cpf.charAt(weights.length) == (char) ('0' + (11 - mod));
//    }
//
//    private boolean hasAllSameDigits(String value) {
//        return value.matches(value.charAt(0) + "{11}");
//    }
//    private boolean isValidCNPJ(String cnpj) {
//        cnpj = cnpj.replaceAll("\\D", "");  // Remove non-digits.
//        if (cnpj.length() != 14 || hasAllSameDigits(cnpj))
//            return false;
//
//        int[] weights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
//        if (!checkDigitsCNPJ(cnpj, weights))
//            return false;
//
//        weights = new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
//        return checkDigitsCNPJ(cnpj, weights);
//    }
//
//    private boolean checkDigitsCNPJ(String cnpj, int[] weights) {
//        int sum = 0;
//        for (int i = 0; i < weights.length; i++) {
//            sum += Integer.parseInt(cnpj.substring(i, i + 1)) * weights[i];
//        }
//        int mod = sum % 11;
//        return mod < 2 ? cnpj.charAt(weights.length) == '0' : cnpj.charAt(weights.length) == (char) ('0' + (11 - mod));
//    }
//
//}