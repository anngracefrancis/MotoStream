package cm.aptoide.pt.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class GenericDialogs {

    public enum EResponse {
        YES,
        NO,
        CANCEL
    }

    public static rx.e<EResponse> createGenericContinueCancelMessage(final Context context, final String str, final String str2, final int i2) {
        return rx.e.l(new rx.e.a() { // from class: cm.aptoide.pt.utils.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                GenericDialogs.lambda$createGenericContinueCancelMessage$20(context, i2, str, str2, (rx.j) obj);
            }
        });
    }

    public static rx.e<EResponse> createGenericContinueMessage(final Context context, final View view, final String str, final String str2, final int i2, final int i3) {
        return rx.e.l(new rx.e.a() { // from class: cm.aptoide.pt.utils.p
            @Override // rx.m.b
            public final void call(Object obj) {
                GenericDialogs.lambda$createGenericContinueMessage$15(context, i3, str, str2, i2, view, (rx.j) obj);
            }
        });
    }

    public static rx.e<EResponse> createGenericOkCancelMessage(final Context context, final String str, final String str2, final int i2) {
        return rx.e.l(new rx.e.a() { // from class: cm.aptoide.pt.utils.y
            @Override // rx.m.b
            public final void call(Object obj) {
                GenericDialogs.lambda$createGenericOkCancelMessage$8(context, i2, str, str2, (rx.j) obj);
            }
        });
    }

    public static rx.e<EResponse> createGenericOkCancelMessageWithColorButton(final Context context, final String str, final String str2, final String str3, final String str4) {
        return rx.e.l(new rx.e.a() { // from class: cm.aptoide.pt.utils.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                GenericDialogs.lambda$createGenericOkCancelMessageWithColorButton$12(context, str, str2, str3, str4, (rx.j) obj);
            }
        });
    }

    public static rx.e<EResponse> createGenericOkMessage(Context context, String str, String str2, int i2) {
        return createGenericContinueMessage(context, null, str, str2, android.R.string.ok, i2);
    }

    public static ProgressDialog createGenericPleaseWaitDialog(Context context, int i2) {
        ProgressDialog progressDialog = new ProgressDialog(new ContextThemeWrapper(context, i2));
        progressDialog.setMessage(context.getString(R.string.please_wait));
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    public static rx.e<EResponse> createGenericYesNoCancelMessage(final Context context, final String str, final String str2, final int i2) {
        return rx.e.l(new rx.e.a() { // from class: cm.aptoide.pt.utils.l
            @Override // rx.m.b
            public final void call(Object obj) {
                GenericDialogs.lambda$createGenericYesNoCancelMessage$4(context, i2, str, str2, (rx.j) obj);
            }
        }).I0(rx.l.c.a.b());
    }

    static /* synthetic */ void lambda$createGenericContinueCancelMessage$16(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.YES);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericContinueCancelMessage$17(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.NO);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericContinueCancelMessage$18(rx.j jVar, DialogInterface dialogInterface) {
        jVar.onNext(EResponse.CANCEL);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericContinueCancelMessage$20(Context context, int i2, String str, String str2, final rx.j jVar) {
        final androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(new ContextThemeWrapper(context, i2)).v(str).j(str2).q(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GenericDialogs.lambda$createGenericContinueCancelMessage$16(jVar, dialogInterface, i3);
            }
        }).l(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GenericDialogs.lambda$createGenericContinueCancelMessage$17(jVar, dialogInterface, i3);
            }
        }).o(new DialogInterface.OnCancelListener() { // from class: cm.aptoide.pt.utils.n
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GenericDialogs.lambda$createGenericContinueCancelMessage$18(jVar, dialogInterface);
            }
        }).a();
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.utils.h0
            @Override // rx.m.a
            public final void call() {
                cVarA.dismiss();
            }
        }));
        cVarA.show();
    }

    static /* synthetic */ void lambda$createGenericContinueMessage$13(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.YES);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericContinueMessage$15(Context context, int i2, String str, String str2, int i3, View view, final rx.j jVar) {
        androidx.appcompat.app.c.a aVarQ = new androidx.appcompat.app.c.a(new ContextThemeWrapper(context, i2)).v(str).j(str2).q(i3, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                GenericDialogs.lambda$createGenericContinueMessage$13(jVar, dialogInterface, i4);
            }
        });
        if (view != null) {
            aVarQ.w(view);
        }
        final androidx.appcompat.app.c cVarA = aVarQ.a();
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.utils.d0
            @Override // rx.m.a
            public final void call() {
                cVarA.dismiss();
            }
        }));
        cVarA.show();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessage$21(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.YES);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessage$22(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.NO);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessage$23(rx.j jVar, DialogInterface dialogInterface) {
        jVar.onNext(EResponse.CANCEL);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessage$25(Context context, int i2, String str, int i3, int i4, int i5, final rx.j jVar) {
        final androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(new ContextThemeWrapper(context, i2)).v(str).i(i3).q(i4, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                GenericDialogs.lambda$createGenericOkCancelMessage$21(jVar, dialogInterface, i6);
            }
        }).l(i5, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.f0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                GenericDialogs.lambda$createGenericOkCancelMessage$22(jVar, dialogInterface, i6);
            }
        }).o(new DialogInterface.OnCancelListener() { // from class: cm.aptoide.pt.utils.i0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GenericDialogs.lambda$createGenericOkCancelMessage$23(jVar, dialogInterface);
            }
        }).a();
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.utils.u
            @Override // rx.m.a
            public final void call() {
                cVarA.dismiss();
            }
        }));
        cVarA.show();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessage$5(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.YES);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessage$6(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.CANCEL);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessage$8(Context context, int i2, String str, String str2, final rx.j jVar) {
        final androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(new ContextThemeWrapper(context, i2)).v(str).j(str2).q(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GenericDialogs.lambda$createGenericOkCancelMessage$5(jVar, dialogInterface, i3);
            }
        }).l(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GenericDialogs.lambda$createGenericOkCancelMessage$6(jVar, dialogInterface, i3);
            }
        }).a();
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.utils.a0
            @Override // rx.m.a
            public final void call() {
                cVarA.dismiss();
            }
        }));
        cVarA.show();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessageWithColorButton$10(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.CANCEL);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessageWithColorButton$12(Context context, String str, String str2, String str3, String str4, final rx.j jVar) {
        final androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(context).v(str).j(str2).r(str3, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.e0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                GenericDialogs.lambda$createGenericOkCancelMessageWithColorButton$9(jVar, dialogInterface, i2);
            }
        }).m(str4, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                GenericDialogs.lambda$createGenericOkCancelMessageWithColorButton$10(jVar, dialogInterface, i2);
            }
        }).a();
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.utils.g0
            @Override // rx.m.a
            public final void call() {
                cVarA.dismiss();
            }
        }));
        cVarA.show();
        cVarA.e(-2).setTextColor(-7829368);
    }

    static /* synthetic */ void lambda$createGenericOkCancelMessageWithColorButton$9(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.YES);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericYesNoCancelMessage$0(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.YES);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericYesNoCancelMessage$1(rx.j jVar, DialogInterface dialogInterface, int i2) {
        jVar.onNext(EResponse.NO);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericYesNoCancelMessage$2(rx.j jVar, DialogInterface dialogInterface) {
        jVar.onNext(EResponse.CANCEL);
        jVar.onCompleted();
    }

    static /* synthetic */ void lambda$createGenericYesNoCancelMessage$4(Context context, int i2, String str, String str2, final rx.j jVar) {
        final androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(new ContextThemeWrapper(context, i2)).v(str).j(str2).q(android.R.string.yes, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GenericDialogs.lambda$createGenericYesNoCancelMessage$0(jVar, dialogInterface, i3);
            }
        }).l(android.R.string.no, new DialogInterface.OnClickListener() { // from class: cm.aptoide.pt.utils.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GenericDialogs.lambda$createGenericYesNoCancelMessage$1(jVar, dialogInterface, i3);
            }
        }).o(new DialogInterface.OnCancelListener() { // from class: cm.aptoide.pt.utils.k0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GenericDialogs.lambda$createGenericYesNoCancelMessage$2(jVar, dialogInterface);
            }
        }).a();
        jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.utils.s
            @Override // rx.m.a
            public final void call() {
                cVarA.dismiss();
            }
        }));
        cVarA.show();
    }

    public static rx.e<EResponse> createGenericOkCancelMessage(final Context context, final String str, final int i2, final int i3, final int i4, final int i5) {
        return rx.e.l(new rx.e.a() { // from class: cm.aptoide.pt.utils.b0
            @Override // rx.m.b
            public final void call(Object obj) {
                GenericDialogs.lambda$createGenericOkCancelMessage$25(context, i5, str, i2, i3, i4, (rx.j) obj);
            }
        });
    }

    public static ProgressDialog createGenericPleaseWaitDialog(Context context, int i2, String str) {
        ProgressDialog progressDialog = new ProgressDialog(new ContextThemeWrapper(context, i2));
        progressDialog.setMessage(str);
        progressDialog.setCancelable(false);
        return progressDialog;
    }
}
