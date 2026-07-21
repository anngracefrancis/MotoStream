package rx.t;

import rx.k;

/* JADX INFO: compiled from: Subscriptions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final a a = new a();

    /* JADX INFO: compiled from: Subscriptions.java */
    static final class a implements k {
        a() {
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.k
        public void unsubscribe() {
        }
    }

    public static k a(rx.m.a aVar) {
        return rx.t.a.b(aVar);
    }

    public static k b() {
        return rx.t.a.a();
    }

    public static k c() {
        return a;
    }
}
