package retrofit2;

import j.e0;
import java.io.IOException;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    e0 timeout();
}
