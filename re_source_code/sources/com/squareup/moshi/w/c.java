package com.squareup.moshi.w;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.e;
import com.squareup.moshi.f;
import com.squareup.moshi.g;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.r;
import com.squareup.moshi.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final Set<Annotation> a = Collections.emptySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Type[] f20631b = new Type[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class<?> f20632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Class<? extends Annotation> f20633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f20634e;

    /* JADX INFO: compiled from: Util.java */
    public static final class a implements GenericArrayType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f20635f;

        public a(Type type) {
            this.f20635f = c.a(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && u.d(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f20635f;
        }

        public int hashCode() {
            return this.f20635f.hashCode();
        }

        public String toString() {
            return c.u(this.f20635f) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* JADX INFO: compiled from: Util.java */
    public static final class b implements ParameterizedType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f20636f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Type f20637g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Type[] f20638h;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || u.g(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            this.f20636f = type == null ? null : c.a(type);
            this.f20637g = c.a(type2);
            this.f20638h = (Type[]) typeArr.clone();
            int i2 = 0;
            while (true) {
                Type[] typeArr2 = this.f20638h;
                if (i2 >= typeArr2.length) {
                    return;
                }
                typeArr2[i2].getClass();
                c.b(typeArr2[i2]);
                Type[] typeArr3 = this.f20638h;
                typeArr3[i2] = c.a(typeArr3[i2]);
                i2++;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && u.d(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f20638h.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f20636f;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f20637g;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f20638h) ^ this.f20637g.hashCode()) ^ c.f(this.f20636f);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.f20638h.length + 1) * 30);
            sb.append(c.u(this.f20637g));
            if (this.f20638h.length == 0) {
                return sb.toString();
            }
            sb.append("<");
            sb.append(c.u(this.f20638h[0]));
            for (int i2 = 1; i2 < this.f20638h.length; i2++) {
                sb.append(", ");
                sb.append(c.u(this.f20638h[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: com.squareup.moshi.w.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Util.java */
    public static final class C0250c implements WildcardType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Type f20639f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Type f20640g;

        public C0250c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                typeArr[0].getClass();
                c.b(typeArr[0]);
                this.f20640g = null;
                this.f20639f = c.a(typeArr[0]);
                return;
            }
            typeArr2[0].getClass();
            c.b(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f20640g = c.a(typeArr2[0]);
            this.f20639f = Object.class;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && u.d(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f20640g;
            return type != null ? new Type[]{type} : c.f20631b;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f20639f};
        }

        public int hashCode() {
            Type type = this.f20640g;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f20639f.hashCode() + 31);
        }

        public String toString() {
            if (this.f20640g != null) {
                return "? super " + c.u(this.f20640g);
            }
            if (this.f20639f == Object.class) {
                return "?";
            }
            return "? extends " + c.u(this.f20639f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Class<? extends Annotation> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName(getKotlinMetadataClassName());
        } catch (ClassNotFoundException unused) {
            cls = 0;
        }
        f20633d = cls;
        try {
            cls2 = Class.forName("kotlin.a0.d.g");
        } catch (ClassNotFoundException unused2) {
        }
        f20632c = cls2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        linkedHashMap.put(Boolean.TYPE, Boolean.class);
        linkedHashMap.put(Byte.TYPE, Byte.class);
        linkedHashMap.put(Character.TYPE, Character.class);
        linkedHashMap.put(Double.TYPE, Double.class);
        linkedHashMap.put(Float.TYPE, Float.class);
        linkedHashMap.put(Integer.TYPE, Integer.class);
        linkedHashMap.put(Long.TYPE, Long.class);
        linkedHashMap.put(Short.TYPE, Short.class);
        linkedHashMap.put(Void.TYPE, Void.class);
        f20634e = Collections.unmodifiableMap(linkedHashMap);
    }

    public static Type a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(a(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            if (type instanceof b) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return type instanceof a ? type : new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType) || (type instanceof C0250c)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new C0250c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    static void b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    static Class<?> c(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static f<?> d(r rVar, Type type, Class<?> cls) {
        Constructor<?> declaredConstructor;
        Object[] objArr;
        g gVar = (g) cls.getAnnotation(g.class);
        Class<?> cls2 = null;
        if (gVar == null || !gVar.generateAdapter()) {
            return null;
        }
        try {
            try {
                cls2 = Class.forName(u.e(cls.getName()), true, cls.getClassLoader());
                if (type instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                    try {
                        declaredConstructor = cls2.getDeclaredConstructor(r.class, Type[].class);
                        objArr = new Object[]{rVar, actualTypeArguments};
                    } catch (NoSuchMethodException unused) {
                        declaredConstructor = cls2.getDeclaredConstructor(Type[].class);
                        objArr = new Object[]{actualTypeArguments};
                    }
                } else {
                    try {
                        declaredConstructor = cls2.getDeclaredConstructor(r.class);
                        objArr = new Object[]{rVar};
                    } catch (NoSuchMethodException unused2) {
                        declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                        objArr = new Object[0];
                    }
                }
                declaredConstructor.setAccessible(true);
                return ((f) declaredConstructor.newInstance(objArr)).nullSafe();
            } catch (NoSuchMethodException e2) {
                if ((type instanceof ParameterizedType) || cls2.getTypeParameters().length == 0) {
                    throw new RuntimeException("Failed to find the generated JsonAdapter constructor for " + type, e2);
                }
                throw new RuntimeException("Failed to find the generated JsonAdapter constructor for '" + type + "'. Suspiciously, the type was not parameterized but the target class '" + cls2.getCanonicalName() + "' is generic. Consider using Types#newParameterizedType() to define these missing type variables.", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Failed to find the generated JsonAdapter class for " + type, e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Failed to access the generated JsonAdapter for " + type, e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("Failed to instantiate the generated JsonAdapter for " + type, e5);
        } catch (InvocationTargetException e6) {
            throw s(e6);
        }
    }

    public static Type e(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (interfaces[i2] == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(interfaces[i2])) {
                    return e(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return e(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    static int f(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    static int g(Object[] objArr, Object obj) {
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    private static String getKotlinMetadataClassName() {
        return "kotlin.Metadata";
    }

    public static boolean h(Class<?> cls) {
        Class<? extends Annotation> cls2 = f20633d;
        return cls2 != null && cls.isAnnotationPresent(cls2);
    }

    public static boolean i(Class<?> cls) {
        String name = cls.getName();
        return name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static Set<? extends Annotation> j(AnnotatedElement annotatedElement) {
        return k(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> k(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(h.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        return linkedHashSet != null ? Collections.unmodifiableSet(linkedHashSet) : a;
    }

    public static String l(String str, e eVar) {
        if (eVar == null) {
            return str;
        }
        String strName = eVar.name();
        return "\u0000".equals(strName) ? str : strName;
    }

    public static String m(String str, AnnotatedElement annotatedElement) {
        return l(str, (e) annotatedElement.getAnnotation(e.class));
    }

    public static JsonDataException n(String str, String str2, i iVar) {
        String strG = iVar.g();
        return new JsonDataException(str2.equals(str) ? String.format("Required value '%s' missing at %s", str, strG) : String.format("Required value '%s' (JSON name '%s') missing at %s", str, str2, strG));
    }

    public static Type o(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return upperBounds[0];
        }
        throw new IllegalArgumentException();
    }

    public static Type p(Type type, Class<?> cls, Type type2) {
        return q(type, cls, type2, new LinkedHashSet());
    }

    private static Type q(Type type, Class<?> cls, Type type2, Collection<TypeVariable<?>> collection) {
        Type type3;
        WildcardType wildcardType;
        while (type2 instanceof TypeVariable) {
            TypeVariable<?> typeVariable = (TypeVariable) type2;
            if (collection.contains(typeVariable)) {
                return type2;
            }
            collection.add(typeVariable);
            type2 = r(type, cls, typeVariable);
            if (type2 == typeVariable) {
                return type2;
            }
        }
        if (type2 instanceof Class) {
            Class cls2 = (Class) type2;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type typeQ = q(type, cls, componentType, collection);
                return componentType == typeQ ? cls2 : u.b(typeQ);
            }
        }
        if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeQ2 = q(type, cls, genericComponentType, collection);
            return genericComponentType == typeQ2 ? genericArrayType : u.b(typeQ2);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeQ3 = q(type, cls, ownerType, collection);
            boolean z = typeQ3 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i2 = 0; i2 < length; i2++) {
                Type typeQ4 = q(type, cls, actualTypeArguments[i2], collection);
                if (typeQ4 != actualTypeArguments[i2]) {
                    if (!z) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z = true;
                    }
                    actualTypeArguments[i2] = typeQ4;
                }
            }
            return z ? new b(typeQ3, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        if (type2 instanceof WildcardType) {
            wildcardType = (WildcardType) type2;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeQ5 = q(type, cls, lowerBounds[0], collection);
                if (typeQ5 != lowerBounds[0]) {
                    type3 = type2;
                    type3 = wildcardType;
                    return u.l(typeQ5);
                }
            } else if (upperBounds.length == 1) {
                type3 = type2;
                type3 = wildcardType;
                Type typeQ6 = q(type, cls, upperBounds[0], collection);
                type3 = wildcardType;
                if (typeQ6 != upperBounds[0]) {
                    return u.k(typeQ6);
                }
            }
        }
        type3 = type2;
        type3 = wildcardType;
        type3 = type2;
        type3 = wildcardType;
        type3 = type2;
        return type3;
    }

    static Type r(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsC = c(typeVariable);
        if (clsC == null) {
            return typeVariable;
        }
        Type typeE = e(type, cls, clsC);
        if (!(typeE instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) typeE).getActualTypeArguments()[g(clsC.getTypeParameters(), typeVariable)];
    }

    public static RuntimeException s(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        if (targetException instanceof RuntimeException) {
            throw ((RuntimeException) targetException);
        }
        if (targetException instanceof Error) {
            throw ((Error) targetException);
        }
        throw new RuntimeException(targetException);
    }

    public static String t(Type type, Set<? extends Annotation> set) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        if (set.isEmpty()) {
            str = " (with no annotations)";
        } else {
            str = " annotated " + set;
        }
        sb.append(str);
        return sb.toString();
    }

    static String u(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static JsonDataException v(String str, String str2, i iVar) {
        String strG = iVar.g();
        return new JsonDataException(str2.equals(str) ? String.format("Non-null value '%s' was null at %s", str, strG) : String.format("Non-null value '%s' (JSON name '%s') was null at %s", str, str2, strG));
    }
}
