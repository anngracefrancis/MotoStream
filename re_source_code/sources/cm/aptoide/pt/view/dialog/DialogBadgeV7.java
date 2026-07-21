package cm.aptoide.pt.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.Malware;
import cm.aptoide.pt.view.fragment.BaseDialogFragment;

/* JADX INFO: loaded from: classes.dex */
public class DialogBadgeV7 extends BaseDialogFragment {
    protected String appName;
    protected Malware malware;
    protected String marketName;
    protected Malware.Rank rank;

    /* JADX INFO: renamed from: cm.aptoide.pt.view.dialog.DialogBadgeV7$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Reason$Status;

        static {
            int[] iArr = new int[Malware.Reason.Status.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Reason$Status = iArr;
            try {
                iArr[Malware.Reason.Status.passed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Reason$Status[Malware.Reason.Status.failed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Reason$Status[Malware.Reason.Status.blacklisted.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Malware.Rank.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank = iArr2;
            try {
                iArr2[Malware.Rank.TRUSTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Malware.Rank.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[Malware.Rank.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateDialog$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        dismiss();
    }

    public static DialogBadgeV7 newInstance(String str, Malware malware, String str2, Malware.Rank rank) {
        DialogBadgeV7 dialogBadgeV7 = new DialogBadgeV7();
        dialogBadgeV7.malware = malware;
        dialogBadgeV7.appName = str2;
        dialogBadgeV7.rank = rank;
        dialogBadgeV7.marketName = str;
        return dialogBadgeV7;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, com.trello.rxlifecycle.h.a.c, androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_dialog_badge, (ViewGroup) null);
        androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(new ContextThemeWrapper(getContext(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId)).w(viewInflate).a();
        viewInflate.findViewById(R.id.dialog_ok_button).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.view.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f8011f.d(view);
            }
        });
        Malware malware = this.malware;
        if (malware != null && malware.getRank() != null) {
            int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Rank[this.malware.getRank().ordinal()];
            if (i2 == 1) {
                viewInflate.findViewById(R.id.trusted_header_layout).setVisibility(0);
            } else if (i2 == 2) {
                viewInflate.findViewById(R.id.warning_header_layout).setVisibility(0);
            } else if (i2 == 3) {
                viewInflate.findViewById(R.id.unknown_header_layout).setVisibility(0);
                viewInflate.findViewById(R.id.tr_unknown).setVisibility(0);
                return cVarA;
            }
        }
        Malware malware2 = this.malware;
        if (malware2 != null && malware2.getReason() != null) {
            if (this.malware.getReason().getScanned() != null && this.malware.getReason().getScanned().getStatus() != null && ((Malware.Reason.Status.passed.equals(this.malware.getReason().getScanned().getStatus()) || Malware.Reason.Status.warn.equals(this.malware.getReason().getScanned().getStatus())) && this.malware.getReason().getScanned().getAvInfo() != null)) {
                viewInflate.findViewById(R.id.tr_scanned).setVisibility(0);
                ((TextView) viewInflate.findViewById(R.id.message_virus_no)).setText(getString(R.string.appviewbadge_message_virus_no));
            }
            if (this.malware.getReason().getThirdpartyValidated() != null && Malware.GOOGLE_PLAY.equalsIgnoreCase(this.malware.getReason().getThirdpartyValidated().getStore())) {
                viewInflate.findViewById(R.id.tr_third_party).setVisibility(0);
            }
            if (this.malware.getReason().getSignatureValidated() != null && this.malware.getReason().getSignatureValidated().getStatus() != null) {
                int i3 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Malware$Reason$Status[this.malware.getReason().getSignatureValidated().getStatus().ordinal()];
                if (i3 == 1) {
                    viewInflate.findViewById(R.id.tr_signature).setVisibility(0);
                    ((TextView) viewInflate.findViewById(R.id.tv_reason_signature_validation)).setText(getString(R.string.appviewbadge_message_signature_matches));
                } else if (i3 == 2) {
                    viewInflate.findViewById(R.id.tr_signature).setVisibility(0);
                    viewInflate.findViewById(R.id.iv_signature).setVisibility(4);
                    ((TextView) viewInflate.findViewById(R.id.tv_reason_signature_validation)).setText(getString(R.string.appviewbadge_message_signature_different));
                }
            }
            if (this.malware.getReason().getManual() != null && this.malware.getReason().getManual().getStatus() != null && Malware.Reason.Status.passed.equals(this.malware.getReason().getManual().getStatus())) {
                viewInflate.findViewById(R.id.tr_manual).setVisibility(0);
                ((TextView) viewInflate.findViewById(R.id.message_virus_no_manual)).setText(getString(R.string.appviewbadge_message_virus_no));
            }
        }
        return cVarA;
    }
}
