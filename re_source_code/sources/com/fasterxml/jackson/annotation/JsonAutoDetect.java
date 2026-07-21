package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAutoDetect {

    /* JADX INFO: renamed from: com.fasterxml.jackson.annotation.JsonAutoDetect$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility;

        static {
            int[] iArr = new int[Visibility.values().length];
            $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility = iArr;
            try {
                iArr[Visibility.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.NON_PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.PROTECTED_AND_PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[Visibility.PUBLIC_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Visibility {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public boolean isVisible(Member member) {
            int i2 = AnonymousClass1.$SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[ordinal()];
            if (i2 == 1) {
                return true;
            }
            if (i2 == 3) {
                return !Modifier.isPrivate(member.getModifiers());
            }
            if (i2 != 4) {
                if (i2 != 5) {
                    return false;
                }
            } else if (Modifier.isProtected(member.getModifiers())) {
                return true;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }

    Visibility creatorVisibility() default Visibility.DEFAULT;

    Visibility fieldVisibility() default Visibility.DEFAULT;

    Visibility getterVisibility() default Visibility.DEFAULT;

    Visibility isGetterVisibility() default Visibility.DEFAULT;

    Visibility setterVisibility() default Visibility.DEFAULT;
}
