package com.fasterxml.jackson.databind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonPOJOBuilder {

    /* JADX INFO: loaded from: classes2.dex */
    public static class Value {
        public final String buildMethodName;
        public final String withPrefix;

        public Value(JsonPOJOBuilder jsonPOJOBuilder) {
            this.buildMethodName = jsonPOJOBuilder.buildMethodName();
            this.withPrefix = jsonPOJOBuilder.withPrefix();
        }
    }

    String buildMethodName() default "build";

    String withPrefix() default "with";
}
