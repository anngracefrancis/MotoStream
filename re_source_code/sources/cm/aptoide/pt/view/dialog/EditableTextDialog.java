package cm.aptoide.pt.view.dialog;

import android.content.DialogInterface;
import android.widget.EditText;
import cm.aptoide.pt.view.rx.RxAlertDialog;

/* JADX INFO: loaded from: classes.dex */
public class EditableTextDialog implements DialogInterface {
    private final RxAlertDialog dialog;
    private final EditText editText;

    public EditableTextDialog(RxAlertDialog rxAlertDialog, EditText editText) {
        this.dialog = rxAlertDialog;
        this.editText = editText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$positiveClicks$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ CharSequence a(DialogInterface dialogInterface) {
        return this.editText.getText();
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        this.dialog.cancel();
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        this.dialog.dismiss();
    }

    public rx.e<DialogInterface> negativeClicks() {
        return this.dialog.negativeClicks();
    }

    public rx.e<CharSequence> positiveClicks() {
        return this.dialog.positiveClicks().X(new rx.m.e() { // from class: cm.aptoide.pt.view.dialog.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8042f.a((DialogInterface) obj);
            }
        });
    }

    protected void setText(String str) {
        this.editText.setText(str);
    }

    public void show() {
        this.dialog.show();
    }
}
