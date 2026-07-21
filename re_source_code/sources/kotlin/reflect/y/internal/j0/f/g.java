package kotlin.reflect.y.internal.j0.f;

import kotlin.jvm.internal.m;
import kotlin.text.Regex;

/* JADX INFO: compiled from: NameUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final g a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f24215b = new Regex("[^\\p{L}\\p{Digit}]");

    private g() {
    }

    public static final String a(String str) {
        m.f(str, "name");
        return f24215b.c(str, "_");
    }
}
