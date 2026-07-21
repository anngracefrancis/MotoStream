package retrofit2.converter.gson;

import com.google.gson.e;
import com.google.gson.u.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes3.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final e gson;

    private GsonConverterFactory(e eVar) {
        this.gson = eVar;
    }

    public static GsonConverterFactory create() {
        return create(new e());
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.j(a.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.j(a.get(type)));
    }

    public static GsonConverterFactory create(e eVar) {
        if (eVar != null) {
            return new GsonConverterFactory(eVar);
        }
        throw new NullPointerException("gson == null");
    }
}
