package kotlin.reflect.y.internal.j0.e.a0.b;

import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.a0.a;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: JvmNameResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a.e f23892h;

    /* JADX WARN: Illegal instructions before constructor call */
    public f(a.e eVar, String[] strArr) {
        Set setI0;
        m.f(eVar, "types");
        m.f(strArr, "strings");
        List<Integer> listX = eVar.x();
        if (listX.isEmpty()) {
            setI0 = w0.d();
        } else {
            m.e(listX, HttpUrl.FRAGMENT_ENCODE_SET);
            setI0 = c0.I0(listX);
        }
        List<a.e.c> listY = eVar.y();
        m.e(listY, "types.recordList");
        super(strArr, setI0, h.a(listY));
        this.f23892h = eVar;
    }
}
