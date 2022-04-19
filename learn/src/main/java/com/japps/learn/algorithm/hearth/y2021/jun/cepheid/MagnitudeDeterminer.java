/*
* $Id: MagnitudeDeterminer.java 24-Jun-2021 1:49:25 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.y2021.jun.cepheid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * The MagnitudeDeterminer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MagnitudeDeterminer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final Set<String> entities = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));

        final Map<String, Relationship> relationships = new HashMap<>();
        for (int i = 1; i < entities.size(); i++) {
            final String[] relationshipTokens = scanner.nextLine().split(" ");
            final String entity = relationshipTokens[0];
            final int magnitude = Integer.valueOf(relationshipTokens[2]);
            final String rightEntity = relationshipTokens[3];
            relationships.put(entity, new Relationship(entity, rightEntity, magnitude));
        }

        scanner.close();

        determineMagnitudeRelationship(entities, relationships);
    }

    /**
     * Determines the magnitude relationship.
     *
     * @param entities the entities
     * @param relationships the relationships
     */
    private static void determineMagnitudeRelationship(final Set<String> entities, final Map<String, Relationship> relationships) {

        for (final String entity : entities) {

        }

    }

    /**
     * The relationship.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private static final class Relationship {

        /** The entity. */
        String entity;

        /** The right entity. */
        String relatedEntity;

        /** The magnitude. */
        int magnitude;

        /**
         * Instantiates a new relationship.
         *
         * @param entity the entity
         * @param relatedEntity the related entity
         * @param magnitude the magnitude
         */
        public Relationship(final String entity, final String relatedEntity, final int magnitude) {

            this.entity = entity;
            this.relatedEntity = relatedEntity;
            this.magnitude = magnitude;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return entity + " = " + magnitude + " " + relatedEntity;
        }
    }
}
