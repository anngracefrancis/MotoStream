package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import e.h.a.k0.f;
import java.util.List;

/* JADX INFO: compiled from: ConnectionModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f20502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f20503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f20504e;

    public static long f(List<a> list) {
        long jA = 0;
        for (a aVar : list) {
            jA += aVar.a() - aVar.e();
        }
        return jA;
    }

    public long a() {
        return this.f20503d;
    }

    public long b() {
        return this.f20504e;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.f20501b;
    }

    public long e() {
        return this.f20502c;
    }

    public void g(long j2) {
        this.f20503d = j2;
    }

    public void h(long j2) {
        this.f20504e = j2;
    }

    public void i(int i2) {
        this.a = i2;
    }

    public void j(int i2) {
        this.f20501b = i2;
    }

    public void k(long j2) {
        this.f20502c = j2;
    }

    public ContentValues l() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, Integer.valueOf(this.a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f20501b));
        contentValues.put("startOffset", Long.valueOf(this.f20502c));
        contentValues.put("currentOffset", Long.valueOf(this.f20503d));
        contentValues.put("endOffset", Long.valueOf(this.f20504e));
        return contentValues;
    }

    public String toString() {
        return f.o("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.a), Integer.valueOf(this.f20501b), Long.valueOf(this.f20502c), Long.valueOf(this.f20504e), Long.valueOf(this.f20503d));
    }
}
