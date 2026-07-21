package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.p0;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: GraphRequestAsyncTask.kt */
/* JADX INFO: loaded from: classes.dex */
public class b0 extends AsyncTask<Void, Void, List<? extends d0>> {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9654b = b0.class.getCanonicalName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HttpURLConnection f9655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c0 f9656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Exception f9657e;

    /* JADX INFO: compiled from: GraphRequestAsyncTask.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public b0(HttpURLConnection httpURLConnection, c0 c0Var) {
        kotlin.jvm.internal.m.f(c0Var, "requests");
        this.f9655c = httpURLConnection;
        this.f9656d = c0Var;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<d0> doInBackground(Void... voidArr) {
        kotlin.jvm.internal.m.f(voidArr, "params");
        try {
            HttpURLConnection httpURLConnection = this.f9655c;
            return httpURLConnection == null ? this.f9656d.i() : GraphRequest.a.m(httpURLConnection, this.f9656d);
        } catch (Exception e2) {
            this.f9657e = e2;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<d0> list) {
        kotlin.jvm.internal.m.f(list, "result");
        super.onPostExecute(list);
        Exception exc = this.f9657e;
        if (exc != null) {
            p0 p0Var = p0.a;
            String str = f9654b;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str2 = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
            kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
            p0.j0(str, str2);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        a0 a0Var = a0.a;
        if (a0.u()) {
            p0 p0Var = p0.a;
            String str = f9654b;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str2 = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
            kotlin.jvm.internal.m.e(str2, "java.lang.String.format(format, *args)");
            p0.j0(str, str2);
        }
        if (this.f9656d.t() == null) {
            this.f9656d.G(Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper()));
        }
    }

    public String toString() {
        String str = "{RequestAsyncTask:  connection: " + this.f9655c + ", requests: " + this.f9656d + "}";
        kotlin.jvm.internal.m.e(str, "StringBuilder()\n        .append(\"{RequestAsyncTask: \")\n        .append(\" connection: \")\n        .append(connection)\n        .append(\", requests: \")\n        .append(requests)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(c0 c0Var) {
        this(null, c0Var);
        kotlin.jvm.internal.m.f(c0Var, "requests");
    }
}
