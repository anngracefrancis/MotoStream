package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
final class y {
    private final String a = Preconditions.h("MESSAGE_DELIVERED", "evenType must be non-null");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f19883b;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    static class a implements com.google.firebase.encoders.c<y> {
        a() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(y yVar, com.google.firebase.encoders.d dVar) throws EncodingException, IOException {
            Intent intentB = yVar.b();
            dVar.e("ttl", f0.q(intentB));
            dVar.h("event", yVar.a());
            dVar.h("instanceId", f0.e(intentB));
            dVar.e("priority", f0.n(intentB));
            dVar.h("packageName", f0.m());
            dVar.h("sdkPlatform", "ANDROID");
            dVar.h("messageType", f0.k(intentB));
            String strG = f0.g(intentB);
            if (strG != null) {
                dVar.h("messageId", strG);
            }
            String strP = f0.p(intentB);
            if (strP != null) {
                dVar.h("topic", strP);
            }
            String strB = f0.b(intentB);
            if (strB != null) {
                dVar.h("collapseKey", strB);
            }
            if (f0.h(intentB) != null) {
                dVar.h("analyticsLabel", f0.h(intentB));
            }
            if (f0.d(intentB) != null) {
                dVar.h("composerLabel", f0.d(intentB));
            }
            String strO = f0.o(intentB);
            if (strO != null) {
                dVar.h("projectNumber", strO);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    static final class b {
        private final y a;

        b(y yVar) {
            this.a = (y) Preconditions.k(yVar);
        }

        y a() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    static final class c implements com.google.firebase.encoders.c<b> {
        c() {
        }

        @Override // com.google.firebase.encoders.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b bVar, com.google.firebase.encoders.d dVar) throws EncodingException, IOException {
            dVar.h("messaging_client_event", bVar.a());
        }
    }

    y(String str, Intent intent) {
        this.f19883b = (Intent) Preconditions.l(intent, "intent must be non-null");
    }

    String a() {
        return this.a;
    }

    Intent b() {
        return this.f19883b;
    }
}
