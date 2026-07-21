package com.aptoide.authentication.model;

import cm.aptoide.pt.networking.AuthenticationPersistence;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.o;
import com.squareup.moshi.r;
import com.squareup.moshi.w.c;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.aptoide.authentication.model.OAuth2_DataJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: OAuth2_DataJsonAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/aptoide/authentication/model/OAuth2_DataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/aptoide/authentication/model/OAuth2$Data;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", HttpUrl.FRAGMENT_ENCODE_SET, "nullableStringAdapter", HttpUrl.FRAGMENT_ENCODE_SET, "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", HttpUrl.FRAGMENT_ENCODE_SET, "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GeneratedJsonAdapter extends f<OAuth2.Data> {
    private final f<Integer> intAdapter;
    private final f<String> nullableStringAdapter;
    private final i.a options;
    private final f<String> stringAdapter;

    public GeneratedJsonAdapter(r rVar) {
        m.f(rVar, "moshi");
        i.a aVarA = i.a.a("access_token", "expires_in", AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN, "token_type", "scope");
        m.e(aVarA, "of(\"access_token\", \"expi…\", \"token_type\", \"scope\")");
        this.options = aVarA;
        f<String> fVarF = rVar.f(String.class, w0.d(), "accessToken");
        m.e(fVarF, "moshi.adapter(String::cl…t(),\n      \"accessToken\")");
        this.stringAdapter = fVarF;
        f<Integer> fVarF2 = rVar.f(Integer.TYPE, w0.d(), "expiresIn");
        m.e(fVarF2, "moshi.adapter(Int::class… emptySet(), \"expiresIn\")");
        this.intAdapter = fVarF2;
        f<String> fVarF3 = rVar.f(String.class, w0.d(), "scope");
        m.e(fVarF3, "moshi.adapter(String::cl…     emptySet(), \"scope\")");
        this.nullableStringAdapter = fVarF3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(33);
        sb.append("GeneratedJsonAdapter(");
        sb.append("OAuth2.Data");
        sb.append(')');
        String string = sb.toString();
        m.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.f
    public OAuth2.Data fromJson(i iVar) throws IOException {
        m.f(iVar, "reader");
        iVar.b();
        Integer numFromJson = null;
        String strFromJson = null;
        String strFromJson2 = null;
        String strFromJson3 = null;
        String strFromJson4 = null;
        while (iVar.f()) {
            int iH = iVar.H(this.options);
            String str = strFromJson4;
            if (iH == -1) {
                iVar.N();
                iVar.Q();
            } else if (iH == 0) {
                strFromJson = this.stringAdapter.fromJson(iVar);
                if (strFromJson == null) {
                    JsonDataException jsonDataExceptionV = c.v("accessToken", "access_token", iVar);
                    m.e(jsonDataExceptionV, "unexpectedNull(\"accessTo…, \"access_token\", reader)");
                    throw jsonDataExceptionV;
                }
            } else if (iH == 1) {
                numFromJson = this.intAdapter.fromJson(iVar);
                if (numFromJson == null) {
                    JsonDataException jsonDataExceptionV2 = c.v("expiresIn", "expires_in", iVar);
                    m.e(jsonDataExceptionV2, "unexpectedNull(\"expiresI…    \"expires_in\", reader)");
                    throw jsonDataExceptionV2;
                }
            } else if (iH == 2) {
                strFromJson2 = this.stringAdapter.fromJson(iVar);
                if (strFromJson2 == null) {
                    JsonDataException jsonDataExceptionV3 = c.v("refreshToken", AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN, iVar);
                    m.e(jsonDataExceptionV3, "unexpectedNull(\"refreshT… \"refresh_token\", reader)");
                    throw jsonDataExceptionV3;
                }
            } else if (iH == 3) {
                strFromJson3 = this.stringAdapter.fromJson(iVar);
                if (strFromJson3 == null) {
                    JsonDataException jsonDataExceptionV4 = c.v("tokenType", "token_type", iVar);
                    m.e(jsonDataExceptionV4, "unexpectedNull(\"tokenTyp…    \"token_type\", reader)");
                    throw jsonDataExceptionV4;
                }
            } else if (iH == 4) {
                strFromJson4 = this.nullableStringAdapter.fromJson(iVar);
            }
            strFromJson4 = str;
        }
        String str2 = strFromJson4;
        iVar.d();
        if (strFromJson == null) {
            JsonDataException jsonDataExceptionN = c.n("accessToken", "access_token", iVar);
            m.e(jsonDataExceptionN, "missingProperty(\"accessT…ken\",\n            reader)");
            throw jsonDataExceptionN;
        }
        if (numFromJson == null) {
            JsonDataException jsonDataExceptionN2 = c.n("expiresIn", "expires_in", iVar);
            m.e(jsonDataExceptionN2, "missingProperty(\"expiresIn\", \"expires_in\", reader)");
            throw jsonDataExceptionN2;
        }
        int iIntValue = numFromJson.intValue();
        if (strFromJson2 == null) {
            JsonDataException jsonDataExceptionN3 = c.n("refreshToken", AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN, iVar);
            m.e(jsonDataExceptionN3, "missingProperty(\"refresh…ken\",\n            reader)");
            throw jsonDataExceptionN3;
        }
        if (strFromJson3 != null) {
            return new OAuth2.Data(strFromJson, iIntValue, strFromJson2, strFromJson3, str2);
        }
        JsonDataException jsonDataExceptionN4 = c.n("tokenType", "token_type", iVar);
        m.e(jsonDataExceptionN4, "missingProperty(\"tokenType\", \"token_type\", reader)");
        throw jsonDataExceptionN4;
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, OAuth2.Data data) throws IOException {
        m.f(oVar, "writer");
        if (data == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        oVar.b();
        oVar.l("access_token");
        this.stringAdapter.toJson(oVar, data.getAccessToken());
        oVar.l("expires_in");
        this.intAdapter.toJson(oVar, Integer.valueOf(data.getExpiresIn()));
        oVar.l(AuthenticationPersistence.ACCOUNT_REFRESH_TOKEN);
        this.stringAdapter.toJson(oVar, data.getRefreshToken());
        oVar.l("token_type");
        this.stringAdapter.toJson(oVar, data.getTokenType());
        oVar.l("scope");
        this.nullableStringAdapter.toJson(oVar, data.getScope());
        oVar.e();
    }
}
