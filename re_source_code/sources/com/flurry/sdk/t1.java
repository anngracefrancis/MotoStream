package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class t1<ObjectType> extends s1<ObjectType> {
    public t1(v1<ObjectType> v1Var) {
        super(v1Var);
    }

    @Override // com.flurry.sdk.s1, com.flurry.sdk.v1
    public final void a(OutputStream outputStream, ObjectType objecttype) throws Throwable {
        if (outputStream == null) {
            return;
        }
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                super.a(gZIPOutputStream2, objecttype);
                c2.f(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                c2.f(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.flurry.sdk.s1, com.flurry.sdk.v1
    public final ObjectType b(InputStream inputStream) throws Throwable {
        GZIPInputStream gZIPInputStream = null;
        if (inputStream == null) {
            return null;
        }
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
            try {
                ObjectType objecttype = (ObjectType) super.b(gZIPInputStream2);
                c2.f(gZIPInputStream2);
                return objecttype;
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                c2.f(gZIPInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
