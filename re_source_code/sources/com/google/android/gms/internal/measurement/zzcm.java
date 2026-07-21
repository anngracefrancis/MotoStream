package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcm {
    private static final c.e.a<String, Uri> a = new c.e.a<>();

    public static synchronized Uri a(String str) {
        Uri uri;
        c.e.a<String, Uri> aVar = a;
        uri = aVar.get(str);
        if (uri == null) {
            String strValueOf = String.valueOf(Uri.encode(str));
            uri = Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
            aVar.put(str, uri);
        }
        return uri;
    }
}
