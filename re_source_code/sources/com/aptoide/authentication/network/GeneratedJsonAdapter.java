package com.aptoide.authentication.network;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.o;
import com.squareup.moshi.r;
import com.squareup.moshi.u;
import com.squareup.moshi.w.c;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.aptoide.authentication.network.RemoteAuthenticationService_CredentialsJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: RemoteAuthenticationService_CredentialsJsonAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/aptoide/authentication/network/RemoteAuthenticationService_CredentialsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/aptoide/authentication/network/RemoteAuthenticationService$Credentials;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "arrayOfStringAdapter", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", HttpUrl.FRAGMENT_ENCODE_SET, "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GeneratedJsonAdapter extends f<RemoteAuthenticationService.Credentials> {
    private final f<String[]> arrayOfStringAdapter;
    private final i.a options;
    private final f<String> stringAdapter;

    public GeneratedJsonAdapter(r rVar) {
        m.f(rVar, "moshi");
        i.a aVarA = i.a.a("credential", "supported");
        m.e(aVarA, "of(\"credential\", \"supported\")");
        this.options = aVarA;
        f<String> fVarF = rVar.f(String.class, w0.d(), "credential");
        m.e(fVarF, "moshi.adapter(String::cl…et(),\n      \"credential\")");
        this.stringAdapter = fVarF;
        f<String[]> fVarF2 = rVar.f(u.b(String.class), w0.d(), "supported");
        m.e(fVarF2, "moshi.adapter(Types.arra… emptySet(), \"supported\")");
        this.arrayOfStringAdapter = fVarF2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(61);
        sb.append("GeneratedJsonAdapter(");
        sb.append("RemoteAuthenticationService.Credentials");
        sb.append(')');
        String string = sb.toString();
        m.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.f
    public RemoteAuthenticationService.Credentials fromJson(i iVar) throws IOException {
        m.f(iVar, "reader");
        iVar.b();
        String strFromJson = null;
        String[] strArrFromJson = null;
        while (iVar.f()) {
            int iH = iVar.H(this.options);
            if (iH == -1) {
                iVar.N();
                iVar.Q();
            } else if (iH == 0) {
                strFromJson = this.stringAdapter.fromJson(iVar);
                if (strFromJson == null) {
                    JsonDataException jsonDataExceptionV = c.v("credential", "credential", iVar);
                    m.e(jsonDataExceptionV, "unexpectedNull(\"credenti…    \"credential\", reader)");
                    throw jsonDataExceptionV;
                }
            } else if (iH == 1 && (strArrFromJson = this.arrayOfStringAdapter.fromJson(iVar)) == null) {
                JsonDataException jsonDataExceptionV2 = c.v("supported", "supported", iVar);
                m.e(jsonDataExceptionV2, "unexpectedNull(\"supported\", \"supported\", reader)");
                throw jsonDataExceptionV2;
            }
        }
        iVar.d();
        if (strFromJson == null) {
            JsonDataException jsonDataExceptionN = c.n("credential", "credential", iVar);
            m.e(jsonDataExceptionN, "missingProperty(\"credent…l\", \"credential\", reader)");
            throw jsonDataExceptionN;
        }
        if (strArrFromJson != null) {
            return new RemoteAuthenticationService.Credentials(strFromJson, strArrFromJson);
        }
        JsonDataException jsonDataExceptionN2 = c.n("supported", "supported", iVar);
        m.e(jsonDataExceptionN2, "missingProperty(\"supported\", \"supported\", reader)");
        throw jsonDataExceptionN2;
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, RemoteAuthenticationService.Credentials credentials) throws IOException {
        m.f(oVar, "writer");
        if (credentials == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        oVar.b();
        oVar.l("credential");
        this.stringAdapter.toJson(oVar, credentials.getCredential());
        oVar.l("supported");
        this.arrayOfStringAdapter.toJson(oVar, credentials.getSupported());
        oVar.e();
    }
}
