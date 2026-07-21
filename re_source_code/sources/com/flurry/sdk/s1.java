package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class s1<ObjectType> implements v1<ObjectType> {
    protected final v1<ObjectType> a;

    public s1(v1<ObjectType> v1Var) {
        this.a = v1Var;
    }

    @Override // com.flurry.sdk.v1
    public void a(OutputStream outputStream, ObjectType objecttype) throws IOException {
        v1<ObjectType> v1Var = this.a;
        if (v1Var == null || outputStream == null || objecttype == null) {
            return;
        }
        v1Var.a(outputStream, objecttype);
    }

    @Override // com.flurry.sdk.v1
    public ObjectType b(InputStream inputStream) throws IOException {
        v1<ObjectType> v1Var = this.a;
        if (v1Var == null || inputStream == null) {
            return null;
        }
        return v1Var.b(inputStream);
    }
}
