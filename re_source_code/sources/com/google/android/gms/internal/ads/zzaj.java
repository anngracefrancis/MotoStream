package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import okhttp3.HttpUrl;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaj implements zzas {
    @Override // com.google.android.gms.internal.ads.zzas
    @Deprecated
    public final HttpResponse a(zzr<?> zzrVar, Map<String, String> map) throws zza, IOException {
        zzar zzarVarB = b(zzrVar, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), zzarVarB.c(), HttpUrl.FRAGMENT_ENCODE_SET));
        ArrayList arrayList = new ArrayList();
        for (zzl zzlVar : zzarVarB.d()) {
            arrayList.add(new BasicHeader(zzlVar.a(), zzlVar.b()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream inputStreamA = zzarVarB.a();
        if (inputStreamA != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStreamA);
            basicHttpEntity.setContentLength(zzarVarB.b());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }

    public abstract zzar b(zzr<?> zzrVar, Map<String, String> map) throws zza, IOException;
}
