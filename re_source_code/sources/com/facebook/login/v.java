package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: LoginFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bC\u0010\u000eJ#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u000eJ-\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u000eJ\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u000eJ)\u0010)\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0013H\u0016¢\u0006\u0004\b,\u0010\u0016J\u000f\u0010-\u001a\u00020\u0006H\u0014¢\u0006\u0004\b-\u0010\u000eJ\u000f\u0010.\u001a\u00020\u0006H\u0014¢\u0006\u0004\b.\u0010\u000eR$\u00102\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00178\u0006@BX\u0086.¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b0\u0010\u0019R0\u00107\u001a\b\u0012\u0004\u0012\u00020'032\f\u0010/\u001a\b\u0012\u0004\u0012\u00020'038\u0006@BX\u0086.¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010<R\u0016\u0010?\u001a\u00020$8U@\u0014X\u0094\u0004¢\u0006\u0006\u001a\u0004\b9\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010A¨\u0006E"}, d2 = {"Lcom/facebook/login/v;", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/d;", "activity", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "Lkotlin/u;", "j", "(Landroidx/fragment/app/d;)Lkotlin/a0/c/l;", "Lcom/facebook/login/LoginClient$Result;", "outcome", "q", "(Lcom/facebook/login/LoginClient$Result;)V", "t", "()V", "k", "Landroid/app/Activity;", "l", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/facebook/login/LoginClient;", "f", "()Lcom/facebook/login/LoginClient;", "onDestroy", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "onPause", HttpUrl.FRAGMENT_ENCODE_SET, "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "s", "r", "<set-?>", "i", "Lcom/facebook/login/LoginClient;", "loginClient", "Landroidx/activity/result/b;", "Landroidx/activity/result/b;", "g", "()Landroidx/activity/result/b;", "launcher", "Lcom/facebook/login/LoginClient$Request;", "h", "Lcom/facebook/login/LoginClient$Request;", "request", "Landroid/view/View;", "progressBar", "()I", "layoutResId", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/String;", "callingPackage", "<init>", "a", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class v extends Fragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String callingPackage;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LoginClient.Request request;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LoginClient loginClient;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private androidx.activity.result.b<Intent> launcher;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private View progressBar;

    /* JADX INFO: compiled from: LoginFragment.kt */
    static final class b extends Lambda implements Function1<ActivityResult, kotlin.u> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ androidx.fragment.app.d f10046g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.fragment.app.d dVar) {
            super(1);
            this.f10046g = dVar;
        }

        public final void b(ActivityResult activityResult) {
            kotlin.jvm.internal.m.f(activityResult, "result");
            if (activityResult.b() == -1) {
                v.this.i().u(LoginClient.f9960f.b(), activityResult.b(), activityResult.a());
            } else {
                this.f10046g.finish();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.u invoke(ActivityResult activityResult) {
            b(activityResult);
            return kotlin.u.a;
        }
    }

    /* JADX INFO: compiled from: LoginFragment.kt */
    public static final class c implements LoginClient.a {
        c() {
        }

        @Override // com.facebook.login.LoginClient.a
        public void a() {
            v.this.t();
        }

        @Override // com.facebook.login.LoginClient.a
        public void b() {
            v.this.k();
        }
    }

    private final Function1<ActivityResult, kotlin.u> j(androidx.fragment.app.d activity) {
        return new b(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        View view = this.progressBar;
        if (view == null) {
            kotlin.jvm.internal.m.w("progressBar");
            throw null;
        }
        view.setVisibility(8);
        r();
    }

    private final void l(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            return;
        }
        this.callingPackage = callingActivity.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(v vVar, LoginClient.Result result) {
        kotlin.jvm.internal.m.f(vVar, "this$0");
        kotlin.jvm.internal.m.f(result, "outcome");
        vVar.q(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 function1, ActivityResult activityResult) {
        kotlin.jvm.internal.m.f(function1, "$tmp0");
        function1.invoke(activityResult);
    }

    private final void q(LoginClient.Result outcome) {
        this.request = null;
        int i2 = outcome.f9973g == LoginClient.Result.a.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", outcome);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        androidx.fragment.app.d activity = getActivity();
        if (!isAdded() || activity == null) {
            return;
        }
        activity.setResult(i2, intent);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        View view = this.progressBar;
        if (view == null) {
            kotlin.jvm.internal.m.w("progressBar");
            throw null;
        }
        view.setVisibility(0);
        s();
    }

    protected LoginClient f() {
        return new LoginClient(this);
    }

    public final androidx.activity.result.b<Intent> g() {
        androidx.activity.result.b<Intent> bVar = this.launcher;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.m.w("launcher");
        throw null;
    }

    protected int h() {
        return com.facebook.common.c.f9679c;
    }

    public final LoginClient i() {
        LoginClient loginClient = this.loginClient;
        if (loginClient != null) {
            return loginClient;
        }
        kotlin.jvm.internal.m.w("loginClient");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        i().u(requestCode, resultCode, data);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundleExtra;
        super.onCreate(savedInstanceState);
        LoginClient loginClientF = savedInstanceState == null ? null : (LoginClient) savedInstanceState.getParcelable("loginClient");
        if (loginClientF != null) {
            loginClientF.w(this);
        } else {
            loginClientF = f();
        }
        this.loginClient = loginClientF;
        i().x(new LoginClient.d() { // from class: com.facebook.login.j
            @Override // com.facebook.login.LoginClient.d
            public final void a(LoginClient.Result result) {
                v.o(this.a, result);
            }
        });
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            return;
        }
        l(activity);
        Intent intent = activity.getIntent();
        if (intent != null && (bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request")) != null) {
            this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
        }
        androidx.activity.result.d.c cVar = new androidx.activity.result.d.c();
        final Function1<ActivityResult, kotlin.u> function1J = j(activity);
        androidx.activity.result.b<Intent> bVarRegisterForActivityResult = registerForActivityResult(cVar, new androidx.activity.result.a() { // from class: com.facebook.login.k
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                v.p(function1J, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.m.e(bVarRegisterForActivityResult, "registerForActivityResult(\n            ActivityResultContracts.StartActivityForResult(),\n            getLoginMethodHandlerCallback(activity))");
        this.launcher = bVarRegisterForActivityResult;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        View viewInflate = inflater.inflate(h(), container, false);
        View viewFindViewById = viewInflate.findViewById(com.facebook.common.b.f9675d);
        kotlin.jvm.internal.m.e(viewFindViewById, "view.findViewById<View>(R.id.com_facebook_login_fragment_progress_bar)");
        this.progressBar = viewFindViewById;
        i().v(new c());
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        i().c();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = getView();
        View viewFindViewById = view == null ? null : view.findViewById(com.facebook.common.b.f9675d);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.callingPackage != null) {
            i().y(this.request);
            return;
        }
        Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.m.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelable("loginClient", i());
    }

    protected void r() {
    }

    protected void s() {
    }
}
