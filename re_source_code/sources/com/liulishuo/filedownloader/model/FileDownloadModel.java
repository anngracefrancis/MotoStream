package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import e.h.a.k0.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class FileDownloadModel implements Parcelable {
    public static final Parcelable.Creator<FileDownloadModel> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f20495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f20496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f20497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f20498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f20499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f20500k;
    private final AtomicLong l;
    private long m;
    private String n;
    private String o;
    private int p;
    private boolean q;

    static class a implements Parcelable.Creator<FileDownloadModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileDownloadModel createFromParcel(Parcel parcel) {
            return new FileDownloadModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileDownloadModel[] newArray(int i2) {
            return new FileDownloadModel[i2];
        }
    }

    public FileDownloadModel() {
        this.l = new AtomicLong();
        this.f20500k = new AtomicInteger();
    }

    public void B(String str) {
        this.f20496g = str;
    }

    public ContentValues C() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(e()));
        contentValues.put("url", l());
        contentValues.put("path", f());
        contentValues.put("status", Byte.valueOf(h()));
        contentValues.put("sofar", Long.valueOf(g()));
        contentValues.put("total", Long.valueOf(k()));
        contentValues.put("errMsg", c());
        contentValues.put("etag", b());
        contentValues.put("connectionCount", Integer.valueOf(a()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(p()));
        if (p() && d() != null) {
            contentValues.put("filename", d());
        }
        return contentValues;
    }

    public int a() {
        return this.p;
    }

    public String b() {
        return this.o;
    }

    public String c() {
        return this.n;
    }

    public String d() {
        return this.f20499j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f20495f;
    }

    public String f() {
        return this.f20497h;
    }

    public long g() {
        return this.l.get();
    }

    public byte h() {
        return (byte) this.f20500k.get();
    }

    public String i() {
        return f.B(f(), p(), d());
    }

    public String j() {
        if (i() == null) {
            return null;
        }
        return f.C(i());
    }

    public long k() {
        return this.m;
    }

    public String l() {
        return this.f20496g;
    }

    public void m(long j2) {
        this.l.addAndGet(j2);
    }

    public boolean n() {
        return this.m == -1;
    }

    public boolean o() {
        return this.q;
    }

    public boolean p() {
        return this.f20498i;
    }

    public void q() {
        this.p = 1;
    }

    public void r(int i2) {
        this.p = i2;
    }

    public void s(String str) {
        this.o = str;
    }

    public void t(String str) {
        this.n = str;
    }

    public String toString() {
        return f.o("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f20495f), this.f20496g, this.f20497h, Integer.valueOf(this.f20500k.get()), this.l, Long.valueOf(this.m), this.o, super.toString());
    }

    public void u(String str) {
        this.f20499j = str;
    }

    public void v(int i2) {
        this.f20495f = i2;
    }

    public void w(String str, boolean z) {
        this.f20497h = str;
        this.f20498i = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f20495f);
        parcel.writeString(this.f20496g);
        parcel.writeString(this.f20497h);
        parcel.writeByte(this.f20498i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f20499j);
        parcel.writeByte((byte) this.f20500k.get());
        parcel.writeLong(this.l.get());
        parcel.writeLong(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeInt(this.p);
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
    }

    public void x(long j2) {
        this.l.set(j2);
    }

    public void y(byte b2) {
        this.f20500k.set(b2);
    }

    public void z(long j2) {
        this.q = j2 > 2147483647L;
        this.m = j2;
    }

    protected FileDownloadModel(Parcel parcel) {
        this.f20495f = parcel.readInt();
        this.f20496g = parcel.readString();
        this.f20497h = parcel.readString();
        this.f20498i = parcel.readByte() != 0;
        this.f20499j = parcel.readString();
        this.f20500k = new AtomicInteger(parcel.readByte());
        this.l = new AtomicLong(parcel.readLong());
        this.m = parcel.readLong();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readByte() != 0;
    }
}
