package cm.aptoide.pt.permission;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.permissions.ApkPermissionGroup;
import cm.aptoide.pt.util.AppUtils;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.fragment.BaseDialogFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DialogPermissions extends BaseDialogFragment {
    private String appName;
    private String icon;
    private String size;
    private List<String> usedPermissions;
    private String versionName;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateDialog$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        dismiss();
    }

    public static DialogPermissions newInstance(String str, String str2, String str3, String str4, List<String> list) {
        DialogPermissions dialogPermissions = new DialogPermissions();
        dialogPermissions.appName = str;
        dialogPermissions.versionName = str2;
        dialogPermissions.icon = str3;
        dialogPermissions.size = str4;
        dialogPermissions.usedPermissions = list;
        return dialogPermissions;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseDialogFragment, androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.layout_dialog_permissions, (ViewGroup) null);
        androidx.appcompat.app.c cVarA = new androidx.appcompat.app.c.a(new ContextThemeWrapper(getContext(), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId)).w(viewInflate).a();
        viewInflate.findViewById(R.id.dialog_ok_button).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.permission.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6832f.d(view);
            }
        });
        ((TextView) viewInflate.findViewById(R.id.dialog_app_info)).setText(getString(R.string.dialog_version_size, this.versionName, this.size));
        ((TextView) viewInflate.findViewById(R.id.dialog_app_name)).setText(this.appName);
        com.bumptech.glide.c.u(this).k(this.icon).D0((ImageView) viewInflate.findViewById(R.id.dialog_appview_icon));
        TableLayout tableLayout = (TableLayout) viewInflate.findViewById(R.id.dialog_table_permissions);
        ArrayList<ApkPermissionGroup> arrayListFillPermissionsGroups = AppUtils.fillPermissionsGroups(AptoideUtils.SystemU.parsePermissions(getContext(), this.usedPermissions));
        if (arrayListFillPermissionsGroups.size() == 0) {
            TextView textView = new TextView(getContext());
            textView.setText(getString(R.string.no_permissions_required));
            textView.setPadding(5, 5, 5, 5);
        } else {
            AppUtils.fillPermissionsForTableLayout(getContext(), tableLayout, arrayListFillPermissionsGroups);
        }
        return cVarA;
    }

    @Override // com.trello.rxlifecycle.h.a.c, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }
}
