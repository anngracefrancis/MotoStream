package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzmp extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16468f;

    public zzmp(int i2) {
        StringBuilder sb = new StringBuilder(36);
        sb.append("AudioTrack write failed: ");
        sb.append(i2);
        super(sb.toString());
        this.f16468f = i2;
    }
}
