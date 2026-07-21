package cm.aptoide.pt.dataprovider.ws;

import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface BodyInterceptor<T> {
    Single<T> intercept(T t);
}
