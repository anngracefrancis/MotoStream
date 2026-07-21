package com.google.firebase.crashlytics.internal.n;

/* JADX INFO: compiled from: DeliveryMechanism.java */
/* JADX INFO: loaded from: classes2.dex */
public enum f0 {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f19035k;

    f0(int i2) {
        this.f19035k = i2;
    }

    public static f0 g(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int k() {
        return this.f19035k;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f19035k);
    }
}
