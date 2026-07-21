package com.airbnb.lottie.t;

import cm.aptoide.pt.utils.MultiDexHelper;

/* JADX INFO: compiled from: FileExtension.java */
/* JADX INFO: loaded from: classes.dex */
public enum a {
    Json(".json"),
    Zip(MultiDexHelper.EXTRACTED_SUFFIX);


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8844i;

    a(String str) {
        this.f8844i = str;
    }

    public String g() {
        return ".temp" + this.f8844i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f8844i;
    }
}
