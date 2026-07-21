package cm.aptoide.pt.view.rx;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.themes.ThemeManager;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class RxAlertDialog implements DialogInterface {
    private final CancelEvent cancelEvent;
    private final androidx.appcompat.app.c dialog;
    private final DismissEvent dismissEvent;
    private final DialogClick negativeClick;
    private final DialogClick positiveClick;
    private final View view;

    public static class Builder {
        private final androidx.appcompat.app.c.a builder;
        private DialogClick negativeClick;
        private DialogClick positiveClick;
        private View view;

        public Builder(Context context, ThemeManager themeManager) {
            this.builder = new androidx.appcompat.app.c.a(new ContextThemeWrapper(context, themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId));
        }

        public RxAlertDialog build() {
            androidx.appcompat.app.c cVarA = this.builder.a();
            CancelEvent cancelEvent = new CancelEvent(e.g.b.c.f1());
            DismissEvent dismissEvent = new DismissEvent(e.g.b.c.f1());
            cVarA.setOnCancelListener(cancelEvent);
            cVarA.setOnDismissListener(dismissEvent);
            return new RxAlertDialog(cVarA, this.view, this.positiveClick, this.negativeClick, cancelEvent, dismissEvent);
        }

        public Builder setMessage(int i2) {
            this.builder.i(i2);
            return this;
        }

        public Builder setNegativeButton(int i2) {
            DialogClick dialogClick = new DialogClick(-2, e.g.b.c.f1());
            this.negativeClick = dialogClick;
            this.builder.l(i2, dialogClick);
            return this;
        }

        public Builder setPositiveButton(int i2) {
            DialogClick dialogClick = new DialogClick(-1, e.g.b.c.f1());
            this.positiveClick = dialogClick;
            this.builder.q(i2, dialogClick);
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i2) {
            this.builder.t(charSequenceArr, i2, null);
            return this;
        }

        public Builder setTitle(int i2) {
            this.builder.u(i2);
            return this;
        }

        public Builder setTitleSmall(int i2) {
            TextView textView = new TextView(this.builder.b());
            textView.setTextSize(12.0f);
            textView.setTextColor(textView.getResources().getColor(R.color.secondary_text_color));
            textView.setText(i2);
            textView.setPaddingRelative((int) ((textView.getResources().getDisplayMetrics().density * 25.0f) + 0.5f), (int) ((textView.getResources().getDisplayMetrics().density * 20.0f) + 0.5f), 0, (int) ((textView.getResources().getDisplayMetrics().density * 10.0f) + 0.5f));
            this.builder.e(textView);
            return this;
        }

        public Builder setView(View view) {
            this.view = view;
            this.builder.w(view);
            return this;
        }
    }

    protected static class CancelEvent implements DialogInterface.OnCancelListener {
        private final e.g.b.c<Void> subject;

        public CancelEvent(e.g.b.c<Void> cVar) {
            this.subject = cVar;
        }

        public rx.e<Void> cancels() {
            return this.subject;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.subject.call(null);
        }
    }

    protected static class DialogClick implements DialogInterface.OnClickListener {
        private final e.g.b.c<Void> subject;
        private final int which;

        public DialogClick(int i2, e.g.b.c<Void> cVar) {
            this.which = i2;
            this.subject = cVar;
        }

        public rx.e<Void> clicks() {
            return this.subject;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.which == i2) {
                this.subject.call(null);
            }
        }
    }

    protected static class DismissEvent implements DialogInterface.OnDismissListener {
        private final e.g.b.c<Void> subject;

        public DismissEvent(e.g.b.c<Void> cVar) {
            this.subject = cVar;
        }

        public rx.e<Void> dismisses() {
            return this.subject;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.subject.call(null);
        }
    }

    public enum Result {
        CANCEL,
        DISMISS,
        POSITIVE,
        NEGATIVE
    }

    protected RxAlertDialog(androidx.appcompat.app.c cVar, View view, DialogClick dialogClick, DialogClick dialogClick2, CancelEvent cancelEvent, DismissEvent dismissEvent) {
        this.dialog = cVar;
        this.view = view;
        this.positiveClick = dialogClick;
        this.negativeClick = dialogClick2;
        this.cancelEvent = cancelEvent;
        this.dismissEvent = dismissEvent;
    }

    private /* synthetic */ DialogInterface lambda$cancels$2(Void r1) {
        return this;
    }

    private /* synthetic */ DialogInterface lambda$dismisses$3(Void r1) {
        return this;
    }

    private /* synthetic */ DialogInterface lambda$negativeClicks$1(Void r1) {
        return this;
    }

    private /* synthetic */ DialogInterface lambda$positiveClicks$0(Void r1) {
        return this;
    }

    public /* synthetic */ DialogInterface a(Void r1) {
        lambda$cancels$2(r1);
        return this;
    }

    public /* synthetic */ DialogInterface b(Void r1) {
        lambda$dismisses$3(r1);
        return this;
    }

    public /* synthetic */ DialogInterface c(Void r1) {
        lambda$negativeClicks$1(r1);
        return this;
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        this.dialog.cancel();
    }

    public rx.e<DialogInterface> cancels() {
        return this.cancelEvent.cancels().X(new rx.m.e() { // from class: cm.aptoide.pt.view.rx.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                RxAlertDialog rxAlertDialog = this.f8129f;
                rxAlertDialog.a((Void) obj);
                return rxAlertDialog;
            }
        });
    }

    public /* synthetic */ DialogInterface d(Void r1) {
        lambda$positiveClicks$0(r1);
        return this;
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        this.dialog.dismiss();
    }

    public rx.e<DialogInterface> dismisses() {
        return this.dismissEvent.dismisses().X(new rx.m.e() { // from class: cm.aptoide.pt.view.rx.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                RxAlertDialog rxAlertDialog = this.f8134f;
                rxAlertDialog.b((Void) obj);
                return rxAlertDialog;
            }
        });
    }

    public int getCheckedItem() {
        return this.dialog.f().getCheckedItemPosition();
    }

    public View getDialogView() {
        return this.view;
    }

    public boolean isShowing() {
        return this.dialog.isShowing();
    }

    public rx.e<DialogInterface> negativeClicks() {
        DialogClick dialogClick = this.negativeClick;
        return dialogClick != null ? dialogClick.clicks().X(new rx.m.e() { // from class: cm.aptoide.pt.view.rx.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                RxAlertDialog rxAlertDialog = this.f8128f;
                rxAlertDialog.c((Void) obj);
                return rxAlertDialog;
            }
        }) : rx.e.B();
    }

    public rx.e<DialogInterface> positiveClicks() {
        DialogClick dialogClick = this.positiveClick;
        return dialogClick != null ? dialogClick.clicks().X(new rx.m.e() { // from class: cm.aptoide.pt.view.rx.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                RxAlertDialog rxAlertDialog = this.f8133f;
                rxAlertDialog.d((Void) obj);
                return rxAlertDialog;
            }
        }) : rx.e.B();
    }

    public void show() {
        this.dialog.show();
    }

    public Single<Result> showWithResult() {
        final androidx.appcompat.app.c cVar = this.dialog;
        cVar.getClass();
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.view.rx.i
            @Override // rx.m.a
            public final void call() {
                cVar.show();
            }
        }).b(rx.e.c0(this.cancelEvent.cancels().X(new rx.m.e() { // from class: cm.aptoide.pt.view.rx.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RxAlertDialog.Result.CANCEL;
            }
        }), this.dismissEvent.dismisses().X(new rx.m.e() { // from class: cm.aptoide.pt.view.rx.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RxAlertDialog.Result.DISMISS;
            }
        }), this.positiveClick.clicks().X(new rx.m.e() { // from class: cm.aptoide.pt.view.rx.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RxAlertDialog.Result.POSITIVE;
            }
        }), this.negativeClick.clicks().X(new rx.m.e() { // from class: cm.aptoide.pt.view.rx.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RxAlertDialog.Result.NEGATIVE;
            }
        }))).E().Z0();
    }
}
