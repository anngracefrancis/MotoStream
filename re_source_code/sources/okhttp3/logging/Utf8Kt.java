package okhttp3.logging;

import j.f;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: utf8.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lj/f;", HttpUrl.FRAGMENT_ENCODE_SET, "isProbablyUtf8", "(Lj/f;)Z", "okhttp-logging-interceptor"}, k = 2, mv = {1, 4, 0})
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(f fVar) {
        m.f(fVar, "$this$isProbablyUtf8");
        try {
            f fVar2 = new f();
            fVar.j(fVar2, 0L, l.e(fVar.size(), 64L));
            for (int i2 = 0; i2 < 16 && !fVar2.R(); i2++) {
                int iA0 = fVar2.a0();
                if (Character.isISOControl(iA0) && !Character.isWhitespace(iA0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
