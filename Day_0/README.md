***Install Docker Desktop on Windows***

![image](https://user-images.githubusercontent.com/80208064/221410106-db11a989-2fe1-4798-9684-a0897242d43f.png)

This markdown contains information about Docker Desktop for Windows system requirements, download URL, instructions to install and update Docker Desktop for Windows.

```DOWNLOAD URL```

[https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe](https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe)


```SYSTEM REQUIREMENTS```

WSL (Windows Subsystem for Linux) 2 backend
Windows 11 64-bit: Home or Pro version 21H2 or higher, or Enterprise or Education version 21H2 or higher.<br/>
Windows 10 64-bit: Home or Pro 21H1 (build 19043) or higher, or Enterprise or Education 20H2 (build 19042) or higher.<br/>
Enable the WSL 2 feature on Windows. For detailed instructions, refer to the Microsoft documentation.<br/>
In case you need to download WSL, down here is what you need.<br/>
[https://learn.microsoft.com/en-us/windows/wsl/install](https://learn.microsoft.com/en-us/windows/wsl/install)

The following hardware prerequisites are required to successfully run WSL 2 on Windows 10 or Windows 11:<br/>

64-bit processor with Second Level Address Translation (SLAT)<br/>
4GB system RAM<br/>
BIOS-level hardware virtualization support must be enabled in the BIOS settings. For more information, see Virtualization.<br/>
Download and install the Linux kernel update package.<br/>

```INSTRUCTION TO INSTALL```

After downloading Docker Desktop Installer.exe, run the following command in a terminal to install Docker Desktop:<br/>
```"Docker Desktop Installer.exe" install```

If you’re using PowerShell you should run it as:<br/>
```Start-Process 'Docker Desktop Installer.exe' -Wait install```

If using the Windows Command Prompt: <br/>
```start /w "" "Docker Desktop Installer.exe" install```





In case you need some admin setting, below here is all what you need.
[https://docs.docker.com/desktop/install/windows-install/](https://docs.docker.com/desktop/install/windows-install/)
