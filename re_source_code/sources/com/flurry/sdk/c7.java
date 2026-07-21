package com.flurry.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class c7<T> {
    private final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v1<T> f10678b;

    public c7(File file, String str, int i2, y1<T> y1Var) {
        this.a = file;
        this.f10678b = new t1(new x1(str, i2, y1Var));
    }

    public final T a() throws Throwable {
        FileInputStream fileInputStream;
        File file = this.a;
        T tB = (T) null;
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            d1.c(5, "VersionedDataFile", "No data to read for file:" + this.a.getName());
            return null;
        }
        boolean z = false;
        try {
            fileInputStream = new FileInputStream(this.a);
            try {
                try {
                    tB = this.f10678b.b(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    d1.d(3, "VersionedDataFile", "Error reading data file:" + this.a.getName(), e);
                    z = true;
                }
            } catch (Throwable th) {
                th = th;
                tB = (T) fileInputStream;
                c2.f(tB);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            c2.f(tB);
            throw th;
        }
        c2.f(fileInputStream);
        if (z) {
            d1.c(3, "VersionedDataFile", "Deleting data file:" + this.a.getName());
            this.a.delete();
        }
        return (T) tB;
    }

    public final void b(T t) throws Throwable {
        boolean z;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!b2.b(this.a)) {
                    throw new IOException("Cannot create parent directory!");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.a);
                try {
                    this.f10678b.a(fileOutputStream2, t);
                    c2.f(fileOutputStream2);
                    z = false;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    d1.d(3, "VersionedDataFile", "Error writing data file:" + this.a.getName(), e);
                    z = true;
                    c2.f(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    c2.f(fileOutputStream);
                    throw th;
                }
                if (z) {
                    d1.c(3, "VersionedDataFile", "Deleting data file:" + this.a.getName());
                    this.a.delete();
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean c() {
        File file = this.a;
        if (file == null) {
            return false;
        }
        return file.delete();
    }
}
