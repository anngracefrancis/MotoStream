package com.google.firebase.encoders;

import java.io.IOException;

/* JADX INFO: compiled from: ObjectEncoderContext.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d {
    d a(b bVar, boolean z) throws IOException;

    d b(b bVar, long j2) throws IOException;

    d c(b bVar, int i2) throws IOException;

    d d(b bVar, double d2) throws IOException;

    @Deprecated
    d e(String str, int i2) throws IOException;

    @Deprecated
    d h(String str, Object obj) throws IOException;

    d i(b bVar, Object obj) throws IOException;
}
