package retrofit2.converter.gson;

import com.google.gson.JsonIOException;
import com.google.gson.e;
import com.google.gson.q;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes3.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final q<T> adapter;
    private final e gson;

    GsonResponseBodyConverter(e eVar, q<T> qVar) {
        this.gson = eVar;
        this.adapter = qVar;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        a aVarN = this.gson.n(responseBody.charStream());
        try {
            T tB = this.adapter.b(aVarN);
            if (aVarN.Q() != b.END_DOCUMENT) {
                throw new JsonIOException("JSON document was not fully consumed.");
            }
            responseBody.close();
            return tB;
        } catch (Throwable th) {
            responseBody.close();
            throw th;
        }
    }
}
