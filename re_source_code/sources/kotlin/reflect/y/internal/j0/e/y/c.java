package kotlin.reflect.y.internal.j0.e.y;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.io.a;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.y.internal.j0.e.m;
import kotlin.s;

/* JADX INFO: compiled from: readPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final Pair<m, a> a(InputStream inputStream) throws IOException {
        m mVarX;
        kotlin.jvm.internal.m.f(inputStream, "<this>");
        try {
            a aVarA = a.f24164g.a(inputStream);
            if (aVarA.h()) {
                f fVarD = f.d();
                b.a(fVarD);
                mVarX = m.X(inputStream, fVarD);
            } else {
                mVarX = null;
            }
            Pair<m, a> pairA = s.a(mVarX, aVarA);
            a.a(inputStream, null);
            return pairA;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                a.a(inputStream, th);
                throw th2;
            }
        }
    }
}
