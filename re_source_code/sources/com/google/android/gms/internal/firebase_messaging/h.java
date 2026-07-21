package com.google.android.gms.internal.firebase_messaging;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h extends e {
    private final g a = new g();

    h() {
    }

    @Override // com.google.android.gms.internal.firebase_messaging.e
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        this.a.a(th, true).add(th2);
    }
}
