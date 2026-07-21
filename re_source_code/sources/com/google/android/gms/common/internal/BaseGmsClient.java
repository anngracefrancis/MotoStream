package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface> {

    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;

    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;

    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";

    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private ConnectionResult zzB;
    private boolean zzC;
    private volatile zzj zzD;

    @VisibleForTesting
    zzu zza;
    final Handler zzb;

    @VisibleForTesting
    protected ConnectionProgressReportCallbacks zzc;

    @VisibleForTesting
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private zze zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;
    private static final Feature[] zze = new Feature[0];

    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        void H(int i2);

        @KeepForSdk
        void P(Bundle bundle);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void E0(ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void a(ConnectionResult connectionResult);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void a(ConnectionResult connectionResult) {
            if (connectionResult.e0()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.E0(connectionResult);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public interface SignOutCallbacks {
        @KeepForSdk
        void a();
    }

    @VisibleForTesting
    @KeepForSdk
    protected BaseGmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i2, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.l(context, "Context must not be null");
        this.zzl = context;
        Preconditions.l(handler, "Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        Preconditions.l(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.l(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzy = i2;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = null;
    }

    static /* bridge */ /* synthetic */ void zzj(BaseGmsClient baseGmsClient, zzj zzjVar) {
        baseGmsClient.zzD = zzjVar;
        if (baseGmsClient.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.f12068i;
            RootTelemetryConfigManager.a().b(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.i0());
        }
    }

    static /* bridge */ /* synthetic */ void zzk(BaseGmsClient baseGmsClient, int i2) {
        int i3;
        int i4;
        synchronized (baseGmsClient.zzp) {
            i3 = baseGmsClient.zzv;
        }
        if (i3 == 3) {
            baseGmsClient.zzC = true;
            i4 = 5;
        } else {
            i4 = 4;
        }
        Handler handler = baseGmsClient.zzb;
        handler.sendMessage(handler.obtainMessage(i4, baseGmsClient.zzd.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean zzn(BaseGmsClient baseGmsClient, int i2, int i3, IInterface iInterface) {
        synchronized (baseGmsClient.zzp) {
            if (baseGmsClient.zzv != i2) {
                return false;
            }
            baseGmsClient.zzp(i3, iInterface);
            return true;
        }
    }

    static /* bridge */ /* synthetic */ boolean zzo(BaseGmsClient baseGmsClient) {
        if (baseGmsClient.zzC || TextUtils.isEmpty(baseGmsClient.getServiceDescriptor()) || TextUtils.isEmpty(baseGmsClient.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(baseGmsClient.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzp(int i2, IInterface iInterface) {
        zzu zzuVar;
        Preconditions.a((i2 == 4) == (iInterface != null));
        synchronized (this.zzp) {
            this.zzv = i2;
            this.zzs = iInterface;
            if (i2 == 1) {
                zze zzeVar = this.zzu;
                if (zzeVar != null) {
                    GmsClientSupervisor gmsClientSupervisor = this.zzn;
                    String strC = this.zza.c();
                    Preconditions.k(strC);
                    gmsClientSupervisor.e(strC, this.zza.b(), this.zza.a(), zzeVar, zze(), this.zza.d());
                    this.zzu = null;
                }
            } else if (i2 == 2 || i2 == 3) {
                zze zzeVar2 = this.zzu;
                if (zzeVar2 != null && (zzuVar = this.zza) != null) {
                    Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzuVar.c() + " on " + zzuVar.b());
                    GmsClientSupervisor gmsClientSupervisor2 = this.zzn;
                    String strC2 = this.zza.c();
                    Preconditions.k(strC2);
                    gmsClientSupervisor2.e(strC2, this.zza.b(), this.zza.a(), zzeVar2, zze(), this.zza.d());
                    this.zzd.incrementAndGet();
                }
                zze zzeVar3 = new zze(this, this.zzd.get());
                this.zzu = zzeVar3;
                zzu zzuVar2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new zzu(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.a(), getUseDynamicLookup()) : new zzu(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.a(), false);
                this.zza = zzuVar2;
                if (zzuVar2.d() && getMinApkVersion() < 17895000) {
                    throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.c())));
                }
                GmsClientSupervisor gmsClientSupervisor3 = this.zzn;
                String strC3 = this.zza.c();
                Preconditions.k(strC3);
                if (!gmsClientSupervisor3.f(new zzn(strC3, this.zza.b(), this.zza.a(), this.zza.d()), zzeVar3, zze(), getBindServiceExecutor())) {
                    Log.w("GmsClient", "unable to connect to service: " + this.zza.c() + " on " + this.zza.b());
                    zzl(16, null, this.zzd.get());
                }
            } else if (i2 == 4) {
                Preconditions.k(iInterface);
                onConnectedLocked(iInterface);
            }
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int iJ = this.zzo.j(this.zzl, getMinApkVersion());
        if (iJ == 0) {
            connect(new LegacyClientCallbackAdapter());
        } else {
            zzp(1, null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), iJ, null);
        }
    }

    @KeepForSdk
    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.l(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        zzp(2, null);
    }

    @KeepForSdk
    protected abstract T createServiceInterface(IBinder iBinder);

    @KeepForSdk
    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((zzc) this.zzt.get(i2)).d();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zzp(1, null);
    }

    @KeepForSdk
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i2;
        IInterface iInterface;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzp) {
            i2 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            iGmsServiceBroker = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i2 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i2 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i2 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i2 == 4) {
            printWriter.print("CONNECTED");
        } else if (i2 != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j2 = this.zzh;
            printWriterAppend.println(j2 + " " + simpleDateFormat.format(new Date(j2)));
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i3 = this.zzf;
            if (i3 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i3 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i3 != 3) {
                printWriter.append((CharSequence) String.valueOf(i3));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.zzg;
            printWriterAppend2.println(j3 + " " + simpleDateFormat.format(new Date(j3)));
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.a(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j4 = this.zzj;
            printWriterAppend3.println(j4 + " " + simpleDateFormat.format(new Date(j4)));
        }
    }

    @KeepForSdk
    protected boolean enableLocalFallback() {
        return false;
    }

    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @KeepForSdk
    public Feature[] getApiFeatures() {
        return zze;
    }

    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        zzj zzjVar = this.zzD;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f12066g;
    }

    @KeepForSdk
    protected Executor getBindServiceExecutor() {
        return null;
    }

    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @KeepForSdk
    public final Context getContext() {
        return this.zzl;
    }

    @KeepForSdk
    public String getEndpointPackageName() {
        zzu zzuVar;
        if (!isConnected() || (zzuVar = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zzuVar.b();
    }

    @KeepForSdk
    public int getGCoreServiceId() {
        return this.zzy;
    }

    @KeepForSdk
    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @KeepForSdk
    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    @KeepForSdk
    protected String getLocalStartServiceAction() {
        return null;
    }

    @KeepForSdk
    public final Looper getLooper() {
        return this.zzm;
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.a;
    }

    @KeepForSdk
    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        int i2 = this.zzy;
        String str = this.zzA;
        int i3 = GoogleApiAvailabilityLight.a;
        Scope[] scopeArr = GetServiceRequest.f11970f;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f11971g;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i2, i3, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f11975k = this.zzl.getPackageName();
        getServiceRequest.n = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.m = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            getServiceRequest.o = account;
            if (iAccountAccessor != null) {
                getServiceRequest.l = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.o = getAccount();
        }
        getServiceRequest.p = zze;
        getServiceRequest.q = getApiFeatures();
        if (usesClientTelemetry()) {
            getServiceRequest.t = true;
        }
        try {
            synchronized (this.zzq) {
                IGmsServiceBroker iGmsServiceBroker = this.zzr;
                if (iGmsServiceBroker != null) {
                    iGmsServiceBroker.U1(new zzd(this, this.zzd.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            triggerConnectionSuspended(3);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    @KeepForSdk
    protected Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @KeepForSdk
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            if (this.zzv == 5) {
                throw new DeadObjectException();
            }
            checkConnected();
            t = (T) this.zzs;
            Preconditions.l(t, "Client is connected but service is null");
        }
        return t;
    }

    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            IGmsServiceBroker iGmsServiceBroker = this.zzr;
            if (iGmsServiceBroker == null) {
                return null;
            }
            return iGmsServiceBroker.asBinder();
        }
    }

    @KeepForSdk
    protected abstract String getServiceDescriptor();

    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @KeepForSdk
    protected abstract String getStartServiceAction();

    @KeepForSdk
    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @KeepForSdk
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzj zzjVar = this.zzD;
        if (zzjVar == null) {
            return null;
        }
        return zzjVar.f12068i;
    }

    @KeepForSdk
    protected boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    @KeepForSdk
    public boolean hasConnectionInfo() {
        return this.zzD != null;
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i2 = this.zzv;
            z = true;
            if (i2 != 2 && i2 != 3) {
                z = false;
            }
        }
        return z;
    }

    @KeepForSdk
    protected void onConnectedLocked(T t) {
        this.zzh = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzi = connectionResult.y();
        this.zzj = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void onConnectionSuspended(int i2) {
        this.zzf = i2;
        this.zzg = System.currentTimeMillis();
    }

    @KeepForSdk
    protected void onPostInitHandler(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new zzf(this, i2, iBinder, bundle)));
    }

    @KeepForSdk
    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.a();
    }

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i2) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzd.get(), i2));
    }

    @VisibleForTesting
    @KeepForSdk
    protected void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i2, PendingIntent pendingIntent) {
        Preconditions.l(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(3, this.zzd.get(), i2, pendingIntent));
    }

    @KeepForSdk
    public boolean usesClientTelemetry() {
        return false;
    }

    protected final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    protected final void zzl(int i2, Bundle bundle, int i3) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new zzg(this, i2, null)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    protected BaseGmsClient(Context context, Looper looper, int i2, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        GmsClientSupervisor gmsClientSupervisorB = GmsClientSupervisor.b(context);
        GoogleApiAvailabilityLight googleApiAvailabilityLightH = GoogleApiAvailabilityLight.h();
        Preconditions.k(baseConnectionCallbacks);
        Preconditions.k(baseOnConnectionFailedListener);
        this(context, looper, gmsClientSupervisorB, googleApiAvailabilityLightH, i2, baseConnectionCallbacks, baseOnConnectionFailedListener, str);
    }

    @KeepForSdk
    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }

    @VisibleForTesting
    @KeepForSdk
    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i2, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.l(context, "Context must not be null");
        this.zzl = context;
        Preconditions.l(looper, "Looper must not be null");
        this.zzm = looper;
        Preconditions.l(gmsClientSupervisor, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.l(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new k(this, looper);
        this.zzy = i2;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }
}
