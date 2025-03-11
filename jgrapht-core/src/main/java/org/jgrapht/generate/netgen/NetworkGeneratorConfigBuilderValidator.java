package org.jgrapht.generate.netgen;

import java.util.Arrays;
import java.util.List;

public class NetworkGeneratorConfigBuilderValidator {

   @FunctionalInterface
   interface Validator {
      void validate(NetworkGeneratorConfigBuilder builder);
   }

   private static final List<Validator> VALIDATIONS = Arrays.asList(
           (builder) -> {
              if (builder.nodeNum <= 0) {
                 invalidParam("Number of nodes must be positive");
              }
           },
           (builder) -> {
              if (builder.arcNum <= 0) {
                 invalidParam("Number of arcs must be positive");
              }
           },
           (builder) -> {
              if (builder.sourceNum <= 0) {
                 invalidParam("Number of sources must be positive");
              }
           },
           (builder) -> {
              if (builder.sinkNum <= 0) {
                 invalidParam("Number of sinks must be positive");
              }
           },
           (builder) -> {
              if (builder.sourceNum + builder.sinkNum > builder.nodeNum) {
                 invalidParam("Number of sources and sinks must not exceed the number of nodes");
              }
           },
           (builder) -> {
              if (builder.tSourceNum > builder.sourceNum) {
                 invalidParam("Number of transhipment sources must not exceed the overall number of sources");
              }
           },
           (builder) -> {
              if (builder.tSinkNum > builder.sinkNum) {
                 invalidParam("Number of transhipment sinks must not exceed the overall number of sinks");
              }
           },
           (builder) -> {
              if (builder.totalSupply < Math.max(builder.sourceNum, builder.sinkNum)) {
                 invalidParam("Total supply must not be less than the number of sources and the number of sinks");
              }
           },
           (builder) -> {
              if (builder.minCap > builder.maxCap) {
                 invalidParam("Minimum capacity must not exceed the maximum capacity");
              }
           },
           (builder) -> {
              if (builder.minCap <= 0) {
                 invalidParam("Minimum capacity must be positive");
              }
           },
           (builder) -> {
              if (builder.minCost > builder.maxCost) {
                 invalidParam("Minimum cost must not exceed the maximum cost");
              }
           }
   );

   private static void invalidParam(String message) {
      throw new IllegalArgumentException(message);
   }
}
