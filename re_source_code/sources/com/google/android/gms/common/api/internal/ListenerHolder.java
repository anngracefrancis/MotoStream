package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class ListenerHolder<L> {
    private volatile L a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListenerKey<L> f11735b;

    @KeepForSdk
    public static final class ListenerKey<L> {
        private final L a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11736b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.a == listenerKey.a && this.f11736b.equals(listenerKey.f11736b);
        }

        public final int hashCode() {
            return (System.identityHashCode(this.a) * 31) + this.f11736b.hashCode();
        }
    }

    @KeepForSdk
    public interface Notifier<L> {
    }

    @KeepForSdk
    public final void a() {
        this.a = null;
    }

    @KeepForSdk
    public final ListenerKey<L> b() {
        return this.f11735b;
    }

    @KeepForSdk
    public final void c(Notifier<? super L> notifier) {
        Preconditions.l(notifier, "Notifier must not be null");
        throw null;
    }
}
