package org.jgrapht.generate.netgen;

public class NetworkGeneratorConfigBuilderValidator {

   @FunctionalInterface
   interface Validator {
      void validate(NetworkGeneratorConfigBuilder builder);
   }
}
