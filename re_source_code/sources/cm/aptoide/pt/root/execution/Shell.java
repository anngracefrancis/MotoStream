package cm.aptoide.pt.root.execution;

import android.content.Context;
import android.os.Build;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.root.RootShell;
import cm.aptoide.pt.root.exceptions.RootDeniedException;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class Shell {
    private static final String token = "F*D^W@#FGF";
    private boolean close;
    private String error;
    private final BufferedReader errorStream;
    private Runnable input;
    private final BufferedReader inputStream;
    private boolean isCleaning;
    private Boolean isSELinuxEnforcing;
    private int maxCommands;
    private Runnable output;
    private final OutputStreamWriter outputStream;
    private final Process proc;
    private int read;
    private ShellContext shellContext;
    private int shellTimeout;
    private ShellType shellType;
    private int totalExecuted;
    private int totalRead;
    private int write;
    public static ShellContext defaultContext = ShellContext.NORMAL;
    private static Shell rootShell = null;
    private static Shell shell = null;
    private static Shell customShell = null;
    private static String[] suVersion = {null, null};
    private final List<Command> commands = new ArrayList();
    public boolean isExecuting = false;
    public boolean isReading = false;
    public boolean isClosed = false;

    public enum ShellContext {
        NORMAL("normal"),
        SHELL("u:r:shell:s0"),
        SYSTEM_SERVER("u:r:system_server:s0"),
        SYSTEM_APP("u:r:system_app:s0"),
        PLATFORM_APP("u:r:platform_app:s0"),
        UNTRUSTED_APP("u:r:untrusted_app:s0"),
        RECOVERY("u:r:recovery:s0");

        private String value;

        ShellContext(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum ShellType {
        NORMAL,
        ROOT,
        CUSTOM
    }

    protected static class Worker extends Thread {
        public int exit;
        public Shell shell;

        private void setShellOom() {
            Field declaredField;
            try {
                Class<?> cls = this.shell.proc.getClass();
                try {
                    declaredField = cls.getDeclaredField("pid");
                } catch (NoSuchFieldException unused) {
                    declaredField = cls.getDeclaredField(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                }
                declaredField.setAccessible(true);
                int iIntValue = ((Integer) declaredField.get(this.shell.proc)).intValue();
                this.shell.outputStream.write("(echo -17 > /proc/" + iIntValue + "/oom_adj) &> /dev/null\n");
                this.shell.outputStream.write("(echo -17 > /proc/$$/oom_adj) &> /dev/null\n");
                this.shell.outputStream.flush();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.shell.outputStream.write("echo Started\n");
                this.shell.outputStream.flush();
                while (true) {
                    String line = this.shell.inputStream.readLine();
                    if (line == null) {
                        throw new EOFException();
                    }
                    if (!HttpUrl.FRAGMENT_ENCODE_SET.equals(line)) {
                        if ("Started".equals(line)) {
                            this.exit = 1;
                            setShellOom();
                            return;
                        }
                        this.shell.error = "unknown error occurred.";
                    }
                }
            } catch (IOException e2) {
                this.exit = -42;
                if (e2.getMessage() == null) {
                    this.shell.error = "RootAccess denied?.";
                } else {
                    this.shell.error = e2.getMessage();
                }
            }
        }

        private Worker(Shell shell) {
            this.exit = -911;
            this.shell = shell;
        }
    }

    private Shell(String str, ShellType shellType, ShellContext shellContext, int i2) throws RootDeniedException, TimeoutException, IOException {
        this.shellTimeout = 25000;
        this.shellType = null;
        ShellContext shellContext2 = ShellContext.NORMAL;
        this.shellContext = shellContext2;
        this.error = HttpUrl.FRAGMENT_ENCODE_SET;
        this.close = false;
        this.isSELinuxEnforcing = null;
        this.maxCommands = 5000;
        this.read = 0;
        this.write = 0;
        this.totalExecuted = 0;
        this.totalRead = 0;
        this.isCleaning = false;
        this.input = new Runnable() { // from class: cm.aptoide.pt.root.execution.Shell.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        try {
                            synchronized (Shell.this.commands) {
                                while (!Shell.this.close && Shell.this.write >= Shell.this.commands.size()) {
                                    Shell shell2 = Shell.this;
                                    shell2.isExecuting = false;
                                    shell2.commands.wait();
                                }
                            }
                            if (Shell.this.write >= Shell.this.maxCommands) {
                                while (Shell.this.read != Shell.this.write) {
                                    RootShell.log("Waiting for read and write to catch up before cleanup.");
                                }
                                Shell.this.cleanCommands();
                            }
                            if (Shell.this.write < Shell.this.commands.size()) {
                                Shell shell3 = Shell.this;
                                shell3.isExecuting = true;
                                Command command = (Command) shell3.commands.get(Shell.this.write);
                                command.startExecution();
                                RootShell.log("Executing: " + command.getCommand() + " with context: " + Shell.this.shellContext);
                                Shell.this.outputStream.write(command.getCommand());
                                Shell.this.outputStream.flush();
                                Shell.this.outputStream.write("\necho F*D^W@#FGF " + Shell.this.totalExecuted + " $?\n");
                                Shell.this.outputStream.flush();
                                Shell.access$208(Shell.this);
                                Shell.access$808(Shell.this);
                            } else if (Shell.this.close) {
                                Shell shell4 = Shell.this;
                                shell4.isExecuting = false;
                                shell4.outputStream.write("\nexit 0\n");
                                Shell.this.outputStream.flush();
                                RootShell.log("Closing shell");
                                Shell.this.write = 0;
                                Shell shell5 = Shell.this;
                                shell5.closeQuietly(shell5.outputStream);
                                return;
                            }
                        } catch (Throwable th) {
                            Shell.this.write = 0;
                            Shell shell6 = Shell.this;
                            shell6.closeQuietly(shell6.outputStream);
                            throw th;
                        }
                    } catch (IOException | InterruptedException e2) {
                        RootShell.log(e2.getMessage(), RootShell.LogLevel.ERROR, e2);
                        Shell.this.write = 0;
                        Shell shell7 = Shell.this;
                        shell7.closeQuietly(shell7.outputStream);
                        return;
                    }
                }
            }
        };
        this.output = new Runnable() { // from class: cm.aptoide.pt.root.execution.Shell.2
            @Override // java.lang.Runnable
            public void run() {
                Command command;
                int i3;
                int i4;
                loop0: while (true) {
                    command = null;
                    while (true) {
                        try {
                            try {
                                if (Shell.this.close && !Shell.this.inputStream.ready() && Shell.this.read >= Shell.this.commands.size()) {
                                    break loop0;
                                }
                                Shell shell2 = Shell.this;
                                shell2.isReading = false;
                                String line = shell2.inputStream.readLine();
                                Shell shell3 = Shell.this;
                                shell3.isReading = true;
                                if (line == null) {
                                    break loop0;
                                }
                                if (command == null) {
                                    if (shell3.read < Shell.this.commands.size()) {
                                        command = (Command) Shell.this.commands.get(Shell.this.read);
                                    } else if (Shell.this.close) {
                                        break loop0;
                                    }
                                }
                                int iIndexOf = line.indexOf(Shell.token);
                                i3 = -1;
                                if (iIndexOf == -1) {
                                    command.output(command.id, line);
                                } else if (iIndexOf > 0) {
                                    RootShell.log("Found token, line: " + line);
                                    command.output(command.id, line.substring(0, iIndexOf));
                                }
                                if (iIndexOf >= 0) {
                                    String[] strArrSplit = line.substring(iIndexOf).split(" ");
                                    if (strArrSplit.length >= 2 && strArrSplit[1] != null) {
                                        try {
                                            i4 = Integer.parseInt(strArrSplit[1]);
                                        } catch (NumberFormatException unused) {
                                            i4 = 0;
                                        }
                                        try {
                                            i3 = Integer.parseInt(strArrSplit[2]);
                                        } catch (NumberFormatException unused2) {
                                        }
                                        if (i4 == Shell.this.totalRead) {
                                            break;
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            } catch (IOException e2) {
                                RootShell.log(e2.getMessage(), RootShell.LogLevel.ERROR, e2);
                            }
                        } catch (Throwable th) {
                            Shell shell4 = Shell.this;
                            shell4.closeQuietly(shell4.outputStream);
                            Shell shell5 = Shell.this;
                            shell5.closeQuietly(shell5.errorStream);
                            Shell shell6 = Shell.this;
                            shell6.closeQuietly(shell6.inputStream);
                            RootShell.log("Shell destroyed");
                            Shell shell7 = Shell.this;
                            shell7.isClosed = true;
                            shell7.isReading = false;
                            throw th;
                        }
                    }
                    Shell.this.processErrors(command);
                    int i5 = 0;
                    while (command.totalOutput > command.totalOutputProcessed) {
                        if (i5 == 0) {
                            i5++;
                            RootShell.log("Waiting for output to be processed. " + command.totalOutputProcessed + " Of " + command.totalOutput);
                        }
                        try {
                            synchronized (this) {
                                try {
                                    wait(2000L);
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        } catch (Exception e3) {
                            RootShell.log(e3.getMessage());
                        }
                    }
                    RootShell.log("Read all output");
                    command.setExitCode(i3);
                    command.commandFinished();
                    Shell.access$408(Shell.this);
                    Shell.access$1108(Shell.this);
                }
                try {
                    Shell.this.proc.waitFor();
                    Shell.this.proc.destroy();
                } catch (Exception unused3) {
                }
                while (Shell.this.read < Shell.this.commands.size()) {
                    if (command == null) {
                        command = (Command) Shell.this.commands.get(Shell.this.read);
                    }
                    if (command.totalOutput < command.totalOutputProcessed) {
                        command.terminated("All output not processed!");
                        command.terminated("Did you forget the super.commandOutput call or are you waiting on the command object?");
                    } else {
                        command.terminated("Unexpected Termination.");
                    }
                    Shell.access$408(Shell.this);
                    command = null;
                }
                Shell.this.read = 0;
                Shell shell8 = Shell.this;
                shell8.closeQuietly(shell8.outputStream);
                Shell shell9 = Shell.this;
                shell9.closeQuietly(shell9.errorStream);
                Shell shell10 = Shell.this;
                shell10.closeQuietly(shell10.inputStream);
                RootShell.log("Shell destroyed");
                Shell shell11 = Shell.this;
                shell11.isClosed = true;
                shell11.isReading = false;
            }
        };
        RootShell.log("Starting shell: " + str);
        RootShell.log("Context: " + shellContext.getValue());
        RootShell.log("Timeout: " + i2);
        this.shellType = shellType;
        this.shellTimeout = i2 <= 0 ? this.shellTimeout : i2;
        this.shellContext = shellContext;
        if (shellContext == shellContext2) {
            this.proc = Runtime.getRuntime().exec(str);
        } else {
            String suVersion2 = getSuVersion(false);
            String suVersion3 = getSuVersion(true);
            if (!isSELinuxEnforcing() || suVersion2 == null || suVersion3 == null || !suVersion2.endsWith("SUPERSU") || Integer.valueOf(suVersion3).intValue() < 190) {
                RootShell.log("Su binary --context switch not supported!");
                RootShell.log("Su binary display version: " + suVersion2);
                RootShell.log("Su binary internal version: " + suVersion3);
                RootShell.log("SELinuxEnforcing: " + isSELinuxEnforcing());
            } else {
                str = str + " --context " + this.shellContext.getValue();
            }
            this.proc = Runtime.getRuntime().exec(str);
        }
        this.inputStream = new BufferedReader(new InputStreamReader(this.proc.getInputStream(), "UTF-8"));
        this.errorStream = new BufferedReader(new InputStreamReader(this.proc.getErrorStream(), "UTF-8"));
        this.outputStream = new OutputStreamWriter(this.proc.getOutputStream(), "UTF-8");
        Worker worker = new Worker();
        worker.start();
        try {
            worker.join(this.shellTimeout);
            int i3 = worker.exit;
            if (i3 == -911) {
                try {
                    this.proc.destroy();
                } catch (Exception unused) {
                }
                closeQuietly(this.inputStream);
                closeQuietly(this.errorStream);
                closeQuietly(this.outputStream);
                throw new TimeoutException(this.error);
            }
            if (i3 == -42) {
                try {
                    this.proc.destroy();
                } catch (Exception unused2) {
                }
                closeQuietly(this.inputStream);
                closeQuietly(this.errorStream);
                closeQuietly(this.outputStream);
                throw new RootDeniedException("Root Access Denied");
            }
            Thread thread = new Thread(this.input, "Shell Input");
            thread.setPriority(5);
            thread.start();
            Thread thread2 = new Thread(this.output, "Shell Output");
            thread2.setPriority(5);
            thread2.start();
        } catch (InterruptedException unused3) {
            worker.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    static /* synthetic */ int access$1108(Shell shell2) {
        int i2 = shell2.totalRead;
        shell2.totalRead = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$208(Shell shell2) {
        int i2 = shell2.write;
        shell2.write = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$408(Shell shell2) {
        int i2 = shell2.read;
        shell2.read = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$808(Shell shell2) {
        int i2 = shell2.totalExecuted;
        shell2.totalExecuted = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cleanCommands() {
        this.isCleaning = true;
        int i2 = this.maxCommands;
        int iAbs = Math.abs(i2 - (i2 / 4));
        RootShell.log("Cleaning up: " + iAbs);
        for (int i3 = 0; i3 < iAbs; i3++) {
            this.commands.remove(0);
        }
        this.read = this.commands.size() - 1;
        this.write = this.commands.size() - 1;
        this.isCleaning = false;
    }

    public static void closeAll() throws IOException {
        RootShell.log("Request to close all shells!");
        closeShell();
        closeRootShell();
        closeCustomShell();
    }

    public static void closeCustomShell() throws IOException {
        RootShell.log("Request to close custom shell!");
        Shell shell2 = customShell;
        if (shell2 == null) {
            return;
        }
        shell2.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeQuietly(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void closeRootShell() throws IOException {
        RootShell.log("Request to close root shell!");
        Shell shell2 = rootShell;
        if (shell2 == null) {
            return;
        }
        shell2.close();
    }

    public static void closeShell() throws IOException {
        RootShell.log("Request to close normal shell!");
        Shell shell2 = shell;
        if (shell2 == null) {
            return;
        }
        shell2.close();
    }

    public static Shell getOpenShell() {
        Shell shell2 = customShell;
        if (shell2 != null) {
            return shell2;
        }
        Shell shell3 = rootShell;
        return shell3 != null ? shell3 : shell;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004c A[Catch: all -> 0x007b, TryCatch #3 {, blocks: (B:6:0x0006, B:9:0x000d, B:13:0x0018, B:14:0x001f, B:15:0x0032, B:17:0x0038, B:19:0x003c, B:20:0x003f, B:21:0x0046, B:23:0x004c, B:25:0x0054, B:28:0x005d, B:31:0x0064, B:33:0x006a, B:37:0x0070, B:40:0x0075), top: B:55:0x0006, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0046 A[SYNTHETIC] */
    private synchronized String getSuVersion(boolean z) {
        char c2;
        String str;
        c2 = z ? (char) 0 : (char) 1;
        if (suVersion[c2] == null) {
            str = null;
            try {
                Process processExec = Runtime.getRuntime().exec(z ? "su -V" : "su -v", (String[]) null);
                processExec.waitFor();
                ArrayList<String> arrayList = new ArrayList();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        arrayList.add(line);
                    } catch (IOException unused) {
                    }
                }
                bufferedReader.close();
                processExec.destroy();
                for (String str2 : arrayList) {
                    if (z) {
                        if (str2.contains(".")) {
                            str = str2;
                            break;
                        }
                    } else {
                        try {
                            if (Integer.parseInt(str2) > 0) {
                                str = str2;
                                break;
                            }
                        } catch (NumberFormatException unused2) {
                            continue;
                        }
                    }
                }
                suVersion[c2] = str;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            } catch (InterruptedException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return suVersion[c2];
        try {
            bufferedReader.close();
        } catch (IOException unused3) {
        }
        processExec.destroy();
        while (r2.hasNext()) {
            if (z) {
                if (Integer.parseInt(str2) > 0) {
                    str = str2;
                    break;
                }
            } else {
                if (str2.contains(".")) {
                    str = str2;
                    break;
                }
            }
        }
        suVersion[c2] = str;
        return suVersion[c2];
    }

    public static boolean isAnyShellOpen() {
        return (shell == null && rootShell == null && customShell == null) ? false : true;
    }

    public static boolean isCustomShellOpen() {
        return customShell == null;
    }

    public static boolean isRootShellOpen() {
        return rootShell == null;
    }

    public static boolean isShellOpen() {
        return shell == null;
    }

    public static Command runCommand(Command command) throws TimeoutException, IOException {
        return startShell().add(command);
    }

    public static Command runRootCommand(Command command) throws RootDeniedException, TimeoutException, IOException {
        return startRootShell().add(command);
    }

    public static Shell startCustomShell(String str) throws RootDeniedException, TimeoutException, IOException {
        return startCustomShell(str, 0);
    }

    public static Shell startRootShell() throws RootDeniedException, TimeoutException, IOException {
        return startRootShell(0, 3);
    }

    public static Shell startShell() throws TimeoutException, IOException {
        return startShell(0);
    }

    public Command add(Command command) throws IOException {
        if (this.close) {
            throw new IllegalStateException("Unable to add commands to a closed shell");
        }
        if (command.used) {
            throw new IllegalStateException("This command has already been executed. (Don't re-use command instances.)");
        }
        while (this.isCleaning) {
        }
        this.commands.add(command);
        notifyThreads();
        return command;
    }

    public void close() throws IOException {
        RootShell.log("Request to close shell!");
        int i2 = 0;
        while (this.isExecuting) {
            RootShell.log("Waiting on shell to finish executing before closing...");
            i2++;
            if (i2 > 10000) {
                break;
            }
        }
        synchronized (this.commands) {
            this.close = true;
            notifyThreads();
        }
        RootShell.log("Shell Closed!");
        if (this == rootShell) {
            rootShell = null;
        } else if (this == shell) {
            shell = null;
        } else if (this == customShell) {
            customShell = null;
        }
    }

    public int getCommandQueuePosition(Command command) {
        return this.commands.indexOf(command);
    }

    public String getCommandQueuePositionString(Command command) {
        return "Command is in position " + getCommandQueuePosition(command) + " currently executing command at position " + this.write + " and the number of commands is " + this.commands.size();
    }

    public synchronized boolean isSELinuxEnforcing() {
        if (this.isSELinuxEnforcing == null) {
            Boolean boolValueOf = null;
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z = true;
                if (new File("/sys/fs/selinux/enforce").exists()) {
                    try {
                        FileInputStream fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        try {
                            boolValueOf = Boolean.valueOf(fileInputStream.read() == 49);
                            fileInputStream.close();
                        } catch (Throwable th) {
                            fileInputStream.close();
                            throw th;
                        }
                    } catch (Exception unused) {
                    }
                }
                if (boolValueOf == null) {
                    if (Build.VERSION.SDK_INT < 19) {
                        z = false;
                    }
                    boolValueOf = Boolean.valueOf(z);
                }
            }
            if (boolValueOf == null) {
                boolValueOf = Boolean.FALSE;
            }
            this.isSELinuxEnforcing = boolValueOf;
        }
        return this.isSELinuxEnforcing.booleanValue();
    }

    protected void notifyThreads() {
        new Thread() { // from class: cm.aptoide.pt.root.execution.Shell.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (Shell.this.commands) {
                    Shell.this.commands.notifyAll();
                }
            }
        }.start();
    }

    public void processErrors(Command command) {
        String line;
        while (this.errorStream.ready() && command != null && (line = this.errorStream.readLine()) != null) {
            try {
                command.output(command.id, line);
            } catch (Exception e2) {
                RootShell.log(e2.getMessage(), RootShell.LogLevel.ERROR, e2);
                return;
            }
        }
    }

    public Shell switchRootShellContext(ShellContext shellContext) throws RootDeniedException, TimeoutException, IOException {
        if (this.shellType != ShellType.ROOT) {
            RootShell.log("Can only switch context on a root shell!");
            return this;
        }
        try {
            closeRootShell();
        } catch (Exception unused) {
            RootShell.log("Problem closing shell while trying to switch context...");
        }
        return startRootShell(this.shellTimeout, shellContext, 0);
    }

    public final void useCWD(Context context) throws RootDeniedException, TimeoutException, IOException {
        add(new Command(-1, false, "cd " + context.getApplicationInfo().dataDir));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeQuietly(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception unused) {
            }
        }
    }

    public static Shell startCustomShell(String str, int i2) throws RootDeniedException, TimeoutException, IOException {
        if (customShell == null) {
            RootShell.log("Starting Custom Shell!");
            customShell = new Shell(str, ShellType.CUSTOM, ShellContext.NORMAL, i2);
        } else {
            RootShell.log("Using Existing Custom Shell!");
        }
        return customShell;
    }

    public static Shell startRootShell(int i2) throws RootDeniedException, TimeoutException, IOException {
        return startRootShell(i2, 3);
    }

    public static Shell startShell(int i2) throws TimeoutException, IOException {
        try {
            if (shell == null) {
                RootShell.log("Starting Shell!");
                shell = new Shell("/system/bin/sh", ShellType.NORMAL, ShellContext.NORMAL, i2);
            } else {
                RootShell.log("Using Existing Shell!");
            }
            return shell;
        } catch (RootDeniedException unused) {
            throw new IOException();
        }
    }

    public static Shell startRootShell(int i2, int i3) throws RootDeniedException, TimeoutException, IOException {
        return startRootShell(i2, defaultContext, i3);
    }

    public static Shell startRootShell(int i2, ShellContext shellContext, int i3) throws RootDeniedException, TimeoutException, IOException {
        int i4;
        Shell shell2 = rootShell;
        if (shell2 == null) {
            RootShell.log("Starting Root Shell!");
            int i5 = 0;
            while (rootShell == null) {
                try {
                    RootShell.log("Trying to open Root Shell, attempt #" + i5);
                    rootShell = new Shell("su", ShellType.ROOT, shellContext, i2);
                } catch (RootDeniedException e2) {
                    throw e2;
                } catch (IOException e3) {
                    i4 = i5 + 1;
                    if (i5 >= i3) {
                        RootShell.log("IOException, could not start shell");
                        throw e3;
                    }
                    i5 = i4;
                } catch (TimeoutException e4) {
                    i4 = i5 + 1;
                    if (i5 >= i3) {
                        RootShell.log("TimeoutException, could not start shell");
                        throw e4;
                    }
                    i5 = i4;
                }
            }
        } else if (shell2.shellContext != shellContext) {
            try {
                RootShell.log("Context is different than open shell, switching context... " + rootShell.shellContext + " VS " + shellContext);
                rootShell.switchRootShellContext(shellContext);
            } catch (RootDeniedException e5) {
                if (i3 <= 0) {
                    RootShell.log("RootDeniedException, could not switch context!");
                    throw e5;
                }
            } catch (IOException e6) {
                if (i3 <= 0) {
                    RootShell.log("IOException, could not switch context!");
                    throw e6;
                }
            } catch (TimeoutException e7) {
                if (i3 <= 0) {
                    RootShell.log("TimeoutException, could not switch context!");
                    throw e7;
                }
            }
        } else {
            RootShell.log("Using Existing Root Shell!");
        }
        return rootShell;
    }
}
