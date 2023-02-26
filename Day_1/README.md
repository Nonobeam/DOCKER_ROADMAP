***In Day_1, we will introduce you to Docker***

![image](https://user-images.githubusercontent.com/80208064/221407416-79b1f6f5-c8e0-4515-8b1e-270f65947df0.png)
<br/>
The Docker technology uses the Linux kernel and features of the kernel, like Cgroups and namespaces, to segregate processes so they can run independently.


*SIMPLY ARCHITECTURE* <br/>
Dockerfile > Docker Image > Docker Container <br/>

Dockerfile is written down as a text file but without filename extension. This text file contains all the commands that users will use to assemble the line code. Some basic syntaxs are listed below
> ```INSTRUCTION``` (must be cappitalized). Each INSTRUCTION will be used for each different command only.
> ```FROM``` have to be used for starting any Dockerfile for defining what is the root Docker Image.

Docker Image is a file system used to execute code in a Docker container and will be build from a Dockerfile
> is a read-only template that contains a set of instruction for creating the Docker container that can run on the Docker platform.<br/>
> is a convenient way to package up application and configured server environment.<br/>

Docker Container is a sandbox where you push your code to it and easily run in any computer. It also use as "folder" (or in this case we call it container) storing Docker Images and of cause it is immutable.<br/>
> is a runnable instance of an image. You can create, start, stop, move, or delete a container using the DockerAPI or CLI.<br/>
> can be run on local machines, virtual machines or deployed to the cloud.<br/>
> is portable (can be run on any OS).<br/>
> is isolated from other containers and runs its own software, binaries, and configurations.<br/>





