package com.facebook;

import java.util.Random;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FacebookException.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0016\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000fB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\tB\u001d\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fB\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/facebook/FacebookException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "<init>", "()V", "message", "(Ljava/lang/String;)V", HttpUrl.FRAGMENT_ENCODE_SET, "throwable", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "f", "a", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public class FacebookException extends RuntimeException {
    public FacebookException() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(String str, boolean z) {
        if (z) {
            try {
                com.facebook.internal.t0.o.e eVar = com.facebook.internal.t0.o.e.a;
                com.facebook.internal.t0.o.e.g(str);
            } catch (Exception unused) {
            }
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        String message = getMessage();
        return message == null ? HttpUrl.FRAGMENT_ENCODE_SET : message;
    }

    public FacebookException(final String str) {
        super(str);
        Random random = new Random();
        if (str != null) {
            a0 a0Var = a0.a;
            if (!a0.w() || random.nextInt(100) <= 50) {
                return;
            }
            com.facebook.internal.a0 a0Var2 = com.facebook.internal.a0.a;
            com.facebook.internal.a0.a(com.facebook.internal.a0.b.ErrorReport, new com.facebook.internal.a0.a() { // from class: com.facebook.e
                @Override // com.facebook.internal.a0.a
                public final void a(boolean z) {
                    FacebookException.a(str, z);
                }
            });
        }
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }
}
