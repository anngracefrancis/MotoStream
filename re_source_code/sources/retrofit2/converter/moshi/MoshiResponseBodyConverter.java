package retrofit2.converter.moshi;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import j.h;
import j.i;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes3.dex */
final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final i UTF8_BOM = i.q("EFBBBF");
    private final f<T> adapter;

    MoshiResponseBodyConverter(f<T> fVar) {
        this.adapter = fVar;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        h bodySource = responseBody.getBodySource();
        try {
            i iVar = UTF8_BOM;
            if (bodySource.v0(0L, iVar)) {
                bodySource.skip(iVar.P());
            }
            com.squareup.moshi.i iVarZ = com.squareup.moshi.i.z(bodySource);
            T tFromJson = this.adapter.fromJson(iVarZ);
            if (iVarZ.A() != com.squareup.moshi.i.b.END_DOCUMENT) {
                throw new JsonDataException("JSON document was not fully consumed.");
            }
            responseBody.close();
            return tFromJson;
        } catch (Throwable th) {
            responseBody.close();
            throw th;
        }
    }
}
