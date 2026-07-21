package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements com.google.gson.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f20135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f20136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f20137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f20138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f20139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f20140k;
    private static final /* synthetic */ c[] l;

    /* JADX INFO: compiled from: FieldNamingPolicy.java */
    static enum a extends c {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.gson.d
        public String g(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f20135f = aVar;
        c cVar = new c("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.c.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String g(Field field) {
                return c.u(field.getName());
            }
        };
        f20136g = cVar;
        c cVar2 = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.c.c
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String g(Field field) {
                return c.u(c.q(field.getName(), " "));
            }
        };
        f20137h = cVar2;
        c cVar3 = new c("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.c.d
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String g(Field field) {
                return c.q(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        f20138i = cVar3;
        c cVar4 = new c("LOWER_CASE_WITH_DASHES", 4) { // from class: com.google.gson.c.e
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String g(Field field) {
                return c.q(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        f20139j = cVar4;
        c cVar5 = new c("LOWER_CASE_WITH_DOTS", 5) { // from class: com.google.gson.c.f
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.d
            public String g(Field field) {
                return c.q(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        f20140k = cVar5;
        l = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5};
    }

    private c(String str, int i2) {
        super(str, i2);
    }

    private static String k(char c2, String str, int i2) {
        if (i2 >= str.length()) {
            return String.valueOf(c2);
        }
        return c2 + str.substring(i2);
    }

    static String q(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String u(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char cCharAt = str.charAt(0);
        int length = str.length();
        while (i2 < length - 1 && !Character.isLetter(cCharAt)) {
            sb.append(cCharAt);
            i2++;
            cCharAt = str.charAt(i2);
        }
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        sb.append(k(Character.toUpperCase(cCharAt), str, i2 + 1));
        return sb.toString();
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) l.clone();
    }

    /* synthetic */ c(String str, int i2, a aVar) {
        this(str, i2);
    }
}
