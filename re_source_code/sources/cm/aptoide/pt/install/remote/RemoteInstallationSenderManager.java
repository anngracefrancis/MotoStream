package cm.aptoide.pt.install.remote;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import i.a.a;
import i.a.c;
import i.a.d;
import i.a.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes.dex */
public class RemoteInstallationSenderManager {
    static final int DISCOVERY_TO = 20000;
    static final String INVALID_PAYLOAD_RESPONSE = "INVALIDPAYLOAD";
    static final String PAYLOAD_TAG = "apkinstall_appid=";
    static final String SERVER_TAG_TO_REMOVE = ".local.";
    static final String SERVICE_TYPE = "_aptoide-rmtinst._tcp.local.";
    static final String SUCCESS_TAG = "receivedpayload=";
    static final String TAG = "RemoteInstallationSenderManager";
    static final int TIMEOUT = 10000;
    SocketClientThread clientServerThread;
    Context context;
    Handler handler = new Handler();
    a jmDNS;
    RemoteInstallationSenderListener listener;
    WifiManager.MulticastLock multicastLock;

    /* JADX INFO: renamed from: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WifiManager wifiManager = (WifiManager) RemoteInstallationSenderManager.this.context.getSystemService("wifi");
                RemoteInstallationSenderManager remoteInstallationSenderManager = RemoteInstallationSenderManager.this;
                remoteInstallationSenderManager.multicastLock = wifiManager.createMulticastLock(remoteInstallationSenderManager.context.getClass().getName());
                RemoteInstallationSenderManager.this.multicastLock.setReferenceCounted(true);
                RemoteInstallationSenderManager.this.multicastLock.acquire();
                RemoteInstallationSenderManager remoteInstallationSenderManager2 = RemoteInstallationSenderManager.this;
                remoteInstallationSenderManager2.jmDNS = a.A(remoteInstallationSenderManager2.getAddress(), Build.MODEL);
                RemoteInstallationSenderManager.this.jmDNS.z(RemoteInstallationSenderManager.SERVICE_TYPE, new e() { // from class: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager.1.1
                    @Override // i.a.e
                    public void serviceAdded(c cVar) {
                        Log.i(RemoteInstallationSenderManager.TAG, "Remote Installation - A service has been added: " + cVar.e());
                    }

                    @Override // i.a.e
                    public void serviceRemoved(c cVar) {
                        d dVarE = cVar.e();
                        final Inet4Address inet4Address = dVarE.h()[0];
                        final int iL = dVarE.l();
                        final String strP = dVarE.p();
                        if (strP.contains(RemoteInstallationSenderManager.SERVER_TAG_TO_REMOVE)) {
                            strP = strP.substring(0, strP.length() - 7);
                        }
                        Log.i(RemoteInstallationSenderManager.TAG, "Remote Installation - A service has been removed: " + cVar.e());
                        RemoteInstallationSenderManager.this.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                RemoteInstallationSenderManager.this.listener.onAptoideTVServiceLost(new ReceiverDevice(strP, inet4Address, iL));
                            }
                        });
                    }

                    @Override // i.a.e
                    public void serviceResolved(c cVar) {
                        d dVarE = cVar.e();
                        final Inet4Address inet4Address = dVarE.h()[0];
                        final int iL = dVarE.l();
                        final String strP = dVarE.p();
                        if (strP.contains(RemoteInstallationSenderManager.SERVER_TAG_TO_REMOVE)) {
                            strP = strP.substring(0, strP.length() - 7);
                        }
                        Log.i(RemoteInstallationSenderManager.TAG, "Remote Installation - A service has been resolved: " + cVar.e());
                        RemoteInstallationSenderManager.this.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                RemoteInstallationSenderManager.this.listener.onAptoideTVServiceFound(new ReceiverDevice(strP, inet4Address, iL));
                            }
                        });
                    }
                });
                RemoteInstallationSenderManager.this.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteInstallationSenderManager.this.listener.onDiscoveryStarted();
                    }
                });
            } catch (IOException e2) {
                RemoteInstallationSenderManager.this.runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        RemoteInstallationSenderManager.this.listener.onNoNetworkAccess();
                    }
                });
                Log.i(RemoteInstallationSenderManager.TAG, "Remote Installation - Error on discover: " + e2);
            }
        }
    }

    private class SocketClientThread extends AsyncTask<Void, Void, Boolean> {
        private String app;
        private ReceiverDevice device;

        public SocketClientThread(ReceiverDevice receiverDevice, String str) {
            this.device = receiverDevice;
            this.app = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code duplicated, block: B:101:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:126:? A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x01b9  */
        /* JADX WARN: Code duplicated, block: B:89:0x01da  */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Void... voidArr) throws Throwable {
            PrintWriter printWriter;
            BufferedReader bufferedReader;
            Throwable th;
            Socket socket;
            Throwable th2;
            Socket socket2 = null;
            try {
                socket = new Socket(this.device.getAddress(), this.device.getPort());
                try {
                    socket.setSoTimeout(RemoteInstallationSenderManager.TIMEOUT);
                    printWriter = new PrintWriter(socket.getOutputStream(), true);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        try {
                            printWriter.println(RemoteInstallationSenderManager.PAYLOAD_TAG + this.app);
                            String str = RemoteInstallationSenderManager.TAG;
                            Log.i(str, "Remote Install - SocketClientThread Sent: apkinstall_appid=" + this.app);
                            String line = bufferedReader.readLine();
                            Log.i(str, "Remote Install - SocketClientThread Received: " + line);
                            if (line.equals(RemoteInstallationSenderManager.SUCCESS_TAG + this.app)) {
                                Boolean bool = Boolean.TRUE;
                                if (!socket.isClosed()) {
                                    try {
                                        socket.close();
                                    } catch (IOException e2) {
                                        Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread Closing Error: " + e2);
                                    }
                                }
                                printWriter.close();
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread BR Closing Error: " + e3);
                                }
                                return bool;
                            }
                            if (!line.equals(RemoteInstallationSenderManager.INVALID_PAYLOAD_RESPONSE)) {
                                if (!socket.isClosed()) {
                                    try {
                                        socket.close();
                                    } catch (IOException e4) {
                                        Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread Closing Error: " + e4);
                                    }
                                }
                                printWriter.close();
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread BR Closing Error: " + e5);
                                }
                                return Boolean.FALSE;
                            }
                            Boolean bool2 = Boolean.FALSE;
                            if (!socket.isClosed()) {
                                try {
                                    socket.close();
                                } catch (IOException e6) {
                                    Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread Closing Error: " + e6);
                                }
                            }
                            printWriter.close();
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                                Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread BR Closing Error: " + e7);
                            }
                            return bool2;
                        } catch (IOException unused) {
                            socket2 = socket;
                            try {
                                Boolean bool3 = Boolean.FALSE;
                                if (socket2 != null && !socket2.isClosed()) {
                                    try {
                                        socket2.close();
                                    } catch (IOException e8) {
                                        Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread Closing Error: " + e8);
                                    }
                                }
                                if (printWriter != null) {
                                    printWriter.close();
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e9) {
                                        Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread BR Closing Error: " + e9);
                                    }
                                }
                                return bool3;
                            } catch (Throwable th3) {
                                th2 = th3;
                                socket = socket2;
                                th = th2;
                                if (socket != null && !socket.isClosed()) {
                                    try {
                                        socket.close();
                                    } catch (IOException e10) {
                                        Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread Closing Error: " + e10);
                                    }
                                }
                                if (printWriter != null) {
                                    printWriter.close();
                                }
                                if (bufferedReader == null) {
                                    throw th;
                                }
                                try {
                                    bufferedReader.close();
                                    throw th;
                                } catch (IOException e11) {
                                    Log.e(RemoteInstallationSenderManager.TAG, "Remote Install - SocketClientThread BR Closing Error: " + e11);
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (socket != null) {
                                socket.close();
                            }
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            if (bufferedReader == null) {
                                throw th;
                            }
                            bufferedReader.close();
                            throw th;
                        }
                    } catch (IOException unused2) {
                        bufferedReader = null;
                    } catch (Throwable th5) {
                        th2 = th5;
                        bufferedReader = null;
                        th = th2;
                        if (socket != null) {
                            socket.close();
                        }
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        if (bufferedReader == null) {
                            throw th;
                        }
                        bufferedReader.close();
                        throw th;
                    }
                } catch (IOException unused3) {
                    printWriter = null;
                    bufferedReader = null;
                } catch (Throwable th6) {
                    bufferedReader = null;
                    th = th6;
                    printWriter = null;
                }
            } catch (IOException unused4) {
                printWriter = null;
                bufferedReader = null;
            } catch (Throwable th7) {
                printWriter = null;
                bufferedReader = null;
                th = th7;
                socket = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                RemoteInstallationSenderManager.this.listener.onAppSendSuccess();
            } else {
                RemoteInstallationSenderManager.this.listener.onAppSendUnsuccess();
            }
            super.onPostExecute(bool);
        }
    }

    public RemoteInstallationSenderManager(Context context) {
        this.context = context;
    }

    public void discoverAptoideTVServices(RemoteInstallationSenderListener remoteInstallationSenderListener) {
        this.listener = remoteInstallationSenderListener;
        new Thread(new AnonymousClass1()).start();
        runOnUiThread(new Runnable() { // from class: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager.2
            @Override // java.lang.Runnable
            public void run() {
                RemoteInstallationSenderManager.this.stopDiscoveringAptoideTVServices();
            }
        }, 20000L);
    }

    InetAddress getAddress() throws UnknownHostException {
        int ipAddress = ((WifiManager) this.context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
        return InetAddress.getByAddress(new byte[]{(byte) (ipAddress & 255), (byte) ((ipAddress >> 8) & 255), (byte) ((ipAddress >> 16) & 255), (byte) ((ipAddress >> 24) & 255)});
    }

    void runOnUiThread(Runnable runnable) {
        this.handler.post(runnable);
    }

    public void sendAppId(ReceiverDevice receiverDevice, String str) {
        SocketClientThread socketClientThread = new SocketClientThread(receiverDevice, str);
        this.clientServerThread = socketClientThread;
        socketClientThread.execute(new Void[0]);
    }

    public void stopDiscoveringAptoideTVServices() {
        new AsyncTask<Void, Void, Void>() { // from class: cm.aptoide.pt.install.remote.RemoteInstallationSenderManager.3
            private boolean closed = false;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                try {
                    a aVar = RemoteInstallationSenderManager.this.jmDNS;
                    if (aVar != null) {
                        aVar.B();
                        RemoteInstallationSenderManager.this.jmDNS.close();
                        this.closed = true;
                        RemoteInstallationSenderManager.this.jmDNS = null;
                    }
                    WifiManager.MulticastLock multicastLock = RemoteInstallationSenderManager.this.multicastLock;
                    if (multicastLock != null) {
                        multicastLock.release();
                        RemoteInstallationSenderManager.this.multicastLock = null;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Void r2) {
                if (this.closed) {
                    RemoteInstallationSenderManager.this.listener.onDiscoveryStopped();
                }
                super.onPostExecute(r2);
            }
        }.execute(null);
    }

    void runOnUiThread(Runnable runnable, long j2) {
        this.handler.postDelayed(runnable, j2);
    }
}
