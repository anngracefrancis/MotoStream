package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Single;
import rx.b;
import rx.e;
import rx.h;

/* JADX INFO: loaded from: classes3.dex */
public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final h scheduler;

    private RxJavaCallAdapterFactory(h hVar, boolean z) {
        this.scheduler = hVar;
        this.isAsync = z;
    }

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory(null, false);
    }

    public static RxJavaCallAdapterFactory createAsync() {
        return new RxJavaCallAdapterFactory(null, true);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(h hVar) {
        if (hVar != null) {
            return new RxJavaCallAdapterFactory(hVar, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type parameterUpperBound;
        boolean z;
        boolean z2;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        boolean z3 = rawType == Single.class;
        boolean z4 = rawType == b.class;
        if (rawType != e.class && !z3 && !z4) {
            return null;
        }
        if (z4) {
            return new RxJavaCallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, true);
        }
        if (!(type instanceof ParameterizedType)) {
            String str = z3 ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound2);
        if (rawType2 != Response.class) {
            if (rawType2 != Result.class) {
                parameterUpperBound = parameterUpperBound2;
                z = false;
                z2 = true;
            } else {
                if (!(parameterUpperBound2 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
                parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound2);
                z = true;
            }
            return new RxJavaCallAdapter(parameterUpperBound, this.scheduler, this.isAsync, z, z2, z3, false);
        }
        if (!(parameterUpperBound2 instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound2);
        z = false;
        z2 = false;
        return new RxJavaCallAdapter(parameterUpperBound, this.scheduler, this.isAsync, z, z2, z3, false);
    }
}
