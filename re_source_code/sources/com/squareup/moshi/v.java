package com.squareup.moshi;

import java.lang.reflect.Type;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: -MoshiKotlinTypesExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u001b\n\u0000\u001a\u0011\u0010\u0005\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001H\u0087\b\u001a\u0011\u0010\b\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001H\u0087\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0002\u001a\u000e\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u000b\u001a\f\u0010\t\u001a\u00020\n*\u00020\fH\u0007\u001a'\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086\b\"\u0019\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"rawType", "Ljava/lang/Class;", "Ljava/lang/reflect/Type;", "getRawType", "(Ljava/lang/reflect/Type;)Ljava/lang/Class;", "subtypeOf", "Ljava/lang/reflect/WildcardType;", "T", "supertypeOf", "asArrayType", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "nextAnnotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "moshi"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class v {
    public static final Class<?> a(Type type) {
        kotlin.jvm.internal.m.f(type, "<this>");
        Class<?> clsG = u.g(type);
        kotlin.jvm.internal.m.e(clsG, "getRawType(this)");
        return clsG;
    }
}
