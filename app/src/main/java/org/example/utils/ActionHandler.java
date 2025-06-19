package org.example.utils;

@FunctionalInterface
public interface ActionHandler {
    Object execute(Object input);
}